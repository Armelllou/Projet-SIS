/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.interfaces;

import main.java.bd.ConnexionBD;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Manon
 */
public class ConsulterDPIPHetIDE extends javax.swing.JPanel {
    BarreDuHaut bdh;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;


    /**
     * Creates new form ConsulterDPI
     */
    public ConsulterDPIPHetIDE() {
        initComponents();
    }

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return jTextField1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/logo.png"))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Rechercher un patient par nom ou par IPP :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/loupe.png"))); // NOI18N

        jTable1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "IPP", "Nom de Naissance", "Nom Usuel", "Prénom"
                }
        ));

        /**Code qui retourne dans une JTable la liste des patients de la main.java.bd
         */
        Statement stmt;
        String Sql45;
        ResultSet rs;
        Object[] InfoAllPatient = new Object[4];
        String title[] = {"NomDeNaissance", "NomUsuel", "Prénom", "IPP"};
        DefaultTableModel templatesTableModel = new DefaultTableModel();
        templatesTableModel.setColumnIdentifiers(title);

        try {

            //System.out.println("AAA"+ bdh.getService().getText());
            Sql45 = "SELECT DISTINCT * FROM patient NATURAL JOIN localisations JOIN ide ON localisations.ServiceResponsable=ide.Service OR localisations.ServiceGeographique=ide.Service ";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps = conn.getConnexion().prepareStatement(Sql45);
            rs = ps.executeQuery(Sql45);

            while (rs.next()) {
                InfoAllPatient[0] = rs.getString("NomDeNaissance");
                InfoAllPatient[1] = rs.getString("NomUsuel");
                InfoAllPatient[2] = rs.getString("Prénom");
                InfoAllPatient[3] = rs.getString("IPP");
                templatesTableModel.addRow(InfoAllPatient);
            }
            this.getjTable1().setModel(templatesTableModel);
            this.getjTable1().setFont(new Font("Calibri", 0, 18));
            System.out.println(this.getjTable1().getModel());

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        /**
         */

        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables


}