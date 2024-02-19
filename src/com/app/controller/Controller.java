package com.app.controller;


import com.app.decoder.Response;
import com.app.entity.Etudiant;
import com.app.service.RESTService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class Controller {

    private final RESTService restService;

    public Controller(RESTService restService) {
        this.restService = restService;
    }

    public Response handleAddStudent() throws JsonProcessingException {
        Etudiant nouvelEtudiant = new Etudiant();
        nouvelEtudiant.setNom("Nom de l'étudiant");
        nouvelEtudiant.setPrenom("Prénom de l'étudiant");
        nouvelEtudiant.setMoyenne(15.5);

        return restService.doPost(nouvelEtudiant);
    }

    public Response handleDisplayStudents() throws JsonProcessingException {
        return restService.doGet();
    }

    public Response handleSearchStudent(Integer studentId) throws JsonProcessingException {
        return restService.doGet(studentId);
    }

    public Response handleDeleteStudent(Integer studentIdToDelete) throws JsonProcessingException {
        return restService.doDelete(studentIdToDelete);
    }

    public Response handleUpdateStudent(Etudiant etudiantToUpdate) throws JsonProcessingException {
        return restService.doPut(etudiantToUpdate);
    }
}
