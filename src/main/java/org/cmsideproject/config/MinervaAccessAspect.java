package org.cmsideproject.config;

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
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.MinervaResponseStatus;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MinervaAccessAspect {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	private MinervaLogImp logger1 = new MinervaLogImp(this.getClass());
	
	MinervaResponse resJson = null;

	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {

		logger1.TicketInfo(" \n ======================= [{}]", joinPoint);

		logger1.TicketInfo(" \nMinverva service start \n");
		
		String args = "\nRequest Args: ";

		for (Object object : joinPoint.getArgs()) {
			args += object;
		}
		logger.info(args);
		logger.info(" \n =======================");
	}

	@Around(value = "execution(* org.cmsideproject.minerva.controller.*.get*(..))")
	public MinervaResponse around(ProceedingJoinPoint joinPoint) {
		MinervaResponse resJson = new MinervaResponse();
		MinervaResponseStatus status = null;
		String msg = null;
		String statusCode = null;
		Object data = null;
		try {
			resJson = (MinervaResponse) joinPoint.proceed();
			statusCode = "100";
			status = MinervaResponseStatus.success;
			data = joinPoint.getArgs();
			msg = "success";
		} catch (ErrorInputException | ElasticSearchRequestException e) {
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
			logger1.TicketInfo("" + e.getStackTrace());
			e.printStackTrace();
		} finally {
			resJson = new MinervaResponse.MinervaResponseMsgBuilder().message(msg).statusCode(statusCode).data(resJson.getData()).build();
		}

		return resJson;
	}

	@Around(value = "execution(* org.cmsideproject.minerva.controller.*.add*(..))")
	public MinervaResponse aroundAdd(ProceedingJoinPoint joinPoint) {
		MinervaResponse resJson = new MinervaResponse();
		MinervaResponseStatus status = null;
		String msg = null;
		String statusCode = null;
		Object data = null;
		try {
			resJson = (MinervaResponse) joinPoint.proceed();
			statusCode = "100";
			status = MinervaResponseStatus.success;
			data = joinPoint.getArgs();
			msg = "success";
		} catch (ErrorInputException | ElasticSearchRequestException e) {
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
			logger1.TicketInfo("" + e.getStackTrace());
			e.printStackTrace();
		} finally {
			resJson = new MinervaResponse.MinervaResponseMsgBuilder().message(msg).statusCode(statusCode).build();
		}

		return resJson;
	}
	

	@After("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void after2(JoinPoint joinPoint) {
		// Advice
		logger.info(" \n ======================= [{}]", joinPoint);

		logger.info(" \nMinverva service end \n");

		String args = "\nRequest Args: ";

		for (Object object : joinPoint.getArgs()) {
			args += object;
		}
		logger.info(args);

		logger.info(" \n =======================");
	}

}