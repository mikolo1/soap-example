package soapexample.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import student.GetResponse;
import student.GetStudent;
import student.Student;

@Endpoint
public class StudentEndpoint {

	public StudentService studentService;

	@Autowired
	public StudentEndpoint(StudentService studentService) {
		this.studentService = studentService;
	}

	@PayloadRoot(namespace = "http://mikolo.pl/soupexample", localPart = "getStudent")
	@ResponsePayload
	public GetResponse getStudentById(@RequestPayload GetStudent getStudent) {
		GetResponse response = new GetResponse();
		long id = getStudent.getId();
		Student student = studentService.getStudentById(id);
		response.setStudent(student);
		return response;
	}

}
