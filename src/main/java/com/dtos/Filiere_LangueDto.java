package com.dtos;


import com.entities.Composante;
import com.entities.Cours;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class Filiere_LangueDto {
    private  Long Id;
    private String codeFiliereLangue;
    private String    nomFiliereLangue;
    @OneToOne
    private ComposanteDto composanteDto;
    @OneToMany
    private List<CoursDto> coursDto;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCodeFiliereLangue() {
        return codeFiliereLangue;
    }

    public void setCodeFiliereLangue(String codeFiliereLangue) {
        this.codeFiliereLangue = codeFiliereLangue;
    }

    public String getNomFiliereLangue() {
        return nomFiliereLangue;
    }

    public void setNomFiliereLangue(String nomFiliereLangue) {
        this.nomFiliereLangue = nomFiliereLangue;
    }

    public ComposanteDto getComposanteDto() {
        return composanteDto;
    }

    public void setComposanteDto(ComposanteDto composanteDto) {
        this.composanteDto = composanteDto;
    }

    public List<CoursDto> getCoursDto() {
        return coursDto;
    }

    public void setCoursDto(List<CoursDto> coursDto) {
        this.coursDto = coursDto;
    }
}
