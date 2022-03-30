package mdef.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mdef.repositorios.MilitarListener;

@Entity
@EntityListeners(MilitarListener.class)
public class Militar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "ID_MILITAR")
	private long id;
	private String nombre;
	private String empleo;
	private transient boolean bajaMedica;
	@Column(name = "FECHA_INGRESO_FAS")
	private LocalDateTime fechaIngresoFas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Unidad unidad;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Comision.class, mappedBy = "militar")
	private Collection<Comision> comisiones = new ArrayList<>();

	public Militar() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpleo() {
		return empleo;
	}

	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	public boolean isBajaMedica() {
		return bajaMedica;
	}

	public void setBajaMedica(boolean bajaMedica) {
		this.bajaMedica = bajaMedica;
	}

	public LocalDateTime getFechaIngresoFas() {
		return fechaIngresoFas;
	}

	public void setFechaIngresoFas(LocalDateTime fechaIngresoFas) {
		this.fechaIngresoFas = fechaIngresoFas;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Collection<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(Collection<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public void addComision(Comision comision) {
		getComisiones().add(comision);
		comision.setMilitar(this);
	}

	public static String generarCodigoActualizacion() {
		long numero = (long) (Math.random() * 10000) + 1000;
		return Long.toString(numero);
	}

}
