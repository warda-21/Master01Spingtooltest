package com.services;


import com.dtos.ResponsableDto;
import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {


    VacataireDto enregistrerVacataire(VacataireDto vacataireDto);

    VacataireDto obtenirVacataireParId(Long id);

    boolean supprimerVacataireParId(Long id);

    List<VacataireDto> obtenirTousLesVacataires();
}
