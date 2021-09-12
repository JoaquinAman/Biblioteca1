package vista.instanciaNuevoLibro;

import javax.swing.*;

public class Lamina_NuevoSocioVIP extends JPanel{
	public Lamina_NuevoSocioVIP(String titulo) {
		 
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		placeholderNombre = new JTextFieldPlaceHolder("Nombre del socio VIP");
		placeholderApellido = new JTextFieldPlaceHolder("Apellido del socio VIP");
		placeholderNroIdentificacion = new JTextFieldPlaceHolder("Nro de identificacion");
		placeholderCuotaMensual = new JTextFieldPlaceHolder("Cuota mensual");
		
		add(placeholderNombre);
		add(placeholderApellido);
		add(placeholderNroIdentificacion);
		add(placeholderCuotaMensual);
		
	}

	private JTextFieldPlaceHolder placeholderNombre;
	private JTextFieldPlaceHolder placeholderApellido;
	private JTextFieldPlaceHolder placeholderNroIdentificacion;
	private JTextFieldPlaceHolder placeholderCuotaMensual;
	
	public JTextFieldPlaceHolder getPlaceholderNombre() {
		return placeholderNombre;
	}
	public void setPlaceholderNombre(JTextFieldPlaceHolder placeholderNombre) {
		this.placeholderNombre = placeholderNombre;
	}
	public JTextFieldPlaceHolder getPlaceholderApellido() {
		return placeholderApellido;
	}
	public void setPlaceholderApellido(JTextFieldPlaceHolder placeholderApellido) {
		this.placeholderApellido = placeholderApellido;
	}
	public JTextFieldPlaceHolder getPlaceholderNroIdentificacion() {
		return placeholderNroIdentificacion;
	}
	public void setPlaceholderNroIdentificacion(JTextFieldPlaceHolder placeholderNroIdentificacion) {
		this.placeholderNroIdentificacion = placeholderNroIdentificacion;
	}
	public JTextFieldPlaceHolder getPlaceholderCuotaMensual() {
		return placeholderCuotaMensual;
	}
	public void setPlaceholderCuotaMensual(JTextFieldPlaceHolder placeholderCuotaMensual) {
		this.placeholderCuotaMensual = placeholderCuotaMensual;
	}
}
