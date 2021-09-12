package vista.instanciaNuevoLibro;

import javax.swing.*;

import exception.FaltanValoresException;


public class Lamina_NuevoLibro extends JPanel{

	
	public JTextFieldPlaceHolder getPlaceholderNombre() {
		return placeholderNombre;
	}
	public void setPlaceholderNombre(JTextFieldPlaceHolder placeholderNombre) {
		this.placeholderNombre = placeholderNombre;
	}
	public JTextFieldPlaceHolder getPlaceholderISBN() {
		return placeholderISBN;
	}
	public void setPlaceholderISBN(JTextFieldPlaceHolder placeholderISBN) {
		this.placeholderISBN = placeholderISBN;
	}
	public JTextFieldPlaceHolder getPlaceholderAutor() {
		return placeholderAutor;
	}
	public void setPlaceholderAutor(JTextFieldPlaceHolder placeholderAutor) {
		this.placeholderAutor = placeholderAutor;
	}
	public Lamina_NuevoLibro(String titulo)  {
		 
			
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		placeholderNombre = new JTextFieldPlaceHolder("Nombre del libro");
		placeholderISBN = new JTextFieldPlaceHolder("Codigo ISBN");
		placeholderAutor = new JTextFieldPlaceHolder("Nombre del autor");
		
		add(placeholderNombre);
		add(placeholderISBN);
		add(placeholderAutor);
		
	}

	private JTextFieldPlaceHolder placeholderNombre;
	private JTextFieldPlaceHolder placeholderISBN;
	private JTextFieldPlaceHolder placeholderAutor;
	
}

