package com.rakesh.cruddemo;

import com.rakesh.cruddemo.dao.StudentDAO;
import com.rakesh.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//Read Step 3: Update Main App
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO); //Create
//			readStudent(studentDAO);
//			queryAllStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating Student....");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findByLastName("Thera");

		//display list of students
		for(Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
	}

	private void queryAllStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
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
