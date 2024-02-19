package com.app.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthentificationUI extends JFrame {

    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    public JButton btnLogin;

    public AuthentificationUI() {
       
    	setTitle("Authentification App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelLogin = new JLabel("Login:");
        textFieldLogin = new JTextField();

        JLabel labelPassword = new JLabel("Password:");
        passwordField = new JPasswordField();

        btnLogin = new JButton("Login");
       // btnLogin.addActionListener(e -> handleLogin(loginButtonListener));

        panel.add(labelLogin);
        panel.add(textFieldLogin);
        panel.add(labelPassword);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for spacing
        panel.add(btnLogin);

        getContentPane().add(BorderLayout.CENTER, panel);
        //setVisible(true);
    }

    

    private void handleLogin(ActionListener loginButtonListener) {
        // Notify the controller about the login button click
        loginButtonListener.actionPerformed(null);
    }

    public String getLogin() {
        return textFieldLogin.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

   public void display ()
   {
	   this.setVisible(true);
   }
}
