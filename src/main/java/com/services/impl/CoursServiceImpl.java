package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("coursService")
public class CoursServiceImpl implements CoursService {

    private CoursRepository cRepository;
    public CoursServiceImpl(CoursRepository f){
        this.cRepository= f;
    }



    @Override
    public CoursDto obtenirCoursparID(Long f) {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        Cours c = this.cRepository.findById(f).orElseThrow(() -> new EntityNotFoundException("composante n'existe pas"));
        return mapperService.coursEntityToDto(c);
    }
    @Override
    public CoursDto enregistrercours(CoursDto courdto) {

        // Converts the dto to the dog entity
        MapperServiceImpl m = new MapperServiceImpl();
        Cours r = m.coursDtoToEntiy(courdto);
        // Save the dog entity
        r = cRepository.save(r);
        // Return the new dto
        return m.coursEntityToDto(r);
    }
    @Override
    public boolean supprimerCoursParId(Long id) {
        this.cRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CoursDto> listedescours() {
        MapperServiceImpl mapperService = new MapperServiceImpl();
        List<CoursDto> coursDTO = new ArrayList<>();
        List<Cours> cours = cRepository.findAll();
        if (cours != null) {
            cours.forEach(cour -> {
                coursDTO.add(mapperService.coursEntityToDto(cour));
            });
        }
        return coursDTO;
    }





}
