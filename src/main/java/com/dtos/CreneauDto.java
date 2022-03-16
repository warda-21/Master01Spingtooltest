package com.dtos;

import com.entities.Cours;
import com.entities.Seance_Formation;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Data
public class CreneauDto {
    private Long Id;

    private Date date;
    private int duree;
    private String type;
    @OneToOne
    private CoursDto coursDto;
    @OneToMany
    private List<Seance_FormationDto> seancesDto;
}
