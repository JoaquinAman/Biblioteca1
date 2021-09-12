package vista.instanciaNuevoLibro;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.Ejemplar;
import entidades.Libro;
import entidades.Socio;
import entidades.SocioVIP;
import exception.FaltanValoresException;
import vista.Marco;

import exception.FaltanValoresException;

public class MarcoInstanciaLibro extends JFrame {

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	public ArrayList<Ejemplar> getListaEjemplares() {
		return listaEjemplares;
	}
	public void setListaEjemplares(ArrayList<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}
	public Lamina_NuevoLibro getLaminaNuevoLibro() {
		return laminaNuevoLibro;
	}
	public void setLaminaNuevoLibro(Lamina_NuevoLibro laminaNuevoLibro) {
		this.laminaNuevoLibro = laminaNuevoLibro;
	}
	public Lamina_NuevoEjemplar getLaminaNuevoEjemplar() {
		return laminaNuevoEjemplar;
	}
	public void setLaminaNuevoEjemplar(Lamina_NuevoEjemplar laminaNuevoEjemplar) {
		this.laminaNuevoEjemplar = laminaNuevoEjemplar;
	}

	private Lamina_NuevoLibro laminaNuevoLibro;
	private Lamina_NuevoEjemplar laminaNuevoEjemplar;
	
	
	
	public MarcoInstanciaLibro ()  {
		
		setTitle("Marco para instanciar libros");
		
		setBounds(600, 100, 675, 450);
		
		JPanel lamina_cuadricula = new JPanel();
		
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		
		
		laminaNuevoLibro = new Lamina_NuevoLibro("Nuevo libro");
		
		laminaNuevoEjemplar = new Lamina_NuevoEjemplar("Nuevo ejemplar");
	
		
		setLayout(new BorderLayout());
		
		lamina_cuadricula.add(laminaNuevoLibro);
		
		lamina_cuadricula.add(laminaNuevoEjemplar);
		
		JPanel lamina_mostrar = new JPanel();
		
		//-------------------------------------------------
		JButton boton_agregar = new JButton("Agregar libro");
		
		boton_agregar.addActionListener(new AccionMostrar());
		
		lamina_mostrar.add(boton_agregar);
		
		add(lamina_mostrar, BorderLayout.SOUTH);
		
		//-------------------------------------------------
		JButton boton_siguiente = new JButton("Siguiente");
		
		boton_siguiente.addActionListener(new AccionSiguiente());
		
		lamina_mostrar.add(boton_siguiente);
		
		add(lamina_mostrar, BorderLayout.SOUTH);
		//-------------------------------------------------
		add(lamina_cuadricula, BorderLayout.CENTER);
	}
	
	public void recibeMarco3(Socio socio, SocioVIP socioVIP) {
		this.socio = socio;
		this.socioVIP = socioVIP;
	}
	
	private Socio socio;
	private SocioVIP socioVIP;
	private Ejemplar ejemplar = new Ejemplar();
	private Libro libro= new Libro();
	private ArrayList <Libro> listaLibros = new ArrayList<Libro>();
	private ArrayList <Ejemplar> listaEjemplares = new ArrayList<Ejemplar>();

	//-------------------------------------------------------
		private class AccionMostrar  implements ActionListener {
		
			@Override
			public void actionPerformed(ActionEvent e){
		
				// TODO Auto-generated method stub
				//listaLibros = new ArrayList<Libro>();
				
				//Libro libro = new Libro();
				
			
				
				libro.setNombre(laminaNuevoLibro.getPlaceholderNombre().getText());
				libro.setISBN( Integer.parseInt (laminaNuevoLibro.getPlaceholderISBN().getText()));
				libro.setAutor(laminaNuevoLibro.getPlaceholderAutor().getText());
				
				for(int i = 0; i < Integer.parseInt (laminaNuevoEjemplar.getPlaceholderCantidadEjemplares().getText()); i++) {
					libro.getListaEjemplares().add(ejemplar);
				}
				
				ejemplar.setNroEdicion(Integer.parseInt ( laminaNuevoEjemplar.getPlaceholderNroEdicion().getText()));
				ejemplar.setUbicacion(laminaNuevoEjemplar.getPlaceholderUbicacion().getText());
				ejemplar.setNombre(libro.getNombre());
				
				getLaminaNuevoLibro().getPlaceholderNombre().setText("Nombre del libro");
				getLaminaNuevoLibro().getPlaceholderISBN().setText("Codigo ISBN");
				getLaminaNuevoLibro().getPlaceholderAutor().setText("Nombre del autor");
				
				getLaminaNuevoEjemplar().getPlaceholderNroEdicion().setText("Numero de edicion");
				getLaminaNuevoEjemplar().getPlaceholderUbicacion().setText("Ubicacion");
				getLaminaNuevoEjemplar().getPlaceholderCantidadEjemplares().setText("Cantidad de ejemplares");
				
				
				listaLibros.add(libro);
			}
		}
	

		//-------------------------------------------------------
			private class AccionSiguiente  implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e){
					Marco miMarco = new Marco();
					
					miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					miMarco.setVisible(true);
					
					try {
						miMarco.recibeMarco2(socio, socioVIP, ejemplar, listaLibros);
						
					} catch (FaltanValoresException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}	
					
					setVisible(false);
					dispose();
				}
			}
	
}
