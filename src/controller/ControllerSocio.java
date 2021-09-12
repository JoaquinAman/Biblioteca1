package controller;


import java.util.ArrayList;

import entidades.Ejemplar;
import entidades.Socio;
import exception.FaltanValoresException;
import exception.LimiteEjemplaresException;
import entidades.Libro;
import entidades.Prestamo;
																		

public class ControllerSocio {
	
	
	
	public boolean consultaCupo (Socio socio){

		return socio.consultaCupo(socio.getListaEjemplaresRetirados());
	}
	
	public Prestamo pedirPrestado (Socio socio, Ejemplar ejemplar, ArrayList<Libro> listaLibros) throws LimiteEjemplaresException{

		return socio.pedirPrestado(ejemplar, listaLibros);
	}
	
	public void devuelveEjemplar(Socio socio, Ejemplar ejemplar, ArrayList<Libro> listaLibros) {
		socio.devuelveEjemplar(ejemplar, listaLibros);
	}
	
	public void ImprimeHistorialTodo(Socio socio) {
		
		socio.ImprimeHistorial(socio.getListaPrestamosSocio(), socio.getListaDevolucionesSocio());
	}

	
}
