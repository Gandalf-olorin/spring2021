package mdef.rest;

import java.util.List;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mdef.entidades.Fusil;
import mdef.repositorios.FusilDAO;

@RepositoryRestController
@RequestMapping(path = "/fusiles/search")
public class FusilController {

	private FusilDAO fusilDAO;

	public FusilController(FusilDAO fusilDAO) {
		super();
		this.fusilDAO = fusilDAO;
	}

	@GetMapping("/por-alcance-minimo")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getFusilesPorAlcanceMinimo(
			@RequestParam("alcanceMinimo") Double alcance, PersistentEntityResourceAssembler assembler) {

		List<Fusil> fusiles = fusilDAO.getFusilesPorAlcanceMinimo(alcance);

		return assembler.toCollectionModel(fusiles);
	}

}
