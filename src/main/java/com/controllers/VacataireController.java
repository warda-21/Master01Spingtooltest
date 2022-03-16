package com.controllers;


import com.dtos.ResponsableDto;
import com.dtos.VacataireDto;
import com.services.impl.ResponsableServiceImpl;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataires")
public class VacataireController {

	private final VacataireServiceImpl vacataireService;

	public VacataireController(VacataireServiceImpl v) {
		this.vacataireService = v;
	}

	/**
	 * <p>Get all Vacataires in the system</p>
	 * @return List<VacataireDto>
	 */
	@GetMapping
	public List<VacataireDto> getVacataires() {
		return vacataireService.obtenirTousLesVacataires();
	}

	/**
	 * Method to get the Vacataire based on the ID
	 */
	@GetMapping("/{id}")
	public VacataireDto getVacataire(@PathVariable Long id){
		return vacataireService.obtenirVacataireParId(id);
	}

	/**
	 * Create a new Vacataire in the system
	 */
	@PostMapping
	public VacataireDto saveVacataire(final @RequestBody VacataireDto vDto){return vacataireService.enregistrerVacataire(vDto);
	}

	/**
	 * Delete a Vacataire by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteVacataire(@PathVariable Long id){
		return vacataireService.supprimerVacataireParId(id);
	}
	
}
