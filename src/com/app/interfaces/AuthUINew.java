package com.app.interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.app.controller.AuthController;
import com.javaws.services.WSAuthentification;


public class AuthUINew extends javax.swing.JFrame {
	
	 private WSAuthentification wsAuthentification = new WSAuthentification();

  
    public AuthUINew() {
        initComponents();
        this.authController = authController;
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }});
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUTHENTIFICATION");
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

       // jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rahemet\\Documents\\NetBeansProjects\\LoginAndSignUp\\src\\Icon\\logo.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Students Management App");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        RightLayout.setHorizontalGroup(
        	RightLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(RightLayout.createSequentialGroup()
        			.addGap(145)
        			.addComponent(jLabel5)
        			.addContainerGap(255, Short.MAX_VALUE))
        		.addGroup(RightLayout.createSequentialGroup()
        			.addContainerGap(24, Short.MAX_VALUE)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        RightLayout.setVerticalGroup(
        	RightLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(RightLayout.createSequentialGroup()
        			.addGap(136)
        			.addComponent(jLabel5)
        			.addGap(35)
        			.addComponent(jLabel6)
        			.addContainerGap(298, Short.MAX_VALUE))
        );
        Right.setLayout(RightLayout);

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("AUTHENTIFICATION");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        LeftLayout.setHorizontalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel2)
        				.addComponent(jTextField1)
        				.addComponent(jLabel3)
        				.addComponent(jPasswordField1, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(20, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, LeftLayout.createSequentialGroup()
        			.addContainerGap(86, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(72))
        );
        LeftLayout.setVerticalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGap(48)
        			.addComponent(jLabel1)
        			.addGap(43)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel3)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(139, Short.MAX_VALUE))
        );
        Left.setLayout(LeftLayout);

        jPanel1.add(Left);
        Left.setBounds(400, 0, 505, 500);
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
            
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private AuthController authController;
    
    
    
    private void loginUser() {
        String login = getLogin();
        String password = getPassword();

        if (wsAuthentification.validate(login, password)) {
            
            showMessage("Login successful");
           
            dispose();
          
             new UIStudents().setVisible(true);
        } else {
            // Login échoué
            showMessage("Login failed. Invalid credentials.");
        }
    }

    public String getLogin() {
        return jTextField1.getText();
    }

    public String getPassword() {
        return new String(jPasswordField1.getPassword());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    
    public void display() {
        this.setVisible(true);
    }

    public void setAuthController(AuthController authController) {
        this.authController = authController;
    }

}
