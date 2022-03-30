package mdef.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import mdef.entidades.Fusil;

@RepositoryRestResource(path = "fusiles", collectionResourceRel = "fusiles", itemResourceRel = "fusil")
public interface FusilDAO extends JpaRepository<Fusil, Long>, FusilDAOCustom {

	//Este no se pedia en el enunciado
	@RestResource(path = "por-calibre")
	List<Fusil> findByCalibre(@Param("calibre") Double calibre);

	@RestResource(exported = false)
	void delete(Fusil entity);

}
