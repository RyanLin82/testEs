package org.cmsideproject.config;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.MinervaResponseStatus;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MinervaAccessAspect {
	private Logger logger = LogManager.getLogger(this.getClass());


	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("\n\n\n\nbefore\n\n\n\n\n");
		
		// Advice
		logger.info(" \nAllowed execution method: [{}]", joinPoint);
		String args = "\nRequest Args: ";

		for (Object object : joinPoint.getArgs()) {
			args += object;
		}
		logger.info(args);
	}

//	@AfterThrowing(pointcut = "execution(* org.cmsideproject.minerva.controller.*.*(..))", throwing = "ex")
//	public MinervaResponse dTOParseFailException(DTOParseFailException ex) {
//		logger.info("\n\n\n\nDTOParseFailException\n\n\n\n\n");
//		return new MinervaResponse.MinervaResponseMsgBuilder().setMessage("dTOParseFailException").setStatusCode("dTOParseFailException").build();
//	}
//	
//	@AfterThrowing(pointcut = "execution(* org.cmsideproject.minerva.controller.*.*(..))", throwing = "ex")
//	public void errorInputException(ErrorInputException ex) {
//		logger.info("ErrorInputException");
//	}
	
	


	@Around(value = "execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public MinervaResponse around(ProceedingJoinPoint joinPoint) {
		MinervaResponse resJson = null;
		MinervaResponseStatus status = null;
		String msg = null;
		String statusCode = null;
		Object data = null;
		System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName()
				+ ": Before Method Execution");
		try {
			Object test = joinPoint.proceed();
			statusCode = "100";
			status = MinervaResponseStatus.success;
			data = joinPoint.getArgs();
			msg = "success";
		} catch (ErrorInputException | ElasticSearchRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			statusCode = e.getCode();
			msg = e.getMessage();
			status = MinervaResponseStatus.fail;
			logger.info("" + e);
			e.printStackTrace();
		} catch (DTOParseFailException e) {
			statusCode = e.getCode();
			msg = e.getMessage();
			status = MinervaResponseStatus.fail;
			logger.info("" + e.getStackTrace());
			e.printStackTrace();
		} catch (Throwable e) {
			statusCode = "-1";
			msg = "unexpected error";
			status = MinervaResponseStatus.error;
			logger.info("" + e.getStackTrace());
			e.printStackTrace();
		} finally {
			resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatusCode(statusCode).setStatus(status).setData((Collection<?>) data).build();
			System.out.println("****2222222 : " + joinPoint.getSignature().getName()
					+ ": After Method Execution");
		}
		System.out.println("****1111111111 : " + joinPoint.getSignature().getName()
				+ ": After Method Execution");

		
		return resJson;
	}

	@After("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void after2(JoinPoint joinPoint) {
		// Advice
		logger.info(" \n \n\nafter2 ======================= [{}]", joinPoint);
		String args = "\nRequest Args: ";

		for (Object object : joinPoint.getArgs()) {
			args += object;
		}
		logger.info(args);
		
	}

}
