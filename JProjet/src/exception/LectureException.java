package exception;
public class LectureException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur LectureException
	 * @param message
	 * 
	 */
	public LectureException(String message){
		System.out.println(this.getClass() + " : "+message);
	}

}
