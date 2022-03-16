package com.services.impl;

import com.dtos.ResponsableDto;
import com.entities.Responsable;
import com.repositories.ResponsableRepository;
import com.services.ResponsableService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("responsableService")
public class ResponsableServiceImpl implements ResponsableService {

    private final ResponsableRepository resRepository;

    public ResponsableServiceImpl(ResponsableRepository resRepository){
        this.resRepository = resRepository;
    }


    @Override
    public ResponsableDto enregistrerResponsable(ResponsableDto responsableDto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Responsable r = m.responsableDtoToEntity(responsableDto);
        // Save the dog entity
        r = resRepository.save(r);
        // Return the new dto
        return m.responsableEntityToDto(r);
    }

    @Override
    public ResponsableDto obtenirResponsableParId(Long idResponsable) {
        MapperServiceImpl m = new MapperServiceImpl();
        Responsable r = resRepository.findById(idResponsable).orElseThrow(() -> new EntityNotFoundException("Res not found"));
        return m.responsableEntityToDto(r);
    }

    @Override
    public boolean supprimerResponsableParId(Long idResponsable) {
        this.resRepository.deleteById(idResponsable);
        return true;
    }

    @Override
    public List<ResponsableDto> obtenirTousLesResponsables() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<ResponsableDto> responsableDtos = new ArrayList<>();
        List<Responsable> responsables = resRepository.findAll();
        if (responsables != null) {
            responsables.forEach(responsable -> {
                responsableDtos.add(mapperService.responsableEntityToDto(responsable));
            });
        }
        return responsableDtos;
    }
}
