package com.services;

import com.dtos.*;
import com.entities.*;

public interface MapperService {


    Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto);

    UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur);

    Responsable responsableDtoToEntity(ResponsableDto responsableDto);
    ResponsableDto responsableEntityToDto(Responsable responsable);


    Gestionnaire gestionnaireDtoToEntity(GestionnaireDto gestionnaireDto);

    GestionnaireDto gestionnaireEntityToDto(Gestionnaire gestionnaire);

    ComposanteDto composanteEntityToDto(Composante composante);

    Composante composanteDtoToEntity(ComposanteDto composanteDto);

    Filiere_LangueDto filiere_langueEntityToDto(Filiere_Langue filiere_langue);

    Filiere_Langue filiere_langueDtoToEntity(Filiere_LangueDto filiere_langueDto);

    CreneauDto creneauEntityToDto(Creneau creneau);

    Creneau creneauDtoToEntity(CreneauDto creneauDto);

    Cours coursDtoToEntiy(CoursDto coursDto);

    CoursDto coursEntityToDto(Cours cours);

    Vacataire vacataireDtoToEntity(VacataireDto vacataireDto);

    VacataireDto vacataireEntityToDto(Vacataire vacataire);

    Seance_Formation seanceFormationDtoToEntity(Seance_FormationDto seance_formationDto);

    Seance_FormationDto seanceFormationEntityToDto(Seance_Formation seance_formation);
}
