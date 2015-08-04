package com.github.jlgrock.aop;

/**
 * Created by kyue on 7/27/2015.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectLogging {
    private static final Logger aopLogger = LoggerFactory.getLogger("aopLogger");

//    @Pointcut("execution(* com.github.jlgrock.snp.web.configuration.*.*(..))")
//    @Pointcut("execution(* com.github.jlgrock.snp.web.configuration..*(..)) && execution(!com.github.jlgrock.snp.web.configuration.package-info.*(..))")
//    @Pointcut("within(com.github.jlgrock.snp.web.configuration.ApplicationConfig)")
//    @Pointcut("within(com.github.jlgrock.snp.web..*)")
//    @Pointcut("execution(* com.github.jlgrock.snp.web.zzsandbox.TargetClass.doSomething(..))")

//    @Pointcut("execution(* com.github.jlgrock.snp..*.*(..))")
    @Pointcut("execution(* main(..))")
    public void logging() {}

    @Around("logging()")
    public Object logging(ProceedingJoinPoint thisJoinPoint) throws Throwable {
//        System.out.println("############################");
        aopLogger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        System.out.println("Before " + thisJoinPoint.getSignature());
        aopLogger.info("Before " + thisJoinPoint.getSignature());
//        System.out.println("Before " + thisJoinPoint.getArgs());
        Object ret = thisJoinPoint.proceed();
//        System.out.println("After " + thisJoinPoint.getSignature());
        aopLogger.info("After " + thisJoinPoint.getSignature());

        aopLogger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        System.out.println("############################");


        return ret;
    }
}
