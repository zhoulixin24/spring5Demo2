package org.example.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 第二步，创建增强类
 * 在里面创建不同通知方法
 */
@Component
@Aspect
public class UserProxy {
    //前置通知
    //Before注解表示作为前置通知
    @Before(value = "execution(* org.example.aoptest.User.add(..))")
    public void before(){
        System.out.println("before...........");
    }

    //最终通知 被执行方法执行后 执行
    @After(value="execution(* org.example.aoptest.User.add(..))")
    public void after(){
        System.out.println("after...........");
    }

    //后置通知 被执行方法返回结果后才会执行
    @AfterReturning(value="execution(* org.example.aoptest.User.add(..))")
    public void afterReturn(){
        System.out.println("afterReturn...........");
    }

    //异常通知
    @AfterThrowing(value="execution(* org.example.aoptest.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...........");
    }

    //环绕通知
    @Around(value="execution(* org.example.aoptest.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知执行前");
        //被执行的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知执行后");

    }
}
