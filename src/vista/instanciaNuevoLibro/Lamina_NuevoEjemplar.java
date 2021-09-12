package vista.instanciaNuevoLibro;

import javax.swing.*;


public class Lamina_NuevoEjemplar extends JPanel{

	
	public Lamina_NuevoEjemplar(String titulo) {
		 
			
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		placeholderNroEdicion = new JTextFieldPlaceHolder("Numero de edicion");
		placeholderUbicacion = new JTextFieldPlaceHolder("Ubicacion");
		placeholderCantidadEjemplares = new JTextFieldPlaceHolder("Cantidad de ejemplares");
	
		
		add(placeholderNroEdicion);	
		add(placeholderUbicacion);
		add(placeholderCantidadEjemplares);
		
	}

	private JTextFieldPlaceHolder placeholderNroEdicion;
	private JTextFieldPlaceHolder placeholderUbicacion;
	private JTextFieldPlaceHolder placeholderCantidadEjemplares;
	
	public JTextFieldPlaceHolder getPlaceholderNroEdicion() {
		return placeholderNroEdicion;
	}
	public void setPlaceholderNroEdicion(JTextFieldPlaceHolder placeholderNroEdicion) {
		this.placeholderNroEdicion = placeholderNroEdicion;
	}
	public JTextFieldPlaceHolder getPlaceholderUbicacion() {
		return placeholderUbicacion;
	}
	public void setPlaceholderUbicacion(JTextFieldPlaceHolder placeholderUbicacion) {
		this.placeholderUbicacion = placeholderUbicacion;
	}
	public JTextFieldPlaceHolder getPlaceholderCantidadEjemplares() {
		return placeholderCantidadEjemplares;
	}
	public void setPlaceholderCantidadEjemplares(JTextFieldPlaceHolder placeholderCantidadEjemplares) {
		this.placeholderCantidadEjemplares = placeholderCantidadEjemplares;
	}
	
}
