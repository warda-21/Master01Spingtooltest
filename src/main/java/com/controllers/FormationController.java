package com.controllers;


import com.dtos.Filiere_LangueDto;
import com.dtos.Seance_FormationDto;
import com.services.FormationService;
import com.services.impl.FiliereServiceImpl;
import com.services.impl.FormationServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formations")
public class FormationController {

	private final FormationServiceImpl fService;

	public FormationController(FormationServiceImpl formService) {
		this.fService = formService;
	}

	/**
	 * <p>Get all formations in the system</p>
	 * @return List<Seance_FormationDto>
	 */
	@GetMapping("/{id}")
	public Seance_FormationDto getF(@PathVariable Long id){
		return fService.obtenirformationParID(id);
	}

	@PostMapping
	public Seance_FormationDto saveF(final @RequestBody Seance_FormationDto dogDto){return fService.enregistrerformation(dogDto);
	}

	/**
	 * Delete a seance_formation by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteF(@PathVariable Long id){
		return fService.supprimerFormationParId(id);
	}


}
