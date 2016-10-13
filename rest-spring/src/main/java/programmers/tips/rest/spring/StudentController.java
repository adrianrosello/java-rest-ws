package programmers.tips.rest.spring;

import java.util.List;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
public interface StudentController {

	List<Student> listStudents();

	Student addStudent(String name, Short age);

	Student getStudent(long id) throws ResourceNotFoundException;

	void removeStudent(long id) throws ResourceNotFoundException;
}
