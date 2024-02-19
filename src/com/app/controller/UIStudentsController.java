package com.app.controller;

import com.app.entity.Etudiant;
import com.app.interfaces.FormulaireStudentsUI;
import com.app.interfaces.UIStudents;
import com.app.client.RestClient2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class UIStudentsController {

    private UIStudents uiStudents;
    private RestClient2 restClient2;
    private FormulaireStudentsUI formUI;

    public UIStudentsController(UIStudents uiStudents) {
        this.uiStudents = uiStudents;
        this.restClient2 = new RestClient2();

        initialize();
        updateTableData();
    }

    private void initialize() {
        // Add action listeners to UI components
        uiStudents.addEditButtonActionListener(new EditButtonListener());
        uiStudents.addDeleteButtonActionListener(new DeleteButtonListener());
        uiStudents.addCreateButtonActionListener(new CreateButtonListener());
        updateTableData();
    }

    public void showFormulaire(Etudiant etudiant) {
        // Create and display the form
        formUI = new FormulaireStudentsUI();
        formUI.addValiderButtonActionListener(new ValiderButtonListener());
        formUI.setStudent(etudiant);
        formUI.display();
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected student and display the form for editing
            Etudiant selectedStudent = uiStudents.getSelectedStudent();
            showFormulaire(selectedStudent);
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected student and delete it, then update the table
            Etudiant selectedStudent = uiStudents.getSelectedStudent();
            if (selectedStudent != null) {
                if (restClient2.deleteStudent(selectedStudent.getId())) {
                    updateTableData();
                } else {
                    showError("Erreur de suppression");
                }
            } else {
                showError("Aucun étudiant sélectionné.");
            }
        }
    }

    private class CreateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the form for creating a new student
            showFormulaire(new Etudiant());
        }
    }

    private class ValiderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validate and save the form data
            Etudiant student = formUI.getStudent();
            if (student.getId() == 0) {
                restClient2.addStudent(student);
                formUI.undisplayed();
                updateTableData();
            } else {
                restClient2.updateStudent(student);
                formUI.undisplayed();
                updateTableData();
            }
        }
    }

    private void updateTableData() {
        // Retrieve the list of students from the API and update the table
        List<Etudiant> students = restClient2.getAllStudents();
        uiStudents.setStudents(students);
    }

    private void showError(String message) {
        // Display an error message
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void start() {
        this.uiStudents.setVisible(true);
    }
}
