package com.controllers;


import com.dtos.ResponsableDto;
import com.entities.Responsable;
import com.services.impl.ResponsableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {
	
	private final ResponsableServiceImpl responsableService;

	public ResponsableController(ResponsableServiceImpl dogService) {
		this.responsableService = dogService;
	}

	/**
	 * <p>Get all dogs in the system</p>
	 * @return List<DogDto>
	 */
	@GetMapping
	public List<ResponsableDto> getDogs() {
		return responsableService.obtenirTousLesResponsables();
	}

	/**
	 * Method to get the dog based on the ID
	 */
	@GetMapping("/{id}")
	public ResponsableDto getDog(@PathVariable Long id){
		return responsableService.obtenirResponsableParId(id);
	}

	/**
	 * Create a new Dog in the system
	 */
	@PostMapping
	public ResponsableDto saveDog(final @RequestBody ResponsableDto dogDto){return responsableService.enregistrerResponsable(dogDto);
	}

	/**
	 * Delete a dog by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteDog(@PathVariable Long id){
		return responsableService.supprimerResponsableParId(id);
	}
	
}
