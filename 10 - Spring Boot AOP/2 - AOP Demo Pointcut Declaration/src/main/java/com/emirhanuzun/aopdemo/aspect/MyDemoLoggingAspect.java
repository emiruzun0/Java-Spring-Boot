package com.emirhanuzun.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where I add all of my related advices for logging

    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("====>>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("====>>>> Performing API Analytics");
    }

}
