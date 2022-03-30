package mdef.repositorios;

import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mdef.entidades.Militar;

@Component
public class MilitarListener {

	private Logger log = LoggerFactory.getLogger(MilitarListener.class);
	private MilitarDAO militarDAO;

	@Autowired
	public void init(MilitarDAO militarDAO) {
		this.militarDAO = militarDAO;
	}

	@PreUpdate
	public void preActualizar(Militar militar) {
		log.info("Codigo de actualizacion: " + Militar.generarCodigoActualizacion());
	}

}
