package com.controllers;


import com.dtos.ComposanteDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.services.impl.ComposanteServiceImpl;
import com.services.impl.ResponsableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composantes")
public class ComposanteController {

	private final ComposanteServiceImpl composanteService;

	public ComposanteController(ComposanteServiceImpl dogService) {
		this.composanteService = dogService;
	}


	@GetMapping("/{id}")
	public ComposanteDto getC(@PathVariable Long id){
		return composanteService.obtenirComposanteParID(id);
	}

	@PostMapping
	public ComposanteDto saveC(final @RequestBody ComposanteDto c){return composanteService.enregistrerComposante(c);
	}


	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteC(@PathVariable Long id){
		return composanteService.supprimerComposanteParId(id);
	}
	/*
	liste des composantes
	 */
	@GetMapping
	public List<ComposanteDto> getDogs() {
		return composanteService.obtenirToutLesComposantes();
	}
}
