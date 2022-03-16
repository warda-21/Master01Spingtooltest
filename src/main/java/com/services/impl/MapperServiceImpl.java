package com.services.impl;

import com.dtos.*;
import com.entities.*;
import com.services.MapperService;

import java.util.ArrayList;
import java.util.List;

public class MapperServiceImpl implements MapperService {
    /**
     *
     * @param vacataireDto
     * @return
     */

    /**
     *
     * @param utilisateurDto
     * @return
     */
    @Override
    public Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setLogin(utilisateurDto.getLogin());
        utilisateur.setMail(utilisateurDto.getMail());
        utilisateur.setNomUsuel(utilisateurDto.getNomUsuel());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     * @return
     */
    @Override
    public UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMail(utilisateur.getMail());
        utilisateurDto.setNomUsuel(utilisateur.getNomUsuel());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        return utilisateurDto;
    }



    /**
     *
     * @param responsableDto
     * @return
     */
    @Override
    public Responsable responsableDtoToEntity(ResponsableDto responsableDto) {
        Responsable responsable = new Responsable();
        responsable.setId(responsableDto.getId());
        responsable.setLogin(responsableDto.getLogin());
        responsable.setMail(responsableDto.getMail());
        responsable.setPrenom(responsableDto.getPrenom());
        responsable.setMotDePasse(responsableDto.getMotDePasse());
        responsable.setNomUsuel(responsableDto.getNomUsuel());

       ComposanteDto composanteDto = responsableDto.getComposanteDto();
        responsable.setComposante(this.composanteDtoToEntity(composanteDto));




        return responsable;
    }

    /**
     *
     * @param responsable
     * @return
     */
    @Override
    public ResponsableDto responsableEntityToDto(Responsable responsable) {
        ResponsableDto responsableDto = new ResponsableDto();
        responsableDto.setId(responsable.getId());
        responsableDto.setLogin(responsable.getLogin());
        responsableDto.setMail(responsable.getMail());
        responsableDto.setPrenom(responsable.getPrenom());
        responsableDto.setMotDePasse(responsable.getMotDePasse());
        responsableDto.setNomUsuel(responsable.getNomUsuel());

        //tables de jointure
        Composante composante= responsable.getComposante();
        responsableDto.setComposanteDto(this.composanteEntityToDto(composante));


        return responsableDto;
    }

    /**
     *
     * @param gestionnaireDto
     * @return
     */
    @Override
    public Gestionnaire gestionnaireDtoToEntity(GestionnaireDto gestionnaireDto) {
        Gestionnaire gestionnaire = new Gestionnaire();
        gestionnaire.setId(gestionnaireDto.getId());
        gestionnaire.setLogin(gestionnaireDto.getLogin());
        gestionnaire.setMail(gestionnaireDto.getMail());
        gestionnaire.setPrenom(gestionnaireDto.getPrenom());
        gestionnaire.setNomUsuel(gestionnaireDto.getNomUsuel());
        gestionnaire.setMotDePasse(gestionnaireDto.getMotDePasse());
        return gestionnaire;
    }

    /**
     *
     * @param gestionnaire
     * @return gestionnaireDto
     */
    @Override
    public GestionnaireDto gestionnaireEntityToDto(Gestionnaire gestionnaire) {
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        gestionnaireDto.setId(gestionnaire.getId());
        gestionnaireDto.setLogin(gestionnaire.getLogin());
        gestionnaireDto.setMail(gestionnaire.getMail());
        gestionnaireDto.setPrenom(gestionnaire.getPrenom());
        gestionnaireDto.setNomUsuel(gestionnaire.getNomUsuel());
        gestionnaireDto.setMotDePasse(gestionnaire.getMotDePasse());
        return gestionnaireDto;
    }



    @Override
    public ComposanteDto composanteEntityToDto(Composante composante) {
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setNomcomposante(composante.getNomcomposante());
        composanteDto.setId(composante.getId());

        Responsable r=composante.getResponsables();
        ResponsableDto rdto = new ResponsableDto();
        rdto.setId(r.getId()); rdto.setLogin(r.getLogin()); rdto.setNomUsuel(r.getNomUsuel());
        rdto.setPrenom(r.getPrenom());rdto.setMail(r.getMail());rdto.setType(r.getType());
        composanteDto.setResponsablesDto(rdto);
        System.out.println("id responsable  "+r.getId());
        System.out.println("id responsable  "+composanteDto.getResponsablesDto().getId());

       List<Filiere_Langue> filiere_langueList = composante.getFilieres();
        List<Filiere_LangueDto> filiere_langueDtoList = new ArrayList<>();
        Filiere_LangueDto f =new Filiere_LangueDto();
        for(Filiere_Langue filiere_langue : filiere_langueList){
            f.setId(filiere_langue.getId());
            f.setCodeFiliereLangue(filiere_langue.getCodeFiliereLangue());
            f.setNomFiliereLangue(filiere_langue.getNomFiliereLangue());
            filiere_langueDtoList.add(f);
        }

        composanteDto.setFilieresDto(filiere_langueDtoList);


        return composanteDto;
    }


    /**
      * @param composanteDto
     * @return
     */
    @Override
    public Composante composanteDtoToEntity(ComposanteDto composanteDto) {
        Composante composante = new Composante();
        composante.setNomcomposante(composanteDto.getNomcomposante());
        composante.setId(composanteDto.getId());
        composante.getResponsables().setId(composanteDto.getResponsablesDto().getId());//new line added
     ////Les reponsables

        ResponsableDto rdto=composanteDto.getResponsablesDto();
        Responsable r = new Responsable();

        r.setId(rdto.getId()); r.setLogin(rdto.getLogin()); r.setNomUsuel(rdto.getNomUsuel());
        r.setPrenom(rdto.getPrenom());r.setMail(rdto.getMail());r.setType(rdto.getType());
        composante.setResponsables(r);


        //les fillieres
        List<Filiere_LangueDto> filiere_langueDtoList = composanteDto.getFilieresDto();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        Filiere_Langue f = new Filiere_Langue();
        for(Filiere_LangueDto filiere_langueDto: filiere_langueDtoList){
            f.setId(filiere_langueDto.getId());
            f.setCodeFiliereLangue(filiere_langueDto.getCodeFiliereLangue());
            f.setNomFiliereLangue(filiere_langueDto.getNomFiliereLangue());
            filiere_langueList.add(f);
        }


        composante.setFilieres(filiere_langueList);



        return composante;
    }


    @Override
    public Filiere_LangueDto filiere_langueEntityToDto(Filiere_Langue filiere_langue) {
        Filiere_LangueDto filiere_langueDto = new Filiere_LangueDto();
        filiere_langueDto.setId(filiere_langue.getId());
        filiere_langueDto.setCodeFiliereLangue(filiere_langue.getCodeFiliereLangue());
        filiere_langueDto.setNomFiliereLangue(filiere_langue.getNomFiliereLangue());

       /**
        * coposante d'une filiere
        */
      Composante composante = filiere_langue.getComposante();
       filiere_langueDto.setComposanteDto(this.composanteEntityToDto(composante));
        /**
         * List des cours d'une filiere
         */
        List<Cours> coursList = filiere_langue.getCours();
        List<CoursDto> coursDtoList = new ArrayList<>();
        CoursDto coursDto = new CoursDto();
        for(Cours cours : coursList){
            coursDto.setId(cours.getId());
            coursDto.setIntitule(cours.getIntitule());
            coursDtoList.add(coursDto);
        }
        filiere_langueDto.setCoursDto(coursDtoList);


        return filiere_langueDto;
    }

    /**
     *
     * @param filiere_langueDto
     * @return
     */
    @Override
    public Filiere_Langue filiere_langueDtoToEntity(Filiere_LangueDto filiere_langueDto) {
        Filiere_Langue filiere_langue = new Filiere_Langue();
        filiere_langue.setId(filiere_langueDto.getId());
        filiere_langue.setCodeFiliereLangue(filiere_langueDto.getCodeFiliereLangue());
        filiere_langue.setNomFiliereLangue(filiere_langueDto.getNomFiliereLangue());
        /**
         * recupereation de composante d'une filiere
         */
        ComposanteDto composanteDto = filiere_langueDto.getComposanteDto();
        filiere_langue.setComposante(this.composanteDtoToEntity(composanteDto));
        /**
         * recuperation des cours d'une filiere
         */
        List<CoursDto> coursDtoList = filiere_langueDto.getCoursDto();
        List<Cours> coursList = new ArrayList<>();
        Cours cours=new Cours();
        for(CoursDto coursDto: coursDtoList){
            cours.setId(coursDto.getId());
            cours.setIntitule(coursDto.getIntitule());
            coursList.add(cours);
        }
        filiere_langue.setCours(coursList);




        return filiere_langue;
    }
    /**
     *
     * @param creneau
     * @return
     */
    @Override
    public CreneauDto creneauEntityToDto(Creneau creneau) {
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setId(creneau.getId());
        creneauDto.setDate(creneau.getDate());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setType(creneau.getType());

        /**
         * recuperation du cours associé au creneau
         */
        Cours cours = creneau.getCour();
        CoursDto coursDto = new CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());
        creneauDto.setCoursDto(coursDto);
        /**
         * recuperation de la liste des formations pour un creneau
         */

        List<Seance_Formation> seance_formations = creneau.getSeances();
        List<Seance_FormationDto> seanceFormationDtoList = new ArrayList<>();
        Seance_FormationDto seance = new Seance_FormationDto();
        for(Seance_Formation seance_formation : seance_formations){
            seance.setId(seance_formation.getId());
            seance.setDureeEffective(seance_formation.getDureeEffective());
            seance.setEstEffectue(seance_formation.getEstEffectue());
            seance.setCommentaire(seance_formation.getCommentaire());
            seance.setValide(seance_formation.getValide());
            seanceFormationDtoList.add(seance);
        }
        creneauDto.setSeancesDto(seanceFormationDtoList);




        return creneauDto;
    }

    /**
     *
     * @param creneauDto
     * @return
     */
    @Override
    public Creneau creneauDtoToEntity(CreneauDto creneauDto) {
        Creneau creneau = new Creneau();
        creneau.setId(creneauDto.getId());
        creneau.setDate(creneauDto.getDate());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());

        CoursDto coursDto = creneauDto.getCoursDto();
        Cours cours = new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());
        creneau.setCour(cours);
        /**
         * recuperation de la liste de seance de formation
         */
        List<Seance_FormationDto> seanceFormationDtoList = creneauDto.getSeancesDto();
        List<Seance_Formation> seance_formations = new ArrayList<>();
        Seance_Formation seance = new Seance_Formation();
        for(Seance_FormationDto seance_formationDto : seanceFormationDtoList){
            seance.setId(seance_formationDto.getId());
            seance.setDureeEffective(seance_formationDto.getDureeEffective());
            seance.setEstEffectue(seance_formationDto.getEstEffectue());
            seance.setCommentaire(seance_formationDto.getCommentaire());
            seance.setValide(seance_formationDto.getValide());
            seance_formations.add(seance);
        }
        creneau.setSeances(seance_formations);


        return creneau;
    }

    /**
     *
     * @param coursDto
     * @return
     */
    @Override
    public Cours coursDtoToEntiy(CoursDto coursDto) {
        Cours cours =new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());

        List<CreneauDto> creneauDtoList = coursDto.getCreneauxDto();
        List<Creneau> creneauList = new ArrayList<>();
        Creneau c = new Creneau();
        for(CreneauDto creneauDto : creneauDtoList){
            c.setId(creneauDto.getId());c.setDate(creneauDto.getDate());c.setDuree(creneauDto.getDuree());
            c.setType(creneauDto.getType());
            creneauList.add(c);
        }
        cours.setCreneaux(creneauList);



      List<VacataireDto> vacataireDtos = coursDto.getVacatairesDto();
        List<Vacataire> vacataires = new ArrayList<>();
        Vacataire v = new Vacataire();
        for(VacataireDto vacataireDto : vacataireDtos){
            v.setId(vacataireDto.getId());
            v.setLogin(vacataireDto.getLogin());
            v.setMotDePasse(vacataireDto.getMotDePasse());
            v.setMail(vacataireDto.getMail());
            v.setNomUsuel(vacataireDto.getNomUsuel());
            v.setPrenom(vacataireDto.getPrenom());
            v.setType(vacataireDto.getType());

            vacataires.add(v);
        }
        cours.setVacataires(vacataires);



       /*    List<Filiere_LangueDto> filiere_langueDtos = coursDto.getFilieresDto();
        List<Filiere_Langue> filiere_langueList = new ArrayList<>();
        Filiere_Langue f = new Filiere_Langue();
     for(Filiere_LangueDto filiere_langueDto: filiere_langueDtos){
            f.setId(filiere_langueDto.getId());
            f.setNomFiliereLangue(filiere_langueDto.getNomFiliereLangue());
            f.setCodeFiliereLangue(filiere_langueDto.getCodeFiliereLangue());
            filiere_langueList.add(f);
        }
        cours.setFilieres(filiere_langueList);
*/



        return cours;
    }

    @Override
    public CoursDto coursEntityToDto(Cours cours) {
        CoursDto coursDto = new  CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());

        List<Creneau> creneauList = cours.getCreneaux();
        List<CreneauDto> creneauDtoList  = new ArrayList<>();
        CreneauDto c = new CreneauDto();
        for(Creneau creneau: creneauList){
            c.setId(creneau.getId());
            c.setType(creneau.getType());
            c.setDuree(creneau.getDuree());
            c.setDate(creneau.getDate());
            creneauDtoList.add(c);
        }
        coursDto.setCreneauxDto(creneauDtoList);



        List<Vacataire> vacataireList = cours.getVacataires();
        List<VacataireDto> vacataireDtoList = new ArrayList<>();
        VacataireDto v = new VacataireDto();
        for(Vacataire vacataire : vacataireList){
            v.setId(vacataire.getId());
            v.setLogin(vacataire.getLogin());
            v.setMotDePasse(vacataire.getMotDePasse());
            v.setMail(vacataire.getMail());
            v.setNomUsuel(vacataire.getNomUsuel());
            v.setPrenom(vacataire.getPrenom());
            v.setType(vacataire.getType());
            vacataireDtoList.add(v);
        }
        coursDto.setVacatairesDto(vacataireDtoList);
        /*
        recupération des filieres d'un Cours
         */

        /*
        List<Filiere_Langue> filiere_langueList = cours.getFilieres();
        List<Filiere_LangueDto> filiere_langueDtos = new ArrayList<>();
        Filiere_LangueDto fdto = new Filiere_LangueDto();
        for (Filiere_Langue filiere_langue : filiere_langueList){
            fdto.setId(filiere_langue.getId());
            fdto.setNomFiliereLangue(filiere_langue.getNomFiliereLangue());
            fdto.setCodeFiliereLangue(filiere_langue.getCodeFiliereLangue());
            filiere_langueDtos.add(fdto);
        }
        coursDto.setFilieresDto(filiere_langueDtos);
        */



        return coursDto;
    }



    @Override
    public Vacataire vacataireDtoToEntity(VacataireDto vacataireDto) {
        Vacataire v = new Vacataire();
        v.setId(vacataireDto.getId());
        v.setLogin(vacataireDto.getLogin());
        v.setMotDePasse(vacataireDto.getMotDePasse());
        v.setPrenom(vacataireDto.getPrenom());
        v.setNomUsuel(vacataireDto.getNomUsuel());
        v.setMail(vacataireDto.getMail());

        //est effectué par une liste de seance formation
        List<Seance_FormationDto> seance_formationsDto = vacataireDto.getFormationsDto();
        List<Seance_Formation> formationList = new ArrayList<>();
        for(Seance_FormationDto sf: seance_formationsDto){
            formationList.add(this.seanceFormationDtoToEntity(sf));
        }
        v.setFormations(formationList);

        //partici pe à 0 ou plusieurs Cours
        CoursDto cours = vacataireDto.getCoursDto();
        v.setCours(this.coursDtoToEntiy(cours));
        return v;
    }

    /**
     *
     * @param vacataire
     * @return
     */
    @Override
    public VacataireDto vacataireEntityToDto(Vacataire vacataire) {
        VacataireDto v = new VacataireDto();
        v.setId(vacataire.getId());
        v.setLogin(vacataire.getLogin());
        v.setMotDePasse(vacataire.getMotDePasse());
        v.setPrenom(vacataire.getPrenom());
        v.setNomUsuel(vacataire.getNomUsuel());
        v.setMail(vacataire.getMail());

        //est effectué par une liste de seance formation
        List<Seance_Formation> seance_formations = vacataire.getFormations();
        List<Seance_FormationDto> formationDtoList = new ArrayList<>();
        for(Seance_Formation sf: seance_formations){
            formationDtoList.add(this.seanceFormationEntityToDto(sf));
        }
        v.setFormationsDto(formationDtoList);

        //participe à 0 ou plusieurs Cours
        Cours cours = vacataire.getCours();

        v.setCoursDto(this.coursEntityToDto(cours));
        return v;
    }

    @Override
    public Seance_Formation seanceFormationDtoToEntity(Seance_FormationDto seance_formationDto) {
        Seance_Formation seance_formation = new Seance_Formation();
        //transformation des attributs de la classe
        seance_formation.setId(seance_formationDto.getId());

        seance_formation.setEstEffectue(seance_formationDto.getEstEffectue());
        seance_formation.setDureeEffective(seance_formationDto.getDureeEffective());
        seance_formation.setValide(seance_formationDto.getValide());
        seance_formation.setCommentaire(seance_formationDto.getCommentaire());

        /**
         * les creneaux de la seance formations
         */

        CreneauDto creneauDto = seance_formationDto.getC();
        Creneau creneau = new Creneau();
        creneau.setType(creneauDto.getType());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setDate(creneauDto.getDate());
        seance_formation.setC(creneau);
        /**
         * les vacataires de la seance formations
         */
        VacataireDto vacataireDto = seance_formationDto.getVacataireDto();
        Vacataire vacataire = new Vacataire();
        vacataire.setId(vacataireDto.getId());
        vacataire.setLogin(vacataireDto.getLogin());
        vacataire.setNomUsuel(vacataireDto.getNomUsuel());
        vacataire.setPrenom(vacataireDto.getPrenom());
        vacataire.setMail(vacataireDto.getMail());
        vacataire.setMotDePasse(vacataireDto.getMotDePasse());
        seance_formation.setVacataire(vacataire);
        return seance_formation;
    }

    /**
     *
     * @param seance_formation
     * @return
     */
    @Override
    public Seance_FormationDto seanceFormationEntityToDto(Seance_Formation seance_formation) {
        Seance_FormationDto seance_formationDto = new Seance_FormationDto();

        seance_formationDto.setId(seance_formation.getId());
        seance_formationDto.setEstEffectue(seance_formation.getEstEffectue());
        seance_formationDto.setDureeEffective(seance_formation.getDureeEffective());
        seance_formationDto.setValide(seance_formation.getValide());
        seance_formationDto.setCommentaire(seance_formation.getCommentaire());

        /**
         * les creneaux de la seance formation
         */
        Creneau creneau = seance_formation.getC();
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setType(creneau.getType());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setDate(creneau.getDate());
        seance_formationDto.setC(creneauDto);

        /**
         * les vacataires de la seance formations
         */
        Vacataire vacataire = seance_formation.getVacataire();
        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(vacataire.getId());
        vacataireDto.setLogin(vacataire.getLogin());
        vacataireDto.setNomUsuel(vacataire.getNomUsuel());
        vacataireDto.setPrenom(vacataire.getPrenom());
        vacataireDto.setMail(vacataire.getMail());
        vacataireDto.setMotDePasse(vacataire.getMotDePasse());
        seance_formationDto.setVacataireDto(vacataireDto);
        return seance_formationDto;
    }

}



