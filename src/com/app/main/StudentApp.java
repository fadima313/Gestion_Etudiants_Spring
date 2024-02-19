package com.app.main;

import javax.swing.SwingUtilities;

import com.app.controller.AuthController;
import com.app.interfaces.AuthUINew;

public class StudentApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AuthUINew authUI = new AuthUINew();
                AuthController authController = new AuthController(authUI, null); 
                authUI.setAuthController(authController);
                authUI.display();
            }
        });
    }
}
