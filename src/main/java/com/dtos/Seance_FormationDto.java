package com.dtos;


import com.entities.Creneau;
import com.entities.Vacataire;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class Seance_FormationDto {
    private Long Id;
    private String  estEffectue;
    private int dureeEffective;
    @OneToOne
    private CreneauDto c;
    private  int valide;
    private String          commentaire;
    private String nomcomposante;
    @OneToOne
    private VacataireDto vacataireDto;
}
