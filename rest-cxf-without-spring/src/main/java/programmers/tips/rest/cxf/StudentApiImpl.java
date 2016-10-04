package programmers.tips.rest.cxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Adrián Roselló Rey
 *
 */
public class StudentApiImpl implements StudentApi {

	List<Student> students;

	public StudentApiImpl() {
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
