package com.controllers;


import com.dtos.CoursDto;
import com.dtos.CreneauDto;
import com.entities.Creneau;
import com.services.impl.CoursServiceImpl;
import com.services.impl.CreneauServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crenaux")
public class CrenauxController {

	private final CreneauServiceImpl creneauService;

	public CrenauxController(CreneauServiceImpl c) {
		this.creneauService = c;
	}

	@GetMapping("/{id}")
	public CreneauDto getCreneau(@PathVariable Long id){
		return creneauService.obtenirCreneauparID(id);
	}

    /**
	 *
	 * @param cDto
	 * @return CreneauDto saved
	 */
	@PostMapping
	public CreneauDto saveCreneau(final @RequestBody CreneauDto cDto){return creneauService.enregistrerCreneau(cDto);
	}

	/**
	 * supprime un crenau par son id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteCreneau(@PathVariable Long id){
		return creneauService.supprimerCreneauParId(id);
	}
	/**
	 * Liste des Creneaux
	 */
	@GetMapping
	public List<CreneauDto> getCreneau() {
		return creneauService.listedesCreneau();
	}


}
