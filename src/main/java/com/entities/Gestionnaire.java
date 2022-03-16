package com.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("G")
public class Gestionnaire extends Utilisateur{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
}
