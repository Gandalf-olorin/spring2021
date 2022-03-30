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
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
