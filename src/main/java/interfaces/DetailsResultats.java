/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Manon
 */
public class DetailsResultats extends javax.swing.JPanel {

    public JLabel getType() {
        return type;
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

    public JEditorPane getResultats() {
        return Resultats;
    }


   
    /**
     * Creates new form PrestationFaite
     */
    public DetailsResultats() {
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
        Resultats = new javax.swing.JEditorPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));

        nomPatient.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        nomPatient.setText("NOM");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        boutonAnnuler.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        boutonAnnuler.setText("Annuler");

        boutonValider.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        boutonValider.setText("Valider");

        prenomPatient.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        prenomPatient.setText("Prénom");

        ipp.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        ipp.setText("AAMMXXXXX");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setText("Résultats :");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setText("Patient :");

        nomMedecin.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        nomMedecin.setText("Nom Prenom");

        type.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        type.setText("Médecin :");

        Resultats.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jScrollPane2.setViewportView(Resultats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(756, 756, 756)
                        .addComponent(boutonAnnuler)
                        .addGap(44, 44, 44)
                        .addComponent(boutonValider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                        .addGap(0, 563, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(nomMedecin)
                .addContainerGap(556, Short.MAX_VALUE))
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
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boutonValider)
                            .addComponent(boutonAnnuler))
                        .addGap(59, 59, 59))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Resultats;
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
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
