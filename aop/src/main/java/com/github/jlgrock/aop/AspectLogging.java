package com.github.jlgrock.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AOP logging for every method
 */
@Aspect
public class AspectLogging {
    private static final Logger AOP_LOGGER = LoggerFactory.getLogger("aopLogger");

    /**
     * Pointcut for every method in SNP project
     */
    @Pointcut("execution(* com.github.jlgrock.snp..*.*(..))")
    public void everything() {}

    /**
     *
     */
    @Pointcut("execution(* com.github.jlgrock.snp..*.*Test(..))")
    public void everyTest() {}

    /**
     * Pointcut to be excluded from SNP project
     */
    @Pointcut("execution(* com.github.jlgrock.snp.domain.types..*.*(..))")
    public void toBeExcluded() {}

    /**
     * Pointcut to be applied on SNP project
     */
    @Pointcut("everything() && ! toBeExcluded() && ! everyTest()")
    public void logging(){}


    /**
     * AOP Advise
     * @param pjp JoinPoint object
     * @return object from Around advise
     * @throws Throwable exception thrown if JoinPoint could not get proceeded.
     *
     */
    @Around("logging()")
    public Object logging(final ProceedingJoinPoint pjp) throws Throwable {
        AOP_LOGGER.info("%n******************************************************%n");
        AOP_LOGGER.info("Before " + pjp.getSignature());
        AOP_LOGGER.info(getLogInfo(pjp));

        Object ret = pjp.proceed();

        AOP_LOGGER.info("%n******************************************************%n");
        AOP_LOGGER.info("After " + pjp.getSignature());

        return ret;
    }

    /**
     * get logging info for class, method, parameter names & values.
     * @param joinPoint
     * @return
     */
    private String getLogInfo(final JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();

        Object[] signatureArgs = joinPoint.getArgs();
        Class[] parameterTypes = ((CodeSignature) joinPoint.getSignature()).getParameterTypes();
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        builder.append("%n******************************************************%n");
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            builder.append(String.format("Arg %d :%n", i));
            builder.append("type: ");
            builder.append(parameterTypes[i]);
            builder.append("%n");
            builder.append("name: ");
            builder.append(parameterNames[i]);
            builder.append("%n");
            builder.append("value: ");
            builder.append(signatureArgs[i]);
            builder.append("%n%n");
        }

        return builder.toString();
    }

}
