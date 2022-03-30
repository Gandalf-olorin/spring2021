package mdef.repositorios;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mdef.entidades.Fusil;

@Transactional(readOnly = true)
public class FusilDAOImpl implements FusilDAOCustom {

	@Autowired
	FusilDAO fusilDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Fusil> getAlcanceMinimo(Double alcance) {
		List<Fusil> fusiles = fusilDAO.findAll().stream().filter(j -> j.getAlcanceEnMetros() >= alcance)
				.collect(Collectors.toList());
		return fusiles;
	}

}
