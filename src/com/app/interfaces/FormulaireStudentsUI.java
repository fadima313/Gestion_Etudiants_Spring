package com.app.interfaces;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.app.entity.Etudiant;

import java.awt.*;
import java.awt.event.ActionListener;

public class FormulaireStudentsUI extends JFrame {

    private JTextField nomField;
    private JTextField prenomField;
    private JTextField moyenneField;

    private JButton saveButton;
    private JButton cleanButton;

    private Etudiant selectedStudent;

    public FormulaireStudentsUI() {
        initialize();
      
       
    }

    public void display() {
    	this.setVisible(true);
    }
    
    public void undisplayed() {
    	this.setVisible(false);
    }
    
    private void initialize() {
        setTitle("Formulaire d'ajout d'un étudiant");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        nomField = new JTextField(32);
        prenomField = new JTextField(32);
        moyenneField = new JTextField(32);

        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Prénom:"));
        formPanel.add(prenomField);
        formPanel.add(new JLabel("Moyenne:"));
        formPanel.add(moyenneField);

        saveButton = new JButton("Enregistrer");
        cleanButton = new JButton("Effacer");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(cleanButton);

        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void addValiderButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addClearButtonActionListener(ActionListener listener) {
        cleanButton.addActionListener(listener);
    }

    public void cleanFields() {
        nomField.setText("");
        prenomField.setText("");
        moyenneField.setText("");
        this.selectedStudent = null;
    }

    public void setStudent(Etudiant selectedStudent) {
        this.selectedStudent = selectedStudent;
        nomField.setText(selectedStudent.getNom());
        prenomField.setText(selectedStudent.getPrenom());
        moyenneField.setText(String.valueOf(selectedStudent.getMoyenne()));
    }

    public Etudiant getStudent() {
        if (this.selectedStudent == null) {
            this.selectedStudent = new Etudiant();
        }
        this.selectedStudent.setNom(nomField.getText());
        this.selectedStudent.setPrenom(prenomField.getText());
        this.selectedStudent.setMoyenne(Double.parseDouble(moyenneField.getText()));
        return this.selectedStudent;
    }

	
}
