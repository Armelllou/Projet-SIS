/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.interfaces;

import javax.swing.*;

/**
 * @author Manon
 */
public class BarreDuHaut extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nom;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel mdp;
    private javax.swing.JLabel prenom;
    private javax.swing.JLabel service;


    /**
     * Creates new form BarreDuHaut2
     */
    public BarreDuHaut() {
        initComponents();
    }

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    /**
     * @return the jButton2
     */
    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    public JLabel getNom() {
        return Nom;
    }

    public JLabel getPrenom() {
        return prenom;
    }

    public JLabel getService() {
        return service;
    }

    public JLabel getId() {
        return id;
    }

    public JLabel getMdp() {
        return mdp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        service = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Nom = new javax.swing.JLabel();
        prenom = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        mdp = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identifiant");

        setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/compte-ConvertImage.png"))); // NOI18N

        service.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        service.setForeground(new java.awt.Color(255, 255, 255));
        service.setText("Service");

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/icone-deconnexion-png-9-ConvertImage (6).png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/18116-ConvertImage.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("CHU Princeton Plainsboro");

        Nom.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Nom.setForeground(new java.awt.Color(255, 255, 255));
        Nom.setText("Nom");

        prenom.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        prenom.setForeground(new java.awt.Color(255, 255, 255));
        prenom.setText("Prénom");

        id.setText("id");

        mdp.setText("mdp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23)
                                .addComponent(Nom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prenom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(service)
                                .addGap(69, 69, 69)
                                .addComponent(id)
                                .addGap(18, 18, 18)
                                .addComponent(mdp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1150, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(658, 658, 658)
                                        .addComponent(jLabel4)
                                        .addContainerGap(659, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(id)
                                                .addComponent(mdp)))
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4)
                                        .addContainerGap(14, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    // End of variables declaration//GEN-END:variables
}