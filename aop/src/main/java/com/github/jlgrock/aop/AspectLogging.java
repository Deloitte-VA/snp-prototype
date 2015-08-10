package com.github.jlgrock.aop;

/**
 * Created by kyue on 7/27/2015.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect
public class AspectLogging {
    private static final Logger aopLogger = LoggerFactory.getLogger("aopLogger");

//    @Pointcut("execution(* com.github.jlgrock.snp.web.configuration.*.*(..))")//good
//    @Pointcut("execution(* com.github.jlgrock.snp.web.configuration..*(..)) && execution(!com.github.jlgrock.snp.web.configuration.package-info.*(..))")
//    @Pointcut("within(com.github.jlgrock.snp.web.configuration.ApplicationConfig)")
//    @Pointcut("within(com.github.jlgrock.snp.web..*)")
//    @Pointcut("execution(* com.github.jlgrock.snp.web.zzsandbox.TargetClass.doSomething(..))")

    @Pointcut("execution(* com.github.jlgrock.snp..*.*(..))")
//    @Pointcut("execution(* main(..))")//good
    public void logging() {}

    @Around("logging()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        aopLogger.info("\n******************************************************\n");
        aopLogger.info("Before " + pjp.getSignature());
        aopLogger.info(getLogInfo(pjp));

        Object ret = pjp.proceed();

        aopLogger.info("\n******************************************************\n");
        aopLogger.info("After " + pjp.getSignature());



        return ret;
    }

    private String getLogInfo(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();

        Object o = joinPoint.getThis();
        if (o != null) {
            builder.append("Class name *************** : ");
            builder.append(
                o.getClass()
                 .getName()
            );
            builder.append("\n");

        }

        builder.append("signature &&& : ");
        builder.append(
            joinPoint.getSignature()
                     .toLongString()
        );
        builder.append("\n");


        Object[] signatureArgs = joinPoint.getArgs();
        Class[] parameterTypes = ((CodeSignature) joinPoint.getSignature()).getParameterTypes();
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        builder.append("\n******************************************************\n");
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            builder.append(String.format("Arg %d :\n", i));
            builder.append("type: ");
            builder.append(parameterTypes[i]);
            builder.append("\n");
            builder.append("name: ");
            builder.append(parameterNames[i]);
            builder.append("\n");
            builder.append("value: ");
            builder.append(signatureArgs[i]);
            builder.append("\n");
        }



        return builder.toString();
    }

}
