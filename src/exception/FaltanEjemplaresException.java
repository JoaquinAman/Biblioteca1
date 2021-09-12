package exception;

public class FaltanEjemplaresException extends Exception{
	private static String mensaje = "No quedan ejemplares";

	public FaltanEjemplaresException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}
}