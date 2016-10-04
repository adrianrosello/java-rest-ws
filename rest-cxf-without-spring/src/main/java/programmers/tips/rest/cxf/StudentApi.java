package programmers.tips.rest.cxf;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/student")
public interface StudentApi {

	@GET
	@Path("/")
	List<Student> listStudents();

	@POST
	@Path("/")
	Student addStudent(@QueryParam("name") String name, @QueryParam("age") Short age);

	@GET
	@Path("/{id}")
	Student getStudent(@PathParam("id") long id);

	@DELETE
	@Path("/{id}")
	void removeStudent(@PathParam("id") long id);

}