package com.dtos;


import lombok.Data;

import javax.persistence.*;

@Data
@DiscriminatorValue("R")
public class ResponsableDto extends UtilisateurDto{
  public void setId(Long id) {
    Id = id;
  }

  public void setComposanteDto(ComposanteDto composanteDto) {
    this.composanteDto = composanteDto;
  }

  private Long Id;
  @OneToOne
    private ComposanteDto composanteDto;

  public Long getId() {
    return Id;
  }



  public ComposanteDto getComposanteDto() {
    return composanteDto;
  }
}
