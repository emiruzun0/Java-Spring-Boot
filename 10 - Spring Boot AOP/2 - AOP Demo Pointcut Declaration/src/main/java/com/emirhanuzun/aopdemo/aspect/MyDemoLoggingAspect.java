package com.emirhanuzun.aopdemo.aspect;

import com.emirhanuzun.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.emirhanuzun.aopdemo.aspect.EmirAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n====>>>> Executing @Before advice on method");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method : " + methodSignature);

        //Display method arguments

        // Get arguments
        Object[] args = theJoinPoint.getArgs();

        // Loop thru arguments
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                // Downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("Account name : " + theAccount.getName() );
                System.out.println("Account level : " + theAccount.getLevel());

            }
        }




    }

}
