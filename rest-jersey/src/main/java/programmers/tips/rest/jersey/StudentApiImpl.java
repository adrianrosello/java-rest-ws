package programmers.tips.rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Adrián Roselló Rey
 *
 */
@Path("/student")
@Consumes("application/json")
@Produces("application/json")
public class StudentApiImpl implements StudentApi {

	List<Student> students;

	public StudentApiImpl() {
		students = new ArrayList<Student>();
	}

	@GET
	@Override
	public List<Student> listStudents() {
		return new ArrayList<Student>(students);
	}

	@POST
	@Override
	public Student addStudent(@QueryParam("name") String name, @QueryParam("age") Short age) {

		if (age == null || StringUtils.isEmpty(name))
			throw new WebApplicationException("Age and name required.", 400);

		Student student = new Student(name, age);
		students.add(student);

		return student;
	}

	@GET
	@Path("/{id}")
	@Override
	public Student getStudent(@PathParam("id") long id) {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new WebApplicationException(404);

		return student.get();

	}

	@DELETE
	@Path("/{id}")
	@Override	
	public void removeStudent(@PathParam("id") long id) {
		Optional<Student> student = students.stream().filter(s -> (s.getId() == id)).findFirst();

		if (!student.isPresent())
			throw new WebApplicationException(404);

		students.remove(student.get());

	}

}
