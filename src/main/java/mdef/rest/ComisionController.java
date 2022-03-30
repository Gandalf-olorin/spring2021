package mdef.rest;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mdef.entidades.Comision;
import mdef.repositorios.ComisionDAO;

@RepositoryRestController
@RequestMapping(path = "/comisiones")
@Configuration
public class ComisionController {
	private ComisionDAO comisionDAO;

	public ComisionController(ComisionDAO comisionDAO) {
		this.comisionDAO = comisionDAO;
	}

	@GetMapping("/activas")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getComisionesActivas(PersistentEntityResourceAssembler assembler) {

		List<Comision> comisiones = comisionDAO.getComisionesActivas();

		return assembler.toCollectionModel(comisiones);
	}

	@GetMapping("/no-activas")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getComisionesNoActivas(
			PersistentEntityResourceAssembler assembler) {

		List<Comision> comisiones = comisionDAO.getComisionesNoActivas();

		return assembler.toCollectionModel(comisiones);
	}

}
