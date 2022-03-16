package com.entities;


import javax.persistence.*;

@Entity
@DiscriminatorValue("R")
public class Responsable extends Utilisateur{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private Composante composante;

    public Composante getComposante() {
        return this.composante;
    }

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    public void setComposante(Composante c) {
        this.composante=c;
    }
}
