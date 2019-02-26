//package org.cmsideproject.config;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.cmsideproject.exception.DTOParseFailException;
//import org.cmsideproject.exception.ElasticSearchRequestException;
//import org.cmsideproject.exception.ErrorInputException;
//import org.cmsideproject.minerva.entity.GetResponse;
//import org.cmsideproject.minerva.entity.MinervaResponseStatus;
//import org.cmsideproject.minerva.entity.PostResponse;
//import org.springframework.context.annotation.Configuration;
//
//@Aspect
//@Configuration
//public class MinervaAccessAspect {
//	private Logger logger = LogManager.getLogger(this.getClass());
//
//	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
//	public void before(JoinPoint joinPoint) {
//
//		logger.info(" \n ======================= [{}]", joinPoint);
//
//		logger.info(" \nMinverva service start \n");
//		String args = "\nRequest Args: ";
//
//		for (Object object : joinPoint.getArgs()) {
//			args += object;
//		}
//		logger.info(args);
//		logger.info(" \n =======================");
//	}
//
//	@Around(value = "execution(* org.cmsideproject.minerva.controller.*.get*(..))")
//	public GetResponse around(ProceedingJoinPoint joinPoint) {
//		GetResponse resJson = null;
//		MinervaResponseStatus status = null;
//		String msg = null;
//		String statusCode = null;
//		Object data = null;
//		System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName()
//				+ ": Before Method Execution");
//		try {
//			Object test = joinPoint.proceed();
//			statusCode = "100";
//			status = MinervaResponseStatus.success;
//			data = joinPoint.getArgs();
//			msg = "success";
//		} catch (ErrorInputException | ElasticSearchRequestException e) {
//			statusCode = e.getCode();
//			msg = e.getMessage();
//			status = MinervaResponseStatus.fail;
//			logger.info("" + e);
//			e.printStackTrace();
//		} catch (DTOParseFailException e) {
//			statusCode = e.getCode();
//			msg = e.getMessage();
//			status = MinervaResponseStatus.fail;
//			logger.info("" + e.getStackTrace());
//			e.printStackTrace();
//		} catch (Throwable e) {
//			statusCode = "-1";
//			msg = "unexpected error";
//			status = MinervaResponseStatus.error;
//			logger.info("" + e.getStackTrace());
//			e.printStackTrace();
//		} finally {
//			resJson = new GetResponse.Builder().message(msg).statusCode(statusCode).build();
//		}
//
//		return resJson;
//	}
//
//	@After("execution(* org.cmsideproject.minerva.controller.*.*(..))")
//	public void after2(JoinPoint joinPoint) {
//		// Advice
//		logger.info(" \n ======================= [{}]", joinPoint);
//
//		logger.info(" \nMinverva service end \n");
//
//		String args = "\nRequest Args: ";
//
//		for (Object object : joinPoint.getArgs()) {
//			args += object;
//		}
//		logger.info(args);
//
//		logger.info(" \n =======================");
//	}
//
//	/** MinervaResponse version **/
////	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
////	public void before(JoinPoint joinPoint) {
////
////		logger.info(" \n ======================= [{}]", joinPoint);
////
////		logger.info(" \nMinverva service start \n");
////		String args = "\nRequest Args: ";
////
////		for (Object object : joinPoint.getArgs()) {
////			args += object;
////		}
////		logger.info(args);
////		logger.info(" \n =======================");
////	}
////
////	@Around(value = "execution(* org.cmsideproject.minerva.controller.*.*(..))")
////	public MinervaResponse around(ProceedingJoinPoint joinPoint) {
////		MinervaResponse resJson = null;
////		MinervaResponseStatus status = null;
////		String msg = null;
////		String statusCode = null;
////		Object data = null;
////		System.out.println("****LoggingAspect.logAroundGetEmployee() : " + joinPoint.getSignature().getName()
////				+ ": Before Method Execution");
////		try {
////			Object test = joinPoint.proceed();
////			statusCode = "100";
////			status = MinervaResponseStatus.success;
////			data = joinPoint.getArgs();
////			msg = "success";
////		} catch (ErrorInputException | ElasticSearchRequestException e) {
////			statusCode = e.getCode();
////			msg = e.getMessage();
////			status = MinervaResponseStatus.fail;
////			logger.info("" + e);
////			e.printStackTrace();
////		} catch (DTOParseFailException e) {
////			statusCode = e.getCode();
////			msg = e.getMessage();
////			status = MinervaResponseStatus.fail;
////			logger.info("" + e.getStackTrace());
////			e.printStackTrace();
////		} catch (Throwable e) {
////			statusCode = "-1";
////			msg = "unexpected error";
////			status = MinervaResponseStatus.error;
////			logger.info("" + e.getStackTrace());
////			e.printStackTrace();
////		} finally {
////			resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatusCode(statusCode)
////					.setStatus(status).setData((Collection<?>) data).build();
////		}
////
////		return resJson;
////	}
////
////	@After("execution(* org.cmsideproject.minerva.controller.*.*(..))")
////	public void after2(JoinPoint joinPoint) {
////		// Advice
////		logger.info(" \n ======================= [{}]", joinPoint);
////
////		logger.info(" \nMinverva service end \n");
////
////		String args = "\nRequest Args: ";
////
////		for (Object object : joinPoint.getArgs()) {
////			args += object;
////		}
////		logger.info(args);
////
////		logger.info(" \n =======================");
////	}
//
//}
