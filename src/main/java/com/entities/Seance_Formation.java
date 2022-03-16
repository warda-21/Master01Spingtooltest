package com.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Seance_Formation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Creneau getC() {
        return c;
    }

    public void setC(Creneau c) {
        this.c = c;
    }

    @OneToOne
   private Creneau c;
    public String getEstEffectue() {
        return estEffectue;
    }

    public void setEstEffectue(String estEffectue) {
        this.estEffectue = estEffectue;
    }

    public int getDureeEffective() {
        return dureeEffective;
    }

    public void setDureeEffective(int dureeEffective) {
        this.dureeEffective = dureeEffective;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    private String  estEffectue;
            private int dureeEffective;
    private  int valide;
    private String          commentaire;

    private String nomcomposante;
    @OneToOne
    private  Vacataire vacataire;

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

    public Vacataire getVacataire() {
        return vacataire;
    }

    public void setVacataire(Vacataire vacataire) {
        this.vacataire = vacataire;
    }
}
