package com.emirhanuzun.aopdemo.aspect;

import com.emirhanuzun.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.emirhanuzun.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        // Print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @Around on method : " + method);

        // Get begin timestamp
        long begin = System.currentTimeMillis();

        // Execute the method
        Object result = theProceedingJoinPoint.proceed();

        // Get end timestamp
        long end = System.currentTimeMillis();

        // Compute duration and display it
        long duration = end - begin;
        System.out.println("\n====>>> Duration : " + duration/ 1000.0 + " seconds") ;

        return result;
    }


    // Add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.emirhanuzun.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterReturning on method : " + method);

        // Print out the results of the method call
        System.out.println("\n\n=====>> Result is: " + result);


        // Post-process the data
        // Convert account names to uppercase
        convertAccountNameToUpperCase(result);

        System.out.println("\n\n=====>> Result is: " + result);


    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        // Loop through accounts
        for(Account tempAccount: result){

            // Get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            //Update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

    @AfterThrowing(
            pointcut = "execution(* com.emirhanuzun.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterThrowing on method : " + method);

        // Log the exception
        System.out.println("\n====>>> The exception is : " + theExc);
    }

    @After("execution(* com.emirhanuzun.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @After (finally) on method : " + method);

    }

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
