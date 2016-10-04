package programmers.tips.rest.cxf.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Adrián Roselló Rey
 *
 */
public class StudentServiceImpl implements StudentService {

	List<Student> students;

	public StudentServiceImpl() {
		students = new ArrayList<Student>();
	}

	@Override
	public List<Student> listStudents() {
		return new ArrayList<Student>(students);
	}

	@Override
	public Student addStudent(String name, Short age) {

		if (age == null || StringUtils.isEmpty(name))
			throw new WebApplicationException("Age and name required.", 400);

		Student student = new Student(name, age);
		students.add(student);

		return student;
	}

	@Override
	public Student getStudent(long id) {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new WebApplicationException(404);

		return student.get();

	}

	@Override
	public void removeStudent(long id) {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new WebApplicationException(404);

		students.remove(student.get());

	}

}
