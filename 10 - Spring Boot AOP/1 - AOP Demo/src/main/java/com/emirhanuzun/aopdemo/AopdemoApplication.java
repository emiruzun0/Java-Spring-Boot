package com.emirhanuzun.aopdemo;

import com.emirhanuzun.aopdemo.dao.AccountDAO;
import com.emirhanuzun.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();


		// Call the business method
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

		
	}


}
