package mdef.otros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mdef.entidades.Fusil;
import mdef.entidades.Militar;

@Component
public class Fusilero extends Militar {

	private Fusil fusil;

	@Autowired
	public Fusilero(Fusil fusil) {
		super();
		this.fusil = fusil;
	}

	public Fusil getFusil() {
		return fusil;
	}

	public void setFusil(Fusil fusil) {
		this.fusil = fusil;
	}

}
