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

public class SocioVIP {
	private String nombre;
	private String apellido;
	private int nroIdentificacion;
	private int cuotaMensual;
	private int cantidadMaxima = 3;
	private ArrayList<Ejemplar> listaEjemplaresRetirados = new ArrayList();
	private ArrayList<Object[]> listaPrestamosSocioVIP = new ArrayList();
	private ArrayList<String[]> listaDevolucionesSocioVIP = new ArrayList();
	
	// CONSULTA CUPO
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
	public Prestamo pedirPrestado (Ejemplar ejemplar, ArrayList<Libro> listaLibros) throws LimiteEjemplaresException{
		if(consultaCupo1(listaEjemplaresRetirados) == false) {

			throw new LimiteEjemplaresException();
			
		} else {
			
			try {
				listaLibros.get(0).prestarEjemplar(ejemplar);
				listaEjemplaresRetirados.add(ejemplar);
				
				Prestamo prestamo = new Prestamo(ejemplar, this);
				
				Object arrayPrestamoSocioVIP[] = new Object[3];
				
				arrayPrestamoSocioVIP[0] = prestamo.getEjemplar().getNombre();
				arrayPrestamoSocioVIP[1] = "Socio VIP: " + prestamo.getSocioVIP().getNombre() + " " + prestamo.getSocioVIP().getApellido();
				arrayPrestamoSocioVIP[2] = prestamo.getDate();
				
				listaPrestamosSocioVIP.add(arrayPrestamoSocioVIP);
				
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
			
			String arrayDevolucionSocioVIP[] = new String[3];
			
			arrayDevolucionSocioVIP[0] = ejemplar.getNombre();
			arrayDevolucionSocioVIP[1] = "Socio VIP: " + nombre + " " + apellido;
			arrayDevolucionSocioVIP[2] = fecha;
			
			listaDevolucionesSocioVIP.add(arrayDevolucionSocioVIP);
		}
	}
	
	// IMPRIME HISTORIAL
		public void ImprimeHistorial(ArrayList<Object[]> listaPrestamosSocioVIP, ArrayList<String[]> listaDevolucionesSocioVIP) {
			
			System.out.println("Historial de PRESTAMOS de Socios VIP");
			
			for(Object[] str : listaPrestamosSocioVIP) {
				System.out.println(Arrays.toString(str));
			}
				
			System.out.println("Historial de DEVOLUCIONES de Socios VIP");
			
			for(String[] str1 : listaDevolucionesSocioVIP) {
				System.out.println(Arrays.toString(str1));
			}
		}
	
	public SocioVIP () {}

	
	
	public SocioVIP(String nombre, String apellido, int nroIdentificacion, int cuotaMensual) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroIdentificacion = nroIdentificacion;
		this.cuotaMensual = cuotaMensual;
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

	public int getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(int cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
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

	public ArrayList<String[]> getListaDevolucionesSocioVIP() {
		return listaDevolucionesSocioVIP;
	}

	public void setListaDevolucionesSocioVIP(ArrayList<String[]> listaDevolucionesSocioVIP) {
		this.listaDevolucionesSocioVIP = listaDevolucionesSocioVIP;
	}

	public ArrayList<Object[]> getListaPrestamosSocioVIP() {
		return listaPrestamosSocioVIP;
	}

	public void setListaPrestamosSocioVIP(ArrayList<Object[]> listaPrestamosSocioVIP) {
		this.listaPrestamosSocioVIP = listaPrestamosSocioVIP;
	}

	
	
	
}
