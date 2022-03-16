package com.services;


import com.dtos.ResponsableDto;

import java.util.List;

public interface ResponsableService {
    public ResponsableDto enregistrerResponsable(ResponsableDto responsableDto);
    public ResponsableDto obtenirResponsableParId(Long idResponsable);
    public boolean supprimerResponsableParId(Long idResponsable);
    public List<ResponsableDto> obtenirTousLesResponsables();

}
