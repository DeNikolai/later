package degtyarev.kolya.later.exception.handler;

import degtyarev.kolya.later.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
	@ExceptionHandler({UserDoesNotExistException.class, ItemDoesNotExistException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFound(RuntimeException e) {
		return e.getMessage();
	}

	@ExceptionHandler({UserAlreadyExistException.class, ItemAlreadyExistException.class})
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleAlreadyFound(RuntimeException e) {
		return e.getMessage();
	}

	@ExceptionHandler({NotOwnerException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleNotOwner(RuntimeException e) {
		return e.getMessage();
	}
}
