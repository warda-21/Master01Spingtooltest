package com.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Composante {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nomcomposante;
    @OneToOne
    private Responsable responsables;
    @OneToMany
    private  List<Filiere_Langue> filieres;

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

    public Responsable getResponsables() {
        return this.responsables;
    }

    public void setResponsables(Responsable responsables) {
        this.responsables = responsables;
    }

    public List<Filiere_Langue> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere_Langue> filieres) {
        this.filieres = filieres;
    }
}
