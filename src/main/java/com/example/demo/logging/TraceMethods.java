package com.example.demo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceMethods {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraceMethods.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMethod() {
        // GET CUTPOINT
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMethod() {
        // POST CUTPOINT
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void updateMethod() {
        // PUT CUTPOINT
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMethod() {
        // PUT DELETEPOINT
    }

    @Before("getMethod()")
    public void getAction(JoinPoint joinPoint) {
        // TBD
    }

    @Before("postMethod()")
    public void postAction(JoinPoint joinPoint) {
        // TBD
    }

    @Before("updateMethod()")
    public void putAction(JoinPoint joinPoint) {
        // TBD
    }

    @Before("deleteMethod()")
    public void deleteAction(JoinPoint joinPoint) {
        // TBD
    }

//    @Around("!execution(* org.example.demo.controller..*.* (..)) && execution(* org.example.demo..*.* (..))")
    @Around("execution(* com.example.demo..*.* (..))")
    public Object traceMethod(ProceedingJoinPoint pjp) throws Throwable{
        LOGGER.info("{} has started execution - transaction-id: {}.", pjp.getSignature(), MDC.get("transaction-id"));
        Object resultOfMethodCall = pjp.proceed();
        LOGGER.info("{} has finished execution- transaction-id: {}.", pjp.getSignature(), MDC.get("transaction-id"));
        return resultOfMethodCall;
    }
}
