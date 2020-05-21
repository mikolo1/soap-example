package soapexample.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import student.Student;

@Service
public class StudentService {

	private List<Student> students;

	public Student getStudentById(long id) {
		return students.stream().filter(student -> id == student.getId()).findFirst().get();
	}

	public StudentService() {
		students = new ArrayList<>();
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Franek");
		student1.setSurname("Frankowski");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Jacek");
		student2.setSurname("Jackowski");

		students.add(student1);
		students.add(student2);
	}

}
