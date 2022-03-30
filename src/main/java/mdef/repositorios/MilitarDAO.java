package mdef.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import mdef.entidades.Militar;

@RepositoryRestResource(path = "militares", collectionResourceRel = "militares", itemResourceRel = "militar")
public interface MilitarDAO extends JpaRepository<Militar, Long> {

	@RestResource(path = "por-empleo")
	List<Militar> findByEmpleoIgnoreCaseContaining(@Param("empleo") String txt);

}
