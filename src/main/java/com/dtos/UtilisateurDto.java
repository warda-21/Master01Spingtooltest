package com.dtos;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data

//ici on defini les données a recuperer pour un utilisateur
public class UtilisateurDto {

    private Long Id;
    private String login;
    private String motDePasse;
    private String NomUsuel;
    private String prenom;
    private String mail;
    private String type;
}
