package mdef.repositorios;

import java.util.List;

import mdef.entidades.Fusil;

public interface FusilDAOCustom {

	List<Fusil> getAlcanceMinimo(Double alcance);
}
