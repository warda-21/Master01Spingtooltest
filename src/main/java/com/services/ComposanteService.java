package com.services;


import com.dtos.ComposanteDto;
import com.dtos.ResponsableDto;

import java.util.List;

public interface ComposanteService {


    ComposanteDto enregistrerComposante(ComposanteDto composanteDto);

    ComposanteDto obtenirComposanteParID(Long composanteId);

    boolean supprimerComposanteParId(Long composanteId);

    List<ComposanteDto> obtenirToutLesComposantes();
}
