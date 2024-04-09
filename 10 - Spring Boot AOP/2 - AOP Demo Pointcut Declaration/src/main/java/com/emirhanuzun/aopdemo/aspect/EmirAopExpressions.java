package com.emirhanuzun.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmirAopExpressions {

    // This is where I add all of my related advices for logging

    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // Create a pointcut for getter methods
    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // Create a pointcut for setter methods
    @Pointcut("execution(* com.emirhanuzun.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // Create pointcut: include package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
