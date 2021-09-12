package controller;

import java.util.ArrayList;

import entidades.Ejemplar;
import entidades.Libro;
import entidades.Prestamo;
import entidades.SocioVIP;
import exception.FaltanValoresException;
import exception.LimiteEjemplaresException;

public class ControllerSocioVIP {

	public boolean consultaCupo (SocioVIP socioVIP){

		return socioVIP.consultaCupo(socioVIP.getListaEjemplaresRetirados());
	}
	
	public Prestamo pedirPrestado (SocioVIP socioVIP, Ejemplar ejemplar,  ArrayList<Libro> listaLibros) throws LimiteEjemplaresException{

		return socioVIP.pedirPrestado(ejemplar, listaLibros);
	}
	
	public void devuelveEjemplar(SocioVIP socioVIP, Ejemplar ejemplar,  ArrayList<Libro> listaLibros) {
		socioVIP.devuelveEjemplar(ejemplar, listaLibros);
	}
	
	public void ImprimeHistorialTodo(SocioVIP socioVIP) {
		
		socioVIP.ImprimeHistorial(socioVIP.getListaPrestamosSocioVIP(), socioVIP.getListaDevolucionesSocioVIP());
	}
}
