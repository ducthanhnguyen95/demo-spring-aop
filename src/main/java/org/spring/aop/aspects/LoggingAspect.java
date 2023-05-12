package org.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.spring.aop.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.spring.aop.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
        Comment comment = new Comment();
        comment.setText("Some other text!");
        Object[] newArguments = {comment};
        Object returnedByMethod = joinPoint.proceed(newArguments);
        logger.info("Method executed and returned " + returnedByMethod);
        return "FAILED";
    }
}
