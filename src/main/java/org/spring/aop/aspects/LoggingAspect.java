package org.spring.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

/**
 * @Before—Calls the method defining the aspect logic before the execution of
 * the intercepted method.
 * @AfterReturning—Calls the method defining the aspect logic after the
 * method successfully returns, and provides the returned value as a parameter to
 * the aspect method. The aspect method isn’t called if the intercepted method
 * throws an exception.
 * @AfterThrowing—Calls the method defining the aspect logic if the intercepted
 * method throws an exception, and provides the exception instance as a parameter to the aspect method.
 * @After—Calls the method defining the aspect logic only after the intercepted
 * method execution, whether the method successfully returned or threw an
 * exception.
 */
@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(org.spring.aop.annotation.ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);
    }

}
