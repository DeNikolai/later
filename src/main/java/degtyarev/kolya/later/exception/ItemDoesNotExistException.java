package degtyarev.kolya.later.exception;

public class ItemDoesNotExistException extends RuntimeException {
	public ItemDoesNotExistException(String message) {
		super(message);
	}
}
