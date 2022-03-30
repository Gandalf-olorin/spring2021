package mdef.repositorios;

import javax.persistence.PreRemove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mdef.entidades.Comision;

@Component
public class ComisionListener {

	private Logger log = LoggerFactory.getLogger(ComisionListener.class);
	private ComisionDAO comisionDAO;

	@Autowired
	public void init(ComisionDAO comisionDAO) {
		this.comisionDAO = comisionDAO;
	}

	@PreRemove
	public void preBorrar(Comision comision) {
		log.warn("Se va a borrar una Comision de Servicio con HashCode: " + comision.hashCode());
	}

}
