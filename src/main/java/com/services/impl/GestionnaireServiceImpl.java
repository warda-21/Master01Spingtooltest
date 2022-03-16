package com.services.impl;

import com.dtos.GestionnaireDto;
import com.dtos.VacataireDto;
import com.entities.Gestionnaire;
import com.entities.Vacataire;
import com.repositories.GestionnaireRepository;
import com.services.GestionnaireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("gestionnaireService")
public class GestionnaireServiceImpl implements GestionnaireService {

    private final GestionnaireRepository gestionnaireRepository;

    public GestionnaireServiceImpl(GestionnaireRepository v){
        this.gestionnaireRepository = v;
    }


    @Override
    public GestionnaireDto enregistrerGestionnaire(GestionnaireDto GestionnaireDto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Gestionnaire r = m.gestionnaireDtoToEntity(GestionnaireDto);
        // Save the dog entity
        r = gestionnaireRepository.save(r);
        // Return the new dto
        return m.gestionnaireEntityToDto(r);
    }

    @Override
    public GestionnaireDto obtenirGestionnaireParId(Long id) {
        MapperServiceImpl m = new MapperServiceImpl();
        Gestionnaire r = gestionnaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Res not found"));
        return m.gestionnaireEntityToDto(r);
    }

    @Override
    public boolean supprimerGestionnaireParId(Long id) {
        this.gestionnaireRepository.deleteById(id);
        return true;
    }

    @Override
    public List<GestionnaireDto> obtenirTousLesGestionnaires() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<GestionnaireDto> GestionnaireDtos = new ArrayList<>();
        List<Gestionnaire> Gestionnaires = gestionnaireRepository.findAll();
        if (Gestionnaires != null) {
            Gestionnaires.forEach(Gestionnaire -> {
                GestionnaireDtos.add(mapperService.gestionnaireEntityToDto(Gestionnaire));
            });
        }
        return GestionnaireDtos;
    }
}
