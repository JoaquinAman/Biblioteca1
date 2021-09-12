package vista.instanciaNuevoLibro;

import javax.swing.*;

public class Lamina_NuevoSocio extends JPanel{
	public Lamina_NuevoSocio(String titulo) {
		 
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		placeholderNombre = new JTextFieldPlaceHolder("Nombre del socio");
		placeholderApellido = new JTextFieldPlaceHolder("Apellido del socio");
		placeholderNroIdentificacion = new JTextFieldPlaceHolder("Nro de identificacion");
		
		add(placeholderNombre);
		add(placeholderApellido);
		add(placeholderNroIdentificacion);
		
	}

	private JTextFieldPlaceHolder placeholderNombre;
	private JTextFieldPlaceHolder placeholderApellido;
	private JTextFieldPlaceHolder placeholderNroIdentificacion;
	
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
}
