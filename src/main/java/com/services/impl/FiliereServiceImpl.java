package com.services.impl;

import com.dtos.Filiere_LangueDto;
import com.entities.Filiere_Langue;
import com.repositories.FiliereRepository;
import com.services.FiliereService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("filiereService")
public class FiliereServiceImpl implements FiliereService {

    private FiliereRepository fRepository;
    public FiliereServiceImpl(FiliereRepository f){
        this.fRepository= f;
    }



    @Override
    public Filiere_LangueDto obtenirfiliereParID(Long f) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Filiere_Langue composante = this.fRepository.findById(f).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return mapperService.filiere_langueEntityToDto(composante);
    }
    @Override
    public Filiere_LangueDto enregistrerfiliere(Filiere_LangueDto fdto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Filiere_Langue r = m.filiere_langueDtoToEntity(fdto);
        // Save the dog entity
        r = fRepository.save(r);
        // Return the new dto
        return m.filiere_langueEntityToDto(r);
    }
    @Override
    public boolean supprimerFiliereParId(Long id) {
        this.fRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Filiere_LangueDto> listedesfilieres() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<Filiere_LangueDto> filieresDto = new ArrayList<>();
        List<Filiere_Langue> filieres = fRepository.findAll();
        if (filieres != null) {
            filieres.forEach(filiere -> {
                filieresDto.add(mapperService.filiere_langueEntityToDto(filiere));
            });
        }
        return filieresDto;
    }





}
