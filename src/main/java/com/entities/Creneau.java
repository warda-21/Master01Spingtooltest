package com.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Creneau {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Date date;
    private int duree;
    private String type;
    @OneToOne
    private Cours cour;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cours getCour() {
        return cour;
    }

    public void setCour(Cours cour) {
        this.cour = cour;
    }

    public List<Seance_Formation> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance_Formation> seances) {
        this.seances = seances;
    }

    @OneToMany
    private List<Seance_Formation> seances;



}
