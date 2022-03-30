package mdef.repositorios;

import java.util.List;

import mdef.entidades.Comision;

public interface ComisionDAOCustom {

	List<Comision> getComisionesActivas();

	List<Comision> getComisionesNoActivas();
}
