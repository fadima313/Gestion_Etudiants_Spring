package com.app.utils;

import java.util.Optional;

import javax.swing.JOptionPane;


public class DialogUtils {

    private DialogUtils() {
        // Constructeur privé pour empêcher l'instanciation de la classe utilitaire.
    }

    public static void showMessage(String message) {
        showMessage(message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWarning(String message) {
        showMessage(message, "Avertissement", JOptionPane.WARNING_MESSAGE);
    }

    public static void showError(String message) {
        showMessage(message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean showConfirmation(String message) {
        return showConfirmation(message, "Confirmation");
    }

    public static boolean showConfirmation(String message, String title) {
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    public static String showInput(String message) {
        return showInput(message, "Saisie");
    }

    public static String showInput(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    private static void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
    public static boolean showConfirmationDialog(String title, String message) {
        int result = JOptionPane.showConfirmDialog(
                null,               // Parent component, null for default
                message,            // Message to display
                title,              // Dialog title
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si l'utilisateur clique sur OK, retourne true, sinon retourne false
        return result == JOptionPane.OK_OPTION;
    }

    // Ajoutez d'autres méthodes utilitaires au besoin.
}