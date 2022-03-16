package com.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="user_type")

public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String login;
    private String motDePasse;
    private String NomUsuel;
    private String prenom;
    private String mail;
    private String type;

    public String getLogin() {
        return login;
    }



    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNomUsuel() {
        return NomUsuel;
    }

    public void setNomUsuel(String nomUsuel) {
        NomUsuel = nomUsuel;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMot_de_passe() {
        return motDePasse;
    }

    public String getMail() {
        return mail;
    }

    public Long getId() {
        return this.Id;
    }


    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setId(Long id) {
        this.Id=id;
    }
}
