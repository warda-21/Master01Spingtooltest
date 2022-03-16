package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Creneau;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("creneauService")
public class CreneauServiceImpl implements CreneauService {

    private CreneauRepository cRepository;
    public CreneauServiceImpl(CreneauRepository cr){
        this.cRepository= cr;
    }



    @Override
    public CreneauDto obtenirCreneauparID(Long f) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Creneau c = this.cRepository.findById(f).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return mapperService.creneauEntityToDto(c);
    }
    @Override
    public CreneauDto enregistrerCreneau(CreneauDto creneauDto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Creneau  creneau = m.creneauDtoToEntity(creneauDto);
        // Save the dog entity
        creneau = cRepository.save(creneau);
        // Return the new dto
        return m.creneauEntityToDto(creneau);
    }
    @Override
    public boolean supprimerCreneauParId(Long id) {
        this.cRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CreneauDto> listedesCreneau() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<CreneauDto> creneauDTO = new ArrayList<>();
        List<Creneau> creneaux = cRepository.findAll();
        if (creneaux != null) {
            creneaux.forEach(creneau -> {
                creneauDTO.add(mapperService.creneauEntityToDto( creneau));
            });
        }
        return creneauDTO;
    }





}
