/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bd.ConnexionBD;
import bd.MethodeBD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Manon
 */
public class ListePersonnel extends javax.swing.JPanel {

    /**
     * @return the jTable3
     */
    public javax.swing.JTable getjTable3() {
        return TableIDE;
    }

    public JTable getTableIDE() {
        return TableIDE;
    }

    public JTable getTableMT() {
        return TableMT;
    }

    public JTable getTablePH() {
        return TablePH;
    }



    /**
     * @return the jButton3
     */
    public javax.swing.JButton getjButton3() {
        return AjouterPersonnel;
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
        return TableMT;
    }

    /**
     * Creates new form InfosMedicales
     */
    public ListePersonnel() {
        initComponents();
     
        this.getjTable3().setFont(new Font("Calibri", 0, 18));
        this.getjTable3().setModel(new MethodeBD().listeIDE());
         this.getTablePH().setFont(new Font("Calibri", 0, 18));
        this.getTablePH().setModel(new MethodeBD().listePH());
         this.getTableMT().setFont(new Font("Calibri", 0, 18));
        this.getTableMT().setModel(new MethodeBD().listeMT());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMT = new javax.swing.JTable();
        AjouterPersonnel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableIDE = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePH = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BarreDeRecherchePersonnelMT = new javax.swing.JTextField();
        BarreDeRecherchePH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BarreDeRechercheIDE = new javax.swing.JTextField();
        BoutonIDE = new javax.swing.JButton();
        BouttonMT = new javax.swing.JButton();
        BoutonRecherchePH = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        TableMT.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        TableMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nom", "Prénom"
            }
        ));
        jScrollPane1.setViewportView(TableMT);

        AjouterPersonnel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        AjouterPersonnel.setText("Ajouter un personnel");

        TableIDE.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        TableIDE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom ", "Prénom ", "Service"
            }
        ));
        jScrollPane3.setViewportView(TableIDE);

        TablePH.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        TablePH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom ", "Prénom ", "Service"
            }
        ));
        jScrollPane4.setViewportView(TablePH);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Liste des Personnels Médico-techniques");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setText("Liste de IDE");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setText("Liste des Praticiens hospitaliers");

        BarreDeRecherchePersonnelMT.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BarreDeRecherchePersonnelMT.setText("Chercher Personnel MT  ...");
        BarreDeRecherchePersonnelMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarreDeRecherchePersonnelMTActionPerformed(evt);
            }
        });

        BarreDeRecherchePH.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BarreDeRecherchePH.setText("Chercher PH  ...");
        BarreDeRecherchePH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarreDeRecherchePHActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setText("Liste du personnel de l'hopital Princeton Placeboro :");

        BarreDeRechercheIDE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BarreDeRechercheIDE.setText("Chercher IDE  ...");
        BarreDeRechercheIDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarreDeRechercheIDEActionPerformed(evt);
            }
        });

        BoutonIDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/loupe.png"))); // NOI18N

        BouttonMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/loupe.png"))); // NOI18N

        BoutonRecherchePH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/loupe.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AjouterPersonnel)
                        .addGap(427, 427, 427)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BarreDeRecherchePH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BoutonRecherchePH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addComponent(BarreDeRechercheIDE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BoutonIDE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(243, 243, 243))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BarreDeRecherchePersonnelMT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BouttonMT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(330, 330, 330)
                .addComponent(jLabel2)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(391, 391, 391))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BarreDeRecherchePH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonRecherchePH)
                            .addComponent(BouttonMT)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BarreDeRecherchePersonnelMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BarreDeRechercheIDE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BoutonIDE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(AjouterPersonnel)
                        .addGap(0, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BarreDeRecherchePersonnelMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarreDeRecherchePersonnelMTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarreDeRecherchePersonnelMTActionPerformed

    private void BarreDeRecherchePHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarreDeRecherchePHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarreDeRecherchePHActionPerformed

    private void BarreDeRechercheIDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarreDeRechercheIDEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarreDeRechercheIDEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterPersonnel;
    private javax.swing.JTextField BarreDeRechercheIDE;
    private javax.swing.JTextField BarreDeRecherchePH;
    private javax.swing.JTextField BarreDeRecherchePersonnelMT;
    private javax.swing.JButton BoutonIDE;
    private javax.swing.JButton BoutonRecherchePH;
    private javax.swing.JButton BouttonMT;
    private javax.swing.JTable TableIDE;
    private javax.swing.JTable TableMT;
    private javax.swing.JTable TablePH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables




}