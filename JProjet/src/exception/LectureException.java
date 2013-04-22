package exception;
/**
 * 
 * @author kouyate
 *
 */
public class LectureException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LectureException(String message){
		System.out.println(this.getClass() + " : "+message);
	}

}
