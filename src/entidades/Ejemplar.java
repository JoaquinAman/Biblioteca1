package entidades;

import java.util.ArrayList;

import exception.FaltanValoresException;

public class Ejemplar extends Libro{

	private int nroEdicion;
	private String ubicacion;
	
	
	
	public Ejemplar () {}

	public Ejemplar(String nombre, int nroEdicion, String ubicacion){
		super(nombre);
		
		this.nroEdicion = nroEdicion;
		this.ubicacion = ubicacion;
	}

	public int getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
