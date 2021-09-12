package exception;

public class FaltanValoresException extends Exception{
	
	private static String mensaje = "Datos invalidos o faltantes";

	public FaltanValoresException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}
}