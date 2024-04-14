package com.emirhanuzun.aopdemo;

import com.emirhanuzun.aopdemo.dao.AccountDAO;
import com.emirhanuzun.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

			// demoTheAfterReturningAdvice(theAccountDAO);

			//demoTheAfterThrowingAdvice(theAccountDAO);

			demoTheAfterAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		// Call method to find the accounts
		List<Account> theAccounts = null;

		try{

			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		}catch (Exception exc){
			System.out.println("\n\n Main Program... Caught exception : " + exc);
		}

		// Display the acccounts
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");


	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// Call method to find the accounts
		List<Account> theAccounts = null;

		try{

			boolean tripWire = true;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\n Main Program... Caught exception : " + exc);
		}

		// Display the acccounts
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// Call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// Display the acccounts
		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		myAccount.setName("Emir");
		myAccount.setLevel("Platinum");


		// Call the business method
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// Call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

		
	}


}
