package mdef.repositorios;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mdef.entidades.Comision;

@Transactional(readOnly = true)
public class ComisionDAOImpl implements ComisionDAOCustom {

	@Autowired
	ComisionDAO comisionDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Comision> getComisionesActivas() {
		List<Comision> comisiones = comisionDAO.findAll().stream().filter(j -> j.isActiva() == true)
				.collect(Collectors.toList());
		return comisiones;
	}

	@Override
	public List<Comision> getComisionesNoActivas() {
		List<Comision> comisiones = comisionDAO.findAll().stream().filter(j -> j.isActiva() == false)
				.collect(Collectors.toList());
		return comisiones;
	}

}
