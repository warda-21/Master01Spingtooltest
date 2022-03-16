package com.controllers;


import com.dtos.ComposanteDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;
import com.services.FiliereService;
import com.services.impl.ComposanteServiceImpl;
import com.services.impl.FiliereServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filieres")
public class FiliereController {

	private final FiliereServiceImpl fService;

	public FiliereController(FiliereServiceImpl dogService) {
		this.fService = dogService;
	}

	/**
	 * <p>Get all filieres in the system</p>
	 * @return List<FiliereDto>
	 */
	@GetMapping("/{id}")
	public Filiere_LangueDto getF(@PathVariable Long id){
		return fService.obtenirfiliereParID(id);
	}

	@PostMapping
	public Filiere_LangueDto saveF(final @RequestBody Filiere_LangueDto dogDto){return fService.enregistrerfiliere(dogDto);
	}

	/**
	 * Delete a filiere by it's id
	 */
	@DeleteMapping("/supprimer/{id}")
	public Boolean deleteF(@PathVariable Long id){
		return fService.supprimerFiliereParId(id);
	}


}
