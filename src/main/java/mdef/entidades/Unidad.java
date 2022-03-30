package mdef.entidades;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	private String nombre;
	private boolean operativo;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Militar.class, mappedBy = "unidad")
	private Collection<Militar> militaresDestinados = new ArrayList<>();

	public Unidad() {

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

	public Collection<Militar> getMilitaresDestinados() {
		return militaresDestinados;
	}

	public void setMilitaresDestinados(Collection<Militar> militaresDestinados) {
		this.militaresDestinados = militaresDestinados;
	}

	public boolean isOperativo() {
		return operativo;
	}

	public void setOperativo(boolean operativo) {
		this.operativo = operativo;
	}

	public void addMilitar(Militar militar) {
		getMilitaresDestinados().add(militar);
		militar.setUnidad(this);
	}

}
