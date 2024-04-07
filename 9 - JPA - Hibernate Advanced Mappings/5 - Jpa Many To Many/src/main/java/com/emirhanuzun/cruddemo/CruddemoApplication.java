package com.emirhanuzun.cruddemo;


import com.emirhanuzun.cruddemo.dao.AppDAO;
import com.emirhanuzun.cruddemo.entity.*;
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
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting student id " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student : " + tempStudent);
		System.out.println("Associated courses : " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done ! ");

	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student : " + tempStudent);
		System.out.println("Courses : " + tempStudent.getCourses());

		System.out.println("Done ! ");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course : " + tempCourse);
		System.out.println("Students : " + tempCourse.getStudents());

		System.out.println("Done ! ");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		Student tempStudent1 = new Student("Emir","Uzun","1emirhanuzun@gmail.com");
		Student tempStudent2 = new Student("Clarice","Nicole","clarice@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course: " + tempCourse);
		System.out.println("Associated students: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);


		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		
		tempCourse.addReview(new Review("Great course... Loved it !"));
		tempCourse.addReview(new Review("Cool course... Job well done !"));
		tempCourse.addReview(new Review("What a dumb course..."));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");


	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id : " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");


	}


	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id : " + theId);
		tempInstructor.setLastName("UPDATE TEST");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding course id : " + theId);

		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating instructor id : " + theId);
		tempCourse.setTitle("Updated new title");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("The associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");

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

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
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
