package mdef.repositorios;

import org.springframework.stereotype.Component;
import mdef.entidades.Militar;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MilitarListener {

	private Logger log = LoggerFactory.getLogger(MilitarListener.class);

	// Este no se pedia en el enunciado
	@PrePersist
	void preCrear(Militar militar) {
		log.warn("Se va a dar de ALTA en las FAS a: " + militar.getNombre());

	}

	@PreUpdate
	void preActualizar(Militar militar) {
		log.info("Codigo de actualizacion: " + Militar.generarCodigoActualizacion());

	}

}
