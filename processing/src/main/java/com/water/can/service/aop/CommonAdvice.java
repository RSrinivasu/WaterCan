package com.water.can.service.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class CommonAdvice {
	
	private static Logger logger=Logger.getLogger(CommonAdvice.class);
	
	@Before("within(com.water.can.service.impl.UserServiceImpl)")
	public void myBefore(JoinPoint joinPoint){
	
		logger.info("Enterted into "+joinPoint.getSignature().getName()+" on "+joinPoint.getTarget().getClass());	
	}
	
	@AfterReturning(pointcut="within(com.water.can.service.impl.UserServiceImpl)",
	returning="returnValue")
	public void myAfter(JoinPoint joinPoint,Object returnValue){
		
	logger.info("Execution completed on : "+joinPoint.getSignature().getName()+" on "+joinPoint.getTarget().getClass()+" return value is :"+returnValue);	
	}
	@AfterThrowing(pointcut="within(com.water.can.service.impl.UserServiceImpl)",
	throwing="t")
	public void myThrows(JoinPoint joinPoint,
		Throwable t){
	logger.error("Exception Occured while executing the :"+joinPoint.getSignature().getName()+" on "+joinPoint.getTarget().getClass()+" --> "+t.getMessage());	

	}

}
