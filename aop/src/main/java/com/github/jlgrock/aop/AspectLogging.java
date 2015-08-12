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

@Aspect
public class AspectLogging {
    private static final Logger aopLogger = LoggerFactory.getLogger("aopLogger");

    @Pointcut("execution(* com.github.jlgrock.snp..*.*(..))")
    public void everything() {}

    @Pointcut("execution(* com.github.jlgrock.snp.domain.types..*.*(..))")
    public void notLogging() {}

    @Pointcut("everything() && ! notLogging()")
    public void logging(){}

    @Around("logging()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        aopLogger.info("\r\n******************************************************\r\n");
        aopLogger.info("Before " + pjp.getSignature());
        aopLogger.info(getLogInfo(pjp));

        Object ret = pjp.proceed();

        aopLogger.info("\r\n******************************************************\r\n");
        aopLogger.info("After " + pjp.getSignature());

        return ret;
    }

    /**
     * get logging info for class, method, parameter names & values.
     * @param joinPoint
     * @return
     */
    private String getLogInfo(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();

        Object[] signatureArgs = joinPoint.getArgs();
        Class[] parameterTypes = ((CodeSignature) joinPoint.getSignature()).getParameterTypes();
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        builder.append("\r\n******************************************************\r\n");
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            builder.append(String.format("Arg %d :\r\n", i));
            builder.append("type: ");
            builder.append(parameterTypes[i]);
            builder.append("\r\n");
            builder.append("name: ");
            builder.append(parameterNames[i]);
            builder.append("\r\n");
            builder.append("value: ");
            builder.append(signatureArgs[i]);
            builder.append("\r\n\r\n");
        }

        return builder.toString();
    }

}
