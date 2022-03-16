package com.controllers;


import com.dtos.GestionnaireDto;
import com.dtos.VacataireDto;
import com.services.impl.GestionnaireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestionnaire")
public class GestionnaireController {

	private final GestionnaireServiceImpl gestionnaireService;

	public GestionnaireController(GestionnaireServiceImpl v) {
		this.gestionnaireService = v;
	}

	/**
	 * <p>Get all Gestionnaire in the system</p>
	 * @return List<GestionnaireDto>
	 */
	@GetMapping
	public List<GestionnaireDto> getGestionnaires() {
		return gestionnaireService.obtenirTousLesGestionnaires();
	}

	/**
	 * Method to get the Gestionnaire based on the ID
	 */
	@GetMapping("/{id}")
	public GestionnaireDto getGestionnaire(@PathVariable Long id){
		return gestionnaireService.obtenirGestionnaireParId(id);
	}

	/**
	 * Create a new Gestionnaire in the system
	 */
	@PostMapping
	public GestionnaireDto saveGestionnaire(final @RequestBody GestionnaireDto vDto){return gestionnaireService.enregistrerGestionnaire(vDto);
	}

	/**
	 * Delete a Gestionnaire by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteGestionnaire(@PathVariable Long id){
		return gestionnaireService.supprimerGestionnaireParId(id);
	}
	
}
