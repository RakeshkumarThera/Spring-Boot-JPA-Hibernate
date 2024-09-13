package com.rakesh.cruddemo;

import com.rakesh.cruddemo.dao.StudentDAO;
import com.rakesh.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO); //Create
			readStudent(studentDAO); //Read Step 3: Update Main App
		};
	}

	private void readStudent(StudentDAO studentDAO) { //Read Step 3: Update Main App
		//create a student object
		System.out.println("Creating new Student Object...");
		Student tempStudent = new Student("Suseela", "Thera", "Suseela@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student, Generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the Student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("Rakesh", "Thera", "rakeshkumarthera@gmail.com");
		Student tempStudent2 = new Student("Reshma", "Penumudi", "reshma94penumudi@gmail.com");
		Student tempStudent3  = new Student("Ravi", "Thera", "called2servejesus@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


		// display id of the saved student
		System.out.println("Saved student. Generated id's: " + tempStudent1.getId() + tempStudent2.getId() + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
