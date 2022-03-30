package mdef.entidades;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import mdef.repositorios.ComisionListener;

@EntityListeners(ComisionListener.class)
public class Comision {

	private long id;
	private boolean activa;
	private String nombre;
	private LocalDateTime fechaActivacion;
	private LocalDateTime fechaDesactivacion;
	@ManyToOne
	private Militar militar;

	public Comision() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(LocalDateTime fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public LocalDateTime getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public void setFechaDesactivacion(LocalDateTime fechaDesactivacion) {
		this.fechaDesactivacion = fechaDesactivacion;
	}

	public Militar getMilitar() {
		return militar;
	}

	public void setMilitar(Militar militar) {
		this.militar = militar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activa ? 1231 : 1237);
		result = prime * result + ((fechaActivacion == null) ? 0 : fechaActivacion.hashCode());
		result = prime * result + ((fechaDesactivacion == null) ? 0 : fechaDesactivacion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((militar == null) ? 0 : militar.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

}
