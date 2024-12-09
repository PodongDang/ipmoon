package com.example.ipmoon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TimeTraceAop {

    @Around("execution(* com.example.ipmoon..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start =System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finsih = System.currentTimeMillis();
            long timeMs = finsih - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
