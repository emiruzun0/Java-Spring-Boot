package com.emirhanuzun.cruddemo;


import com.emirhanuzun.cruddemo.dao.AppDAO;
import com.emirhanuzun.cruddemo.entity.Course;
import com.emirhanuzun.cruddemo.entity.Instructor;
import com.emirhanuzun.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			findCoursesForInstructor(appDAO);

		};
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);

		// Find Courses for Instructor
		System.out.println("Finding coursesfor instructor id : " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("The associated courses : " + tempInstructor.getCourses());
		System.out.println("Done ! ");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("The associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Michelle","Mike","michelle@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/example5","Gardening");

		// Associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Create some courses

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// Add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor : " + tempInstructor);
		System.out.println("The courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
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
