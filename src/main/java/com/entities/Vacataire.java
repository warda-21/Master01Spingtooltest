package com.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@DiscriminatorValue("V")
public class Vacataire extends Utilisateur{

    @OneToOne
    private Cours cours;
    @OneToMany
    private List<Seance_Formation> formations;

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<Seance_Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Seance_Formation> formations) {
        this.formations = formations;
    }
}
