package entidades;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import exception.FaltanEjemplaresException;
import exception.FaltanValoresException;
import exception.LimiteEjemplaresException;

public class Socio {
	private String nombre;
	private String apellido;
	private int nroIdentificacion;
	private int cantidadMaxima = 1;
	private ArrayList<Ejemplar> listaEjemplaresRetirados = new ArrayList();
	private ArrayList<Object[]> listaPrestamosSocio = new ArrayList();
	private ArrayList<String[]> listaDevolucionesSocio = new ArrayList();;
	
	//CONSULTA CUPO
	public boolean consultaCupo(ArrayList<Ejemplar> listaEjemplaresRetirados) {
		if(listaEjemplaresRetirados.size() >= cantidadMaxima) {
				System.out.println("No tiene cupo");
			return false;
		}else {
			System.out.println("Tiene cupo");
			return true;
		}
	}
	
	
	
	// CONSULTA CUPO
	public boolean consultaCupo1(ArrayList<Ejemplar> listaEjemplaresRetirados) {
		if(listaEjemplaresRetirados.size() >= cantidadMaxima) {
			
			return false;
		}else {
			
			return true;
		}
	}
	
	// PIDE PRESTADO
	public Prestamo pedirPrestado (Ejemplar ejemplar,  ArrayList<Libro> listaLibros) throws LimiteEjemplaresException{
		if(consultaCupo1(listaEjemplaresRetirados) == false) {
			
			throw new LimiteEjemplaresException();
			
		} else {
			
			
			try {
				listaLibros.get(0).prestarEjemplar(ejemplar);listaEjemplaresRetirados.add(ejemplar);
				
				Prestamo prestamo = new Prestamo(ejemplar, this);
			
				Object arrayPrestamoSocio[] = new Object[3];
				
				arrayPrestamoSocio[0] = prestamo.getEjemplar().getNombre();
				arrayPrestamoSocio[1] = "Socio: " + prestamo.getSocio().getNombre() + " " + prestamo.getSocio().getApellido();
				arrayPrestamoSocio[2] = prestamo.getDate();
				
				listaPrestamosSocio.add(arrayPrestamoSocio);
				
				return prestamo;
			} catch (FaltanValoresException | FaltanEjemplaresException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
			return null;
			
		}
	}
	
	// DEVUELVE EJEMPLAR
	public void devuelveEjemplar(Ejemplar ejemplar, ArrayList<Libro> listaLibros) {
		if(listaEjemplaresRetirados.contains(ejemplar)) {
			
			listaLibros.get(0).devuelveEjemplarPrestado(ejemplar);
			
			Date date = new Date();
			Instant instant = date.toInstant();
			LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			String fecha = ldt.format(fmt);
			
			listaEjemplaresRetirados.remove(ejemplar);
			
			String arrayDevolucionSocio[] = new String[3];
			
			arrayDevolucionSocio[0] = ejemplar.getNombre();
			arrayDevolucionSocio[1] = "Socio: " + nombre + " " + apellido;
			arrayDevolucionSocio[2] = fecha;
			
			listaDevolucionesSocio.add(arrayDevolucionSocio);
		}
	}
	
	// IMPRIME HISTORIAL
	public void ImprimeHistorial(ArrayList<Object[]> listaPrestamosSocio, ArrayList<String[]> listaDevolucionesSocio) {
		
		System.out.println("Historial de PRESTAMOS de Socios");
		
		for(Object[] str : listaPrestamosSocio) {
			System.out.println(Arrays.toString(str));
		}
			
		System.out.println("Historial de DEVOLUCIONES de Socios");
		
		for(String[] str1 : listaDevolucionesSocio) {
			System.out.println(Arrays.toString(str1));
		}
	}
	
	public Socio () {}

	public Socio (String nombre, String apellido, int nroIdentificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroIdentificacion = nroIdentificacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(int nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public ArrayList<Ejemplar> getListaEjemplaresRetirados() {
		return listaEjemplaresRetirados;
	}

	public void setListaEjemplaresRetirados(ArrayList<Ejemplar> listaEjemplaresRetirados) {
		this.listaEjemplaresRetirados = listaEjemplaresRetirados;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public ArrayList<Object[]> getListaPrestamosSocio() {
		return listaPrestamosSocio;
	}

	public void setListaPrestamosSocio(ArrayList<Object[]> listaPrestamosSocio) {
		this.listaPrestamosSocio = listaPrestamosSocio;
	}

	public ArrayList<String[]> getListaDevolucionesSocio() {
		return listaDevolucionesSocio;
	}

	public void setListaDevolucionesSocio(ArrayList<String[]> listaDevolucionesSocio) {
		this.listaDevolucionesSocio = listaDevolucionesSocio;
	}
	
}
