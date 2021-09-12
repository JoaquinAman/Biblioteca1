package vista;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ControllerSocio;
import controller.ControllerSocioVIP;
import entidades.*;
import exception.FaltanValoresException;
import exception.LimiteEjemplaresException;


public class Marco extends JFrame {
	
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


	public Ejemplar getEjemplar() {
		return ejemplar;
	}


	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Lamina_BotonesSocio getLamina_tipo_socio() {
		return lamina_tipo_socio;
	}


	public void setLamina_tipo_socio(Lamina_BotonesSocio lamina_tipo_socio) {
		this.lamina_tipo_socio = lamina_tipo_socio;
	}


	public Lamina_BotonesTarea getLamina_tarea() {
		return lamina_tarea;
	}


	public void setLamina_tarea(Lamina_BotonesTarea lamina_tarea) {
		this.lamina_tarea = lamina_tarea;
	}

	public Lamina_BotonesCheck getLamina_historial() {
		return lamina_historial;
	}

	public void setLamina_historial(Lamina_BotonesCheck lamina_historial) {
		this.lamina_historial = lamina_historial;
	}
	
	private Lamina_BotonesSocio lamina_tipo_socio;
	private Lamina_BotonesTarea lamina_tarea;
	private Lamina_BotonesCheck lamina_historial;
	
	public Marco() {
		
		setTitle("Biblioteca");
		
		setBounds(400, 100, 675, 450);
		
		JPanel lamina_cuadricula = new JPanel();
		
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		
		lamina_tipo_socio = new Lamina_BotonesSocio("Tipo de Socio", new String [] {
			
				"",
				"Socio",
				"SocioVIP",
				
			
		});
		
		lamina_tarea = new Lamina_BotonesTarea("Tarea requerida", new String [] {
			
				"",
				"Consulta cupo",
				"Pide prestado",
				"Devuelve ejemplar"
			
		});
	
		lamina_historial = new Lamina_BotonesCheck("Historial de Prestamos/Devoluciones");
		
		setLayout(new BorderLayout());
		
		lamina_cuadricula.add(lamina_tipo_socio);
		
		lamina_cuadricula.add(lamina_tarea);
			
		lamina_cuadricula.add(lamina_historial);
		
		JPanel lamina_mostrar = new JPanel();
		
		JButton boton_ejecutar = new JButton("Ejecutar");
		
		boton_ejecutar.addActionListener(new AccionMostrar());
		
		lamina_mostrar.add(boton_ejecutar);
		
		add(lamina_mostrar, BorderLayout.SOUTH);
		
		add(lamina_cuadricula, BorderLayout.CENTER);
	}


	
	public void recibeMarco2(Socio socio, SocioVIP socioVIP, Ejemplar ejemplar, ArrayList<Libro> listaLibros) throws FaltanValoresException {
		
		
		this.socio = socio;
		this.socioVIP = socioVIP;
		this.ejemplar= ejemplar;
		this.listaLibros = listaLibros;
		
		int digitos = 0;
		int ISBN1 = listaLibros.get(0).getISBN();
		while (ISBN1!=0)
		{
			ISBN1=ISBN1/10;
			digitos++;
		}
		
		if ( (listaLibros.get(0).getNombre().equals(""))   || (digitos != 10)  ||  (listaLibros.get(0).getAutor().equals(""))){
			
			setVisible(false);
			dispose();
			throw new FaltanValoresException();
			
		
		}
	}
	
	private Socio socio;
	private SocioVIP socioVIP;
	private Ejemplar ejemplar;
	private Libro libro;
	private ArrayList<Libro> listaLibros;
	
	

	//-------------------------------------------------------
	private class AccionMostrar  implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			
												
			
			if(getLamina_tipo_socio().dameSeleccion().equals("Socio")) {
			
				if(getLamina_tarea().dameSeleccion().equals("Consulta cupo")) {
					ControllerSocio controller = new ControllerSocio();
					controller.consultaCupo(socio);
					
				}
				 
				else if (getLamina_tarea().dameSeleccion().equals("Pide prestado")) {
					ControllerSocio controller = new ControllerSocio();
					try {
						controller.pedirPrestado(socio, ejemplar, listaLibros);
					} catch (LimiteEjemplaresException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
				}
				
				else if (getLamina_tarea().dameSeleccion().equals("Devuelve ejemplar")) {
					ControllerSocio controller = new ControllerSocio();
					controller.devuelveEjemplar(socio, ejemplar, listaLibros);
				}

				getLamina_tipo_socio().getBotonVacio().setSelected(true);
				getLamina_tarea().getBotonVacio().setSelected(true);
				
			}
			
			if(getLamina_tipo_socio().dameSeleccion().equals("SocioVIP")) {
				
				if(getLamina_tarea().dameSeleccion().equals("Consulta cupo")) {
					ControllerSocioVIP controllerVIP = new ControllerSocioVIP();
					controllerVIP.consultaCupo(socioVIP);
				}
					 
				else if(getLamina_tarea().dameSeleccion().equals("Pide prestado")) {
					ControllerSocioVIP controllerVIP = new ControllerSocioVIP();
					try {
						controllerVIP.pedirPrestado(socioVIP, ejemplar, listaLibros);
					} catch (LimiteEjemplaresException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
				}
					 
				else if(getLamina_tarea().dameSeleccion().equals("Devuelve ejemplar")) {
					ControllerSocioVIP controllerVIP = new ControllerSocioVIP();
					controllerVIP.devuelveEjemplar(socioVIP, ejemplar, listaLibros);
				}
	
				getLamina_tipo_socio().getBotonVacio().setSelected(true);
				getLamina_tarea().getBotonVacio().setSelected(true);
				
			}
			
			if(lamina_historial.getBot().isSelected()) {
				
				
					ControllerSocio controller = new ControllerSocio();
					controller.ImprimeHistorialTodo(socio);
					getLamina_historial().getBot().setSelected(false);
				
				
				
				
				
					ControllerSocioVIP controllerVIP = new ControllerSocioVIP();
					controllerVIP.ImprimeHistorialTodo(socioVIP);
					getLamina_historial().getBot().setSelected(false);
			
				

			}
		}
	}
}
