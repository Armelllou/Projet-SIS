/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JTextArea;


/**
 *
 * @author Manon
 */
public class PrestationFaite extends javax.swing.JPanel {

    public JLabel getType() {
        return type;
    }

    public JTextArea getResultats() {
        return resultats;
    }

  

    public JButton getBoutonAnnuler() {
        return boutonAnnuler;
    }

    public JButton getBoutonValider() {
        return boutonValider;
    }

    public JLabel getIpp() {
        return ipp;
    }

    public JLabel getNomMedecin() {
        return nomMedecin;
    }

    public JLabel getNomPatient() {
        return nomPatient;
    }

    public JLabel getPrenomPatient() {
        return prenomPatient;
    }

 

   
    /**
     * Creates new form PrestationFaite
     */
    public PrestationFaite() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomPatient = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        boutonAnnuler = new javax.swing.JButton();
        boutonValider = new javax.swing.JButton();
        prenomPatient = new javax.swing.JLabel();
        ipp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomMedecin = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultats = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));

        nomPatient.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        nomPatient.setText("NOM");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        boutonAnnuler.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        boutonAnnuler.setText("Annuler");

        boutonValider.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        boutonValider.setText("Valider");

        prenomPatient.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        prenomPatient.setText("Prénom");

        ipp.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        ipp.setText("AAMMXXXXX");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setText("Résultats :");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setText("Patient:");

        nomMedecin.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        nomMedecin.setText("Nom Prenom");

        type.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        type.setText("Médecin :");

        resultats.setColumns(20);
        resultats.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        resultats.setRows(5);
        jScrollPane2.setViewportView(resultats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel4)
                                .addGap(89, 89, 89)
                                .addComponent(nomPatient)
                                .addGap(70, 70, 70)
                                .addComponent(prenomPatient)
                                .addGap(85, 85, 85)
                                .addComponent(ipp)
                                .addGap(136, 136, 136)
                                .addComponent(type)
                                .addGap(27, 27, 27)
                                .addComponent(nomMedecin))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(653, 653, 653)
                .addComponent(boutonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(boutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomPatient)
                    .addComponent(prenomPatient)
                    .addComponent(ipp)
                    .addComponent(jLabel4)
                    .addComponent(type)
                    .addComponent(nomMedecin))
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonAnnuler)
                    .addComponent(boutonValider))
                .addGap(21, 21, 21)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonAnnuler;
    private javax.swing.JButton boutonValider;
    private javax.swing.JLabel ipp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nomMedecin;
    private javax.swing.JLabel nomPatient;
    private javax.swing.JLabel prenomPatient;
    private javax.swing.JTextArea resultats;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
