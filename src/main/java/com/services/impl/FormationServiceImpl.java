package com.services.impl;

import com.dtos.Seance_FormationDto;
import com.entities.Seance_Formation;
import com.repositories.FormationRepository;
import com.services.FormationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("formationService")
public class FormationServiceImpl implements FormationService {

    private FormationRepository fRepository;
    public FormationServiceImpl(FormationRepository f){
        this.fRepository= f;
    }



    @Override
    public Seance_FormationDto obtenirformationParID(Long f) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Seance_Formation seance_formation = this.fRepository.findById(f).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return mapperService.seanceFormationEntityToDto(seance_formation);
    }

    @Override
    public Seance_FormationDto enregistrerformation(Seance_FormationDto fdto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Seance_Formation r = m.seanceFormationDtoToEntity(fdto);
        // Save the dog entity
        r = fRepository.save(r);
        // Return the new dto
        return m.seanceFormationEntityToDto(r);
    }
    @Override
    public boolean supprimerFormationParId(Long id) {
        this.fRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Seance_FormationDto> listedesFormations() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<Seance_FormationDto> formationsDto = new ArrayList<>();
        List<Seance_Formation> formations = fRepository.findAll();
        if (formations != null) {
            formations.forEach(formation -> {
                formationsDto.add(mapperService.seanceFormationEntityToDto(formation));
            });
        }
        return formationsDto;
    }





}
