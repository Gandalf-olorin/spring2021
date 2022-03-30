package mdef.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import mdef.entidades.Comision;

@RepositoryRestResource(path = "comisiones", collectionResourceRel = "comisiones", itemResourceRel = "comision")
public interface ComisionDAO extends JpaRepository<Comision, Long>, ComisionDAOCustom {

	@RestResource(path = "por-nombre")
	List<Comision> findByNombre(@Param("nombre") String txt);

}
