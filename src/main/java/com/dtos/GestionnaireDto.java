package com.dtos;


import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@DiscriminatorValue("G")
public class GestionnaireDto extends  UtilisateurDto{


   private Long Id;
}
