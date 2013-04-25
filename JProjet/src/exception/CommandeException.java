package exception;
public class CommandeException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur de CommandeException
	 * @param message
	 */
	public CommandeException(String message){
		super(message);
	}

}
