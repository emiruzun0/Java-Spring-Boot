package com.emirhanuzun.aopdemo.aspect;

import com.emirhanuzun.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
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
            throwing = "result")

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
