package com.services;


import com.dtos.CoursDto;
import com.dtos.Filiere_LangueDto;

import java.util.List;

public interface CoursService {

    CoursDto obtenirCoursparID(Long f);
    CoursDto enregistrercours(CoursDto courdto);
    boolean supprimerCoursParId(Long id);
    List<CoursDto> listedescours();
}
