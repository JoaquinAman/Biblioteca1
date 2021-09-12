package entidades;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Prestamo {
	private Ejemplar ejemplar;
	private Socio socio;
	private SocioVIP socioVIP;
	private String date;
	
	public Prestamo () {}

	public Prestamo(Ejemplar ejemplar, Socio socio) {
		this.ejemplar = ejemplar;
		this.socio = socio;
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String fecha = ldt.format(fmt);
		this.date = fecha;  
	}
	
	public Prestamo(Ejemplar ejemplar, SocioVIP socioVIP) {
		this.ejemplar = ejemplar;
		this.socioVIP = socioVIP;
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String fecha = ldt.format(fmt);
		this.date = fecha;		
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
