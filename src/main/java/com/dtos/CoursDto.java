package com.dtos;

import com.entities.Filiere_Langue;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;
@Data
public class CoursDto {
    private Long Id;
    private String intitule;
    @OneToMany
    private List<VacataireDto> vacatairesDto;
    @OneToMany
    private List<Filiere_LangueDto> filieresDto;
    @OneToMany
    private List<CreneauDto> CreneauxDto;
}
