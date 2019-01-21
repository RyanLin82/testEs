package org.cmsideproject.config;

import org.aspectj.lang.JoinPoint;
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

	private MinervaResponse minervaRes;
	
	@Before("execution(* org.cmsideproject.minerva.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		minervaRes = new MinervaResponse();
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
}
