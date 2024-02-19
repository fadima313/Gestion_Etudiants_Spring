package com.app.controller;

import com.app.interfaces.AuthentificationUI;
import com.app.interfaces.UIStudents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AuthentificationUIController {

    private AuthentificationUI authUI;
    private Map<String, String> users;

    public AuthentificationUIController(AuthentificationUI authUI) {
        this.authUI = authUI;
        this.users = new HashMap<>();
        initializeUsers();

        // Add action listener to the login button
        authUI.btnLogin.addActionListener(new LoginButtonListener());
    }

    private void initializeUsers() {
        // Initialization of users (replace this with a real database in a real application)
        users.put("admin", "admin");
        users.put("utilisateur2", "motdepasse2");
        users.put("utilisateur3", "motdepasse3");
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String login = authUI.getLogin();
            String password = authUI.getPassword();

            if (authenticateUser(login, password)) {
                authUI.showMessage("Authentication Successful. Welcome, " + login + "!");
                openMainApplication();
            } else {
                authUI.showMessage("Authentication Failed. Incorrect login or password.");
            }
        }

        private boolean authenticateUser(String login, String password) {
            // Check if the user and password match those stored
            return users.containsKey(login) && users.get(login).equals(password);
        }

        private void openMainApplication() {
            // Replace this with the code to open your main application
            authUI.showMessage("Opening the main application...");
            UIStudents uiStudents = new UIStudents();
            UIStudentsController uiController = new UIStudentsController(uiStudents);
            uiController.start();
        }
        
    }
    
    public void start() {
    	authUI.display();
    }

    
}
