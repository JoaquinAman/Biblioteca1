package entidades;

import java.util.ArrayList;

import exception.FaltanEjemplaresException;
import exception.FaltanValoresException;

public class Libro {
	
	private String nombre;
	private int ISBN;
	private String autor;
	private ArrayList<Ejemplar> listaEjemplares = new ArrayList();
	
	
	public void agregarEjemplarLista(Ejemplar ejemplar) {
		listaEjemplares.add(ejemplar);
	}
	
	public int muestraCantidadEjemplaresDisponibles(Libro libro) {
		int CantidadEjemplaresDisponibles = listaEjemplares.size();
		return CantidadEjemplaresDisponibles;
	}
	
	public boolean consultarEjemplarLista(Ejemplar ejemplar) {
		if(listaEjemplares.size()>0) {
		for (Ejemplar ejemplar1 : listaEjemplares) {
			if(ejemplar1.getNombre().equals(ejemplar.getNombre())) {
				return true;
			} else {
				return false;
			}
		}
		}
		return false;	
	}
	
	public Ejemplar prestarEjemplar(Ejemplar ejemplar) throws FaltanValoresException, FaltanEjemplaresException{
		if(listaEjemplares.size()>0) {
		for (Ejemplar ejemplar1 : listaEjemplares) {
			if(ejemplar1.getNombre().equals(ejemplar.getNombre())) {
				Ejemplar ejemplarAux = new Ejemplar();
				ejemplarAux = ejemplar;
				listaEjemplares.remove(ejemplar);
				return ejemplarAux;
			}
		}
		}else {
		throw new FaltanEjemplaresException();
		}
		

		return null;
	}
	
	public void devuelveEjemplarPrestado(Ejemplar ejemplar) {
		listaEjemplares.add(ejemplar);
	}

	public Libro () {}

	public Libro (String nombre) {
		this.nombre = nombre;
	}

	
	public Libro(String nombre1, int ISBN1, String autor1) throws FaltanValoresException{
		if(nombre1.equals("")) {
			throw new FaltanValoresException();
		}
		
		int digitos = 0;
		while (ISBN1!=0)
		{
			ISBN1=ISBN1/10;
			digitos++;
		}
		if(digitos != 10 ) {
			throw new FaltanValoresException();
		}
		
		if(autor1.equals("")) {
			throw new FaltanValoresException();
		}
		
		this.nombre = nombre1;
		this.ISBN = ISBN1;
		this.autor = autor1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ArrayList<Ejemplar> getListaEjemplares() {

		return listaEjemplares;
	}

	public void setListaEjemplares(ArrayList<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}
	
	
}
