package programmers.tips.rest.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
@RestController
public class StudentControllerImpl implements StudentController {

	List<Student> students;

	public StudentControllerImpl() {
		students = new ArrayList<Student>();
	}

	@RequestMapping(path = "/student", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Student> listStudents() {
		return new ArrayList<Student>(students);
	}

	@RequestMapping(path = "/student", method = RequestMethod.POST, produces = "application/json")
	@Override
	public Student addStudent(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "age", required = true) Short age) {

		Student student = new Student(name, age);
		students.add(student);

		return student;
	}

	@RequestMapping(path = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Student getStudent(@PathVariable(name = "id", required = true) long id) throws ResourceNotFoundException {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new ResourceNotFoundException("Invalid id.");

		return student.get();

	}

	@RequestMapping(path = "/student/{id}", method = RequestMethod.DELETE)
	@Override
	public void removeStudent(@PathVariable(name = "id", required = true) long id) throws ResourceNotFoundException {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new ResourceNotFoundException("Invalid id.");

		students.remove(student.get());

	}

}
