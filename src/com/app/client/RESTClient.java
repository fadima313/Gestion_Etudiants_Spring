package com.app.client;

import java.util.List;

import com.app.decoder.Response;
import com.app.entity.Etudiant;
import com.app.service.IService;
import com.app.service.RESTService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RESTClient {

    private IService rest;

    public RESTClient() {
        rest = new RESTService();
    }

    public static void main(String[] args) throws JsonProcessingException {
        RESTClient client = new RESTClient();
       client.testerGET();
        client.testerGET(19);
      
    }

    public void testerGET() {
        try {
            // Effectuer une requête GET
            Response response = rest.doGet();
            Integer code = response.getCode();

            if (code == 200) {
                // Traitement des données si la requête est réussie
                List<Etudiant> etudiants = response.getEntities();

                for (Etudiant item : etudiants) {
                    System.out.println(item);
                }
            } else {
                // Gérer les erreurs en cas de réponse autre que 200
                System.out.println("Code d'erreur : " + code);

                String message = response.getMessage();
                System.out.println("Message d'erreur : '" + message + "'");
            }

        } catch (JsonProcessingException e) {
            // Gérer les erreurs de sérialisation/désérialisation JSON
            System.err.println("Classe d'erreur : " + e.getClass() + "\nMessage d'erreur : " + e.getMessage());
        }
    }

    public void testerGET(Integer id) {
        try {
           
            Response response = rest.doGet(id);
            Integer code = response.getCode();

            if (code == 200) {
                Etudiant etudiant = response.getEntity();
                System.out.println("Étudiant avec l'ID " + id + " : " + etudiant);
            } else {
                System.out.println("Code d'erreur : " + code);

                String message = response.getMessage();
                System.out.println("Message d'erreur : '" + message + "'");
            }

        } catch (JsonProcessingException e) {
            System.err.println("Classe d'erreur : " + e.getClass() + "\nMessage d'erreur : " + e.getMessage());
        }
    }

    public void testerDELETE(Integer id) {
        try {
            rest.doDelete(id);
            System.out.println("Étudiant avec l'ID " + id + " supprimé avec succès.");

        } catch (JsonProcessingException e) {
            System.err.println("Classe d'erreur : " + e.getClass() + "\nMessage d'erreur : " + e.getMessage());
        }
    }


    public void testerPOST() throws JsonProcessingException {
        // Ajout d'un nouvel étudiant
		Etudiant nouvelEtudiant = new Etudiant();
		nouvelEtudiant.setNom("AKINOCHO");
		nouvelEtudiant.setPrenom("Ghislain");
		nouvelEtudiant.setMoyenne(18.2);

		testerPOST(nouvelEtudiant);
    }

    public void testerPOST(Etudiant etudiant) {
        try {
            Response response = rest.doPost(etudiant);
            Integer code = response.getCode();

            if (code == 200) {
                Etudiant etudiant2 = response.getEntity();
                System.out.println("Etudiant Ajoute avec succès.");
            } else {
                System.out.println("Code d'erreur : " + code);

                String message = response.getMessage();
                System.out.println("Message d'erreur : '" + message + "'");
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    public void testerPUT() {
        try {
            // Mettre à jour l'étudiant avec l'ID 1
            Etudiant etudiantToUpdate = new Etudiant();
            etudiantToUpdate.setId(19);
            etudiantToUpdate.setNom("DEMBELE");
            etudiantToUpdate.setPrenom("Fadi");
            etudiantToUpdate.setMoyenne(10.5);

            rest.doPut(etudiantToUpdate);
            System.out.println("Étudiant mis à jour avec succès.");

        } catch (JsonProcessingException e) {
            System.err.println("Classe d'erreur : " + e.getClass() + "\nMessage d'erreur : " + e.getMessage());
        }
    }
}
