
public class InvalidIdException extends Exception {
	String message;
	public InvalidIdException(String message)
	{
		super();
		this.message=message;
	}
	public String getMessage()
	{
		return message;
	}
}
