package vista;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Lamina_BotonesSocio extends JPanel{

	public Lamina_BotonesSocio(String titulo, String [] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		grupo = new ButtonGroup();
		
		botonVacio = new JRadioButton(opciones[0]);
		
		botonOpcion1 = new JRadioButton(opciones[1]);
		
		botonOpcion2 = new JRadioButton(opciones[2]);	
		
		botonVacio.setActionCommand(opciones[0]);
		
		botonOpcion1.setActionCommand(opciones[1]);
		
		botonOpcion2.setActionCommand(opciones[2]);
		
		

		add(botonVacio);
		add(botonOpcion1);
		add(botonOpcion2);


		botonVacio.setSelected(true);
		
		botonVacio.setVisible(false);
		
		botonOpcion1.setVisible(true);
		
		botonOpcion2.setVisible(true);
		
		
		grupo.add(botonVacio);
		
		grupo.add(botonOpcion1);
	
		grupo.add(botonOpcion2);
		
	}
	
	public Lamina_BotonesSocio(String titulo) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		text = new JTextField();

		text.setBounds(10,10,200,30);
		
		add(text);
	}
	
	
	public String dameSeleccion() {
		
		ButtonModel miboton = grupo.getSelection();
		
		String s = miboton.getActionCommand();
		
		return s;
	}
	
	private ButtonGroup grupo;
	private JTextField text;
	private JRadioButton botonVacio;
	private JRadioButton botonOpcion1;
	private JRadioButton botonOpcion2;

	
	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public JRadioButton getBotonVacio() {
		return botonVacio;
	}

	public void setBotonVacio(JRadioButton botonVacio) {
		this.botonVacio = botonVacio;
	}

	public JRadioButton getBotonOpcion1() {
		return botonOpcion1;
	}

	public void setBotonOpcion1(JRadioButton botonOpcion1) {
		this.botonOpcion1 = botonOpcion1;
	}

	public JRadioButton getBotonOpcion2() {
		return botonOpcion2;
	}

	public void setBotonOpcion2(JRadioButton botonOpcion2) {
		this.botonOpcion2 = botonOpcion2;
	}
}