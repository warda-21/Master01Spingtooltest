package com.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Filiere_Langue {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
   private String codeFiliereLangue;
        private String    nomFiliereLangue;

    @OneToOne
    private Composante composante;

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

    public Composante getComposante() {
        return composante;
    }

    public void setComposante(Composante composante) {
        this.composante = composante;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    @OneToMany
    private List<Cours> cours;
}
