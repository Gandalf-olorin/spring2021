package mdef.noEntidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mdef.entidades.Militar;
import mdef.repositorios.FusilDAO;

@Component
public class Fusilero extends Militar {

	
	private FusilDAO fusilDAO;

	@Autowired
	public Fusilero(FusilDAO fusilDAO) {
		this.fusilDAO = fusilDAO;
	}
}
