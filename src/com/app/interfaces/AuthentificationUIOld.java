package com.app.interfaces;


import javax.swing.*;

import com.app.controller.UIStudentsController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AuthentificationUIOld {

    private Map<String, String> users;

    public AuthentificationUIOld() {
        // Initialisation des utilisateurs (remplacez cela par une base de données réelle dans une application réelle)
        users = new HashMap<>();
        users.put("admin", "admin");
        users.put("utilisateur2", "motdepasse2");
        users.put("utilisateur3", "motdepasse3");
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuthentificationUI app = new AuthentificationUI();
            app.createAndShowGUI();
        });
    }
*/
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Authentification App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelLogin = new JLabel("Login:");
        JTextField textFieldLogin = new JTextField();

        JLabel labelPassword = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> handleLogin(textFieldLogin.getText(), new String(passwordField.getPassword())));

        panel.add(labelLogin);
        panel.add(textFieldLogin);
        panel.add(labelPassword);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for spacing
        panel.add(btnLogin);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void handleLogin(String login, String password) {
        if (authenticateUser(login, password)) {
            JOptionPane.showMessageDialog(null, "Authentification Réussie. Bienvenue, " + login + "!");
            openMainApplication();
        } else {
            JOptionPane.showMessageDialog(null, "Authentification Échouée. Le login ou le mot de passe est incorrect.");
        }
    }

    private boolean authenticateUser(String login, String password) {
        // Vérifie si l'utilisateur et le mot de passe correspondent à ceux enregistrés
        return users.containsKey(login) && users.get(login).equals(password);
    }

    private void openMainApplication() {
        // Remplacez ceci par le code pour ouvrir votre application principale
        JOptionPane.showMessageDialog(null, "Ouverture de l'application principale...");
        UIStudents uisStudents = new UIStudents();
    UIStudentsController uistController = new UIStudentsController(uisStudents);
    uistController.start();
    }
}
