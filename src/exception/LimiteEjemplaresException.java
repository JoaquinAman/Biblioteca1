package exception;

public class LimiteEjemplaresException extends Exception{
	
	private static String mensaje = "Limite de ejemplares permitidos alcanzado";

	public LimiteEjemplaresException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}
}


