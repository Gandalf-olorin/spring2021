package mdef.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import mdef.externas.Armamento;

@Entity
@Table(name = "FUSIL_DE_ASALTO")
public class Fusil extends Armamento {

	@Column(name = "ALCANCE_EN_METROS")
	private Double alcanceEnMetros;
	private Double calibre;

	public Fusil() {

	}

	public Double getAlcanceEnMetros() {
		return alcanceEnMetros;
	}

	public void setAlcanceEnMetros(Double alcanceEnMetros) {
		this.alcanceEnMetros = alcanceEnMetros;
	}

	public Double getCalibre() {
		return calibre;
	}

	public void setCalibre(Double calibre) {
		this.calibre = calibre;
	}

}
