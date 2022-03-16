package com.services;


import com.dtos.ComposanteDto;
import com.dtos.Filiere_LangueDto;
import com.dtos.ResponsableDto;

import java.util.List;

public interface FiliereService {


    Filiere_LangueDto obtenirfiliereParID(Long composanteId);

    Filiere_LangueDto enregistrerfiliere(Filiere_LangueDto fdto);

    boolean supprimerFiliereParId(Long id);

    List<Filiere_LangueDto> listedesfilieres();

    //boolean supprimerComposanteParId(Long composanteId);
}
