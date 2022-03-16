package com.services;


import com.dtos.GestionnaireDto;
import com.dtos.VacataireDto;

import java.util.List;

public interface GestionnaireService {


    GestionnaireDto enregistrerGestionnaire(GestionnaireDto GestionnaireDto);

    GestionnaireDto obtenirGestionnaireParId(Long id);

    boolean supprimerGestionnaireParId(Long id);

    List<GestionnaireDto> obtenirTousLesGestionnaires();
}
