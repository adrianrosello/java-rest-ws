package programmers.tips.rest.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	
	private static final long serialVersionUID = 3871257247939502681L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException(String msg, Throwable t){
		super(msg, t);
	}

}
