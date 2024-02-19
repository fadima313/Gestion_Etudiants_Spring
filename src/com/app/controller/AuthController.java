package com.app.controller;

import com.app.interfaces.AuthUINew;
import com.app.interfaces.UIStudents;
import com.app.service.WSAuthentification;

public class AuthController {

    private AuthUINew authUI;
    private WSAuthentification wsAuthentification;

    public AuthController(AuthUINew authUI, WSAuthentification wsAuthentification) {
        this.authUI = authUI;
        this.wsAuthentification = wsAuthentification;

        initialize();
    }

    private void initialize() {
    	
    	
    	
    }

    private void loginUser() {
        String login = authUI.getLogin();
        String password = authUI.getPassword();

        if (wsAuthentification.validate(login, password)) {
            authUI.showMessage("Login successful");
            authUI.dispose();
            // Vous pouvez également ouvrir la fenêtre principale ici si nécessaire
            // new MainAppUI().setVisible(true);
        } else {
            authUI.showMessage("Login failed. Invalid credentials.");
        }
    }
    
    private void openMainApplication() {
        // Replace this with the code to open your main application
        //authUI.showMessage("Opening the main application...");
        UIStudents uiStudents = new UIStudents();
        UIStudentsController uiController = new UIStudentsController(uiStudents);
        uiController.start();
    }

    public void start() {
        authUI.display();
    }
}
