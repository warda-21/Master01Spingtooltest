package com.dtos;


import com.entities.Cours;
import com.entities.Seance_Formation;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@DiscriminatorValue("V")
public class VacataireDto extends  UtilisateurDto{


    @OneToOne
    private CoursDto coursDto;
    @OneToMany
    private List<Seance_FormationDto> formationsDto;
}
