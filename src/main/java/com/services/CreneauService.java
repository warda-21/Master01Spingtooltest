package com.services;


import com.dtos.CoursDto;
import com.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {


    CreneauDto obtenirCreneauparID(Long f);

    CreneauDto enregistrerCreneau(CreneauDto creneauDto);

    boolean supprimerCreneauParId(Long id);

    List<CreneauDto> listedesCreneau();
}
