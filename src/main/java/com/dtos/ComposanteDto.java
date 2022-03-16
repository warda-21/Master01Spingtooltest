package com.dtos;


import com.entities.Filiere_Langue;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class ComposanteDto {
    private Long Id;
    private String nomcomposante;
    @OneToOne
    private ResponsableDto responsablesDto;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNomcomposante() {
        return nomcomposante;
    }

    public void setNomcomposante(String nomcomposante) {
        this.nomcomposante = nomcomposante;
    }

    public ResponsableDto getResponsablesDto() {
        return responsablesDto;
    }

    public void setResponsablesDto(ResponsableDto responsablesDto) {
        this.responsablesDto = responsablesDto;
    }

    public List<Filiere_LangueDto> getFilieresDto() {
        return filieresDto;
    }

    public void setFilieresDto(List<Filiere_LangueDto> filieresDto) {
        this.filieresDto = filieresDto;
    }

    @OneToMany
    private  List<Filiere_LangueDto> filieresDto;

}
