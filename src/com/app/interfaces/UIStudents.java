package com.app.interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.app.entity.Etudiant;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

public class UIStudents extends JFrame {

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private JButton editButton;
    private JButton deleteButton;
    private JButton createButton;

    public UIStudents() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        // Create NorthPanel for the "Create" button
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createButton = new JButton("Creer");
        northPanel.add(createButton);

        add(northPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "Prenom", "Nom", "Moyenne"}, 0);
        studentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);

       tableScrollPane.setPreferredSize(new Dimension(600, 300));

        add(tableScrollPane, BorderLayout.CENTER);

        JPanel SouthPanel = new JPanel(new GridLayout(3, 2));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        editButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        SouthPanel.add(buttonPanel);

        add(SouthPanel, BorderLayout.SOUTH);

        pack();  // Adjust the frame size based on its contents
        setLocationRelativeTo(null);  // Center the frame on the screen
    }

    public void setStudents(List<Etudiant> students) {
        tableModel.setRowCount(0);
        for (Etudiant student : students) {
            Object[] rowData = {student.getId(), student.getNom(), student.getPrenom(), student.getMoyenne()};
            tableModel.addRow(rowData);
        }
    }

    public int getSelectedRowIndex() {
        return studentTable.getSelectedRow();
    }

    public int getSelectedStudentId() {
        int selectedRowIndex = studentTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            return (int) studentTable.getValueAt(selectedRowIndex, 0);
        }
        return -1;
    }

    public void addEditButtonActionListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addDeleteButtonActionListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addCreateButtonActionListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public Etudiant getSelectedStudent() {
        int selectedRow = studentTable.getSelectedRow();

        if (selectedRow != -1) {
            int id = (int) studentTable.getValueAt(selectedRow, 0);
            String nom = (String) studentTable.getValueAt(selectedRow, 1);
            String prenom = (String) studentTable.getValueAt(selectedRow, 2);
            double moyenne = (double) studentTable.getValueAt(selectedRow, 3);

            return new Etudiant(id, nom, prenom, moyenne);
        }

        return null;  // Return null if no row is selected.
    }

    public static void main(String[] args) {
        // Create an instance of the UIStudentsFrame
        UIStudents frame = new UIStudents();
        frame.setVisible(true);
    }
}
