package com.controllers;


import com.dtos.CoursDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;
import com.services.impl.CoursServiceImpl;
import com.services.impl.FiliereServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CourController {

	private final CoursServiceImpl coursService;

	public CourController(CoursServiceImpl c) {
		this.coursService = c;
	}

	@GetMapping("/{id}")
	public CoursDto getF(@PathVariable Long id){
		return coursService.obtenirCoursparID(id);
	}

	/**
	 *
	 * @param cDto
	 * @return CoursDto saved
	 */
	@PostMapping
	public CoursDto saveCours(final @RequestBody CoursDto cDto){return coursService.enregistrercours(cDto);
	}

	/**
	 * Delete a cours by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteCours(@PathVariable Long id){
		return coursService.supprimerCoursParId(id);
	}
	/**
	 * Liste des Cours
	 */
	@GetMapping
	public List<CoursDto> getCours() {
		return coursService.listedescours();
	}


}
