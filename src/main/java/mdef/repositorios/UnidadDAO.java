package mdef.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mdef.entidades.Unidad;

@RepositoryRestResource(path="unidades", collectionResourceRel="unidades", itemResourceRel="unidad")
public interface UnidadDAO extends JpaRepository<Unidad, Long>{

}
