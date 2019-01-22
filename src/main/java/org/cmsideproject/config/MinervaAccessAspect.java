package org.cmsideproject.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.springframework.context.annotation.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Configuration
public class MinervaAccessAspect {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" \nAllowed execution method: [{}]", joinPoint);
		String args = "\\nRequest Args: ";
		
		for(Object object : joinPoint.getArgs()) {
			args += object;
		}
		logger.info(args);
	}
	
//	@After(value = "execution(* org.cmsideproject.minerva.controller.*.*(..))")
//	public void after(JoinPoint joinPoint) {
//		
//		logger.info("after execution of {}", joinPoint);
//	}
	
	@AfterReturning(pointcut = "execution(* org.cmsideproject.minerva.controller.*.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
	    logger.info(" \nResponse for class : {} ; \nMethod : {} ", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
	    if (result != null) {
	        logger.info(" \nResponse value : {}", result.toString());
	    } else{
	        logger.info(" \nwith null as return value.");
	    }
	}
}
