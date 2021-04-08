package dev.enterprise.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


/**
 *      AOP compliments OOP with the modularization of cross cutting concerns.
 *
 *      types of advice
 *      After
 *      AfterReturning
 *      AfterThrowing
 *      Before
 *      Around
 */
@Component
@Aspect
public class IntroAspect {

    Logger logger;

    // This is an advice with a pointcut expression
//    @After("execution(* *getAllJokes())")
//    @Before("execution(* setRepo(..))")
//    public void inCatch(JoinPoint jp){
////        logger.info(e.getMessage());
//        System.out.println("An exception has been thrown");
//
//    }

//    @Before("execution(* *(..))")
//    public void beforeAnything(JoinPoint jp){
//        System.out.println(jp.)getSignature();
//    }

    @Around(value = "within(dev.enterprise.service.*)")
    public Object aroundItAll(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("in the around");
//        return pjp.proceed();
        Object o = pjp.proceed();

//        System.out.println(o.toString());
        Map<String, String> p = (Map<String, String>) o;
        p.put("a new somthing","for you to go look at");
        System.out.println("This should be after the method is finished.");
        return o;

    }

    @AfterThrowing(value = "execution(* *(..))", throwing = "jp")
    public void afterThrowingIOException(IOException jp){
        logger.info(jp.getMessage());
    }

}

