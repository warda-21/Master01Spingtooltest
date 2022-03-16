package com.services;


import com.dtos.Filiere_LangueDto;
import com.dtos.Seance_FormationDto;

import java.util.List;

public interface FormationService {
    Seance_FormationDto obtenirformationParID(Long f);

    Seance_FormationDto enregistrerformation(Seance_FormationDto fdto);

    boolean supprimerFormationParId(Long id);

    List<Seance_FormationDto> listedesFormations();
}
