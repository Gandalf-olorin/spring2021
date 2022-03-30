package mdef.externas;

/* 
 * 
 * Clase externa. No puede tocar
 * 
 * */
public abstract class Armamento {

	private long id;
	private boolean individual;
	private String denominacionOTAN;

	public Armamento() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public String getDenominacionOTAN() {
		return denominacionOTAN;
	}

	public void setDenominacionOTAN(String denominacionOTAN) {
		this.denominacionOTAN = denominacionOTAN;
	}

}
