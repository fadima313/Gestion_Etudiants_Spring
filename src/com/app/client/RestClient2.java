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


/**
 * Client for interacting with the Student API using RESTful services.
 */
public class RestClient2 {
//	private IService apiService;
	
    //private final StudentAPIService apiService;

    public RestClient2() {
        try {
            //apiService = new StudentAPIService();
        	IService apiService = new RESTService ();
        } catch (Exception e) {
            System.err.println("Error Class: " + e.getClass() + "\nError Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize API service", e);
        }
    }
     

    /**
     * Retrieve the list of students from the API.
     *
     * @return The list of students if successful, null otherwise.
     */
    public List<Etudiant> getAllStudents() {
    	IService apiService ;
    	try {
            //apiService = new StudentAPIService();
        	apiService = new RESTService ();
        } catch (Exception e) {
            System.err.println("Error Class: " + e.getClass() + "\nError Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize API service", e);
        }
    	
    	try {
            
        	Response response = apiService.doGet();
            
        	
        	if (response.getCode() == 200) {
            	List<Etudiant> etudiants = response.getEntities();
            return etudiants;
            } else {
            	String message = response.getMessage();
            	//DialogUtils.showMessage(message);
				
			}

        } 
        catch (JsonProcessingException e) {
        	System.out.println("Erreur de methode getAllStudents()");
//			System.err.println("Error Class : " + e.getClass() + "\nError Message : " + e.getMessage());
		}
        return null;
    }

    /**
     * Delete a student with the specified ID from the API.
     *
     * @param studentId The ID of the student to delete.
     */
    public boolean deleteStudent(int studentId) {
    	IService apiService ;
    	try {
            //apiService = new StudentAPIService();
        	apiService = new RESTService ();
        } catch (Exception e) {
            System.err.println("Error Class: " + e.getClass() + "\nError Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize API service", e);
        }
    	try {
            Response response = apiService.doDelete(studentId);
            if (response.getCode() == 200) {
                System.out.println("Student successfully deleted.");
                return true ;
            } else {
                
            }
        } catch (JsonProcessingException e) {
        }
        return false ;
    }

    /**
     * Add a new student using the provided student object.
     *
     * @param student The student to add.
     */
    public void addStudent(Etudiant student) {
    	IService apiService ;
    	try {
            //apiService = new StudentAPIService();
        	apiService = new RESTService ();
        } catch (Exception e) {
            System.err.println("Error Class: " + e.getClass() + "\nError Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize API service", e);
        }
    	try {
            Response response = apiService.doPost(student);
			Integer code = response.getCode();
			System.out.println(code);
            
            if (code == 200) {
            	String message = response.getMessage();
				//DialogUtils.showMessage(message);
            } else {
                
            }
        } catch (JsonProcessingException e) {
            
        }
        
    }

    /**
     * Update an existing student using the provided student object.
     *
     * @param student The updated student information.
     */
    public void updateStudent(Etudiant student) {
    	IService apiService ;
    	try {
            
        	apiService = new RESTService ();
        } catch (Exception e) {
            System.err.println("Error Class: " + e.getClass() + "\nError Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize API service", e);
        }
    	try {
            Response response = apiService.doPut(student);
            if (response.getCode() == 200) {
                System.out.println("Student successfully updated.");
               
            } else {
                
            }
        } catch (JsonProcessingException e) {
            
        }
    }


}