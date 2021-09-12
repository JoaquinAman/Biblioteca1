package vista.instanciaNuevoSocio;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

import entidades.Socio;
import entidades.SocioVIP;
import exception.FaltanValoresException;
import vista.instanciaNuevoLibro.JTextFieldPlaceHolder;
import vista.instanciaNuevoLibro.Lamina_NuevoSocio;
import vista.instanciaNuevoLibro.Lamina_NuevoSocioVIP;
import vista.instanciaNuevoLibro.MarcoInstanciaLibro;



public class MarcoInstanciaSocio extends JFrame{
	
	public Lamina_NuevoSocio getLaminaNuevoSocio() {
		return laminaNuevoSocio;
	}

	public void setLaminaNuevoSocio(Lamina_NuevoSocio laminaNuevoSocio) {
		this.laminaNuevoSocio = laminaNuevoSocio;
	}

	public Lamina_NuevoSocioVIP getLaminaNuevoSocioVIP() {
		return laminaNuevoSocioVIP;
	}

	public void setLaminaNuevoSocioVIP(Lamina_NuevoSocioVIP laminaNuevoSocioVIP) {
		this.laminaNuevoSocioVIP = laminaNuevoSocioVIP;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public SocioVIP getSocioVIP() {
		return socioVIP;
	}

	public void setSocioVIP(SocioVIP socioVIP) {
		this.socioVIP = socioVIP;
	}
	private Lamina_NuevoSocio laminaNuevoSocio;
	private Lamina_NuevoSocioVIP laminaNuevoSocioVIP;
	
	public MarcoInstanciaSocio () {
		
		setTitle("Marco para instanciar Socios");
		
		setBounds(600, 100, 675, 450);
		
		JPanel lamina_cuadricula = new JPanel();
		
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		
	
		laminaNuevoSocio = new Lamina_NuevoSocio("Nuevo socio");
		laminaNuevoSocioVIP = new Lamina_NuevoSocioVIP("Nueco socioVIP");
		
		setLayout(new BorderLayout());
		
		lamina_cuadricula.add(laminaNuevoSocio);
		
		lamina_cuadricula.add(laminaNuevoSocioVIP);
		
		JPanel lamina_mostrar = new JPanel();
		
		JButton boton_agregar = new JButton("Agregar");
		
		boton_agregar.addActionListener(new AccionMostrar());
		
		lamina_mostrar.add(boton_agregar);
		
		add(lamina_mostrar, BorderLayout.SOUTH);
		
		add(lamina_cuadricula, BorderLayout.CENTER);
	}
	private Socio socio;
	private SocioVIP socioVIP;
	
	//-------------------------------------------------------
	private class AccionMostrar  implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			
			socio = new Socio ();
			socioVIP = new SocioVIP ();
				
			socio.setNombre(laminaNuevoSocio.getPlaceholderNombre().getText());
			socio.setApellido(laminaNuevoSocio.getPlaceholderApellido().getText());
			socio.setNroIdentificacion( Integer.parseInt (laminaNuevoSocio.getPlaceholderNroIdentificacion().getText()));
			
			socioVIP.setNombre(laminaNuevoSocioVIP.getPlaceholderNombre().getText());
			socioVIP.setApellido(laminaNuevoSocioVIP.getPlaceholderApellido().getText());
			socioVIP.setNroIdentificacion( Integer.parseInt (laminaNuevoSocioVIP.getPlaceholderNroIdentificacion().getText()));
			socioVIP.setCuotaMensual( Integer.parseInt (laminaNuevoSocioVIP.getPlaceholderCuotaMensual().getText()));
			
		
			
			MarcoInstanciaLibro miMarco;
			
				miMarco = new MarcoInstanciaLibro();
				
				miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				miMarco.setVisible(true);
				
				miMarco.recibeMarco3(socio, socioVIP);	
			
			
			
			setVisible(false);
			dispose();
		}
	}
}
