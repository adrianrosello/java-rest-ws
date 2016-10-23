package programmers.tips.rest.jersey;

import java.util.List;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
public interface StudentApi {

	List<Student> listStudents();

	Student addStudent(String name, Short age);

	Student getStudent(long id);

	void removeStudent(long id);

}