package mdef.repositorios;

import org.springframework.stereotype.Component;

import mdef.entidades.Comision;

import javax.persistence.PreRemove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ComisionListener {

	private Logger log = LoggerFactory.getLogger(MilitarListener.class);

	@PreRemove
	void preBorrar(Comision comision) {
		log.warn("Se va a borrar una Comision de Servicio con HashCode: " + String.valueOf(comision.hashCode()));

	}

}
