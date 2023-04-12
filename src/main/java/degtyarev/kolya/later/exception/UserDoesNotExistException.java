package degtyarev.kolya.later.exception;

public class UserDoesNotExistException extends RuntimeException {
	public UserDoesNotExistException(String message) {
		super(message);
	}
}
