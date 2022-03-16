package com.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String intitule;
    @OneToMany
    private List<Vacataire> vacataires;
    @OneToMany
    private List<Filiere_Langue> filieres;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Vacataire> getVacataires() {
        return vacataires;
    }

    public void setVacataires(List<Vacataire> vacataires) {
        this.vacataires = vacataires;
    }

    public List<Filiere_Langue> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere_Langue> filieres) {
        this.filieres = filieres;
    }

    public List<Creneau> getCreneaux() {
        return Creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        Creneaux = creneaux;
    }

    @OneToMany
    private List<Creneau> Creneaux;

}
