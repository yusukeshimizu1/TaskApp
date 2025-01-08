package com.example.todo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {
	
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {
		 
		 log.info("コントローラのメソッド開始：" + jp.getSignature());
		 
		 try {
			 Object result = jp.proceed();
			 
			 log.info("コントローラのメソッド終了：" + jp.getSignature());
			 
			 return result;
			 
		 } catch(Exception e) {
			 log.error("コントローラのメソッド異常終了：" + jp.getSignature());
			 
			 throw e;
		 }
	 }
}
