package com.emirhanuzun.cruddemo;

import com.emirhanuzun.cruddemo.entity.Instructor;
import com.emirhanuzun.cruddemo.entity.InstructorDetail;
import com.emirhanuzun.cruddemo.entity.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);


		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor id : " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done" );
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor detail id : " + theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("Instructor Detail : " + tempInstructorDetail );
		System.out.println("The associate instructor only : " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Instructor : " + tempInstructor );
		System.out.println("The associate instructor detail only : " + tempInstructor.getInstructorDetail());
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor : " + tempInstructor );
		System.out.println("The associate instructor detail only : " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*Instructor tempInstructor =
				new Instructor("Emir","Uzun","1emirhanuzun@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/example1","Love coding");*/


		Instructor tempInstructor =
				new Instructor("Clarice","Nicole","clarice@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/example2","Doing puzzles");

		// Assocaite the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Save the instructor
		System.out.println("Saving instructor " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

}
