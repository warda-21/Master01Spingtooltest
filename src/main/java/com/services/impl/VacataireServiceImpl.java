package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

    private final VacataireRepository vacataireRepository;

    public VacataireServiceImpl(VacataireRepository v){
        this.vacataireRepository = v;
    }


    @Override
    public VacataireDto enregistrerVacataire(VacataireDto vacataireDto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Vacataire r = m.vacataireDtoToEntity(vacataireDto);
        // Save the dog entity
        r = vacataireRepository.save(r);
        // Return the new dto
        return m.vacataireEntityToDto(r);
    }

    @Override
    public VacataireDto obtenirVacataireParId(Long id) {
        MapperServiceImpl m = new MapperServiceImpl();
        Vacataire r = vacataireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Res not found"));
        return m.vacataireEntityToDto(r);
    }

    @Override
    public boolean supprimerVacataireParId(Long id) {
        this.vacataireRepository.deleteById(id);
        return true;
    }

    @Override
    public List<VacataireDto> obtenirTousLesVacataires() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = vacataireRepository.findAll();
        if (vacataires != null) {
            vacataires.forEach(vacataire -> {
                vacataireDtos.add(mapperService.vacataireEntityToDto(vacataire));
            });
        }
        return vacataireDtos;
    }
}
