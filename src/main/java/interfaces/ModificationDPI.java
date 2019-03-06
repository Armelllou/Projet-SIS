/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Manon
 */
public class ModificationDPI extends javax.swing.JPanel {

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

    /**
     * @return the jComboBox1
     */
    public javax.swing.JComboBox<String> getjComboBox1() {
        return servicerespo;
    }

    /**
     * @return the jComboBox2
     */
    public javax.swing.JComboBox<String> getjComboBox2() {
        return servicegeo;
    }

    /**
     * @return the jRadioButton1
     */
    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return tel;
    }

    /**
     * @return the jTextField10
     */
    public javax.swing.JTextField getjTextField10() {
        return email;
    }

    /**
     * @return the jTextField11
     */
    /**
     * @return the jTextField12
     */
    public javax.swing.JTextField getjTextField12() {
        return chambre;
    }

    /**
     * @return the jTextField2
     */
    public javax.swing.JTextField getjTextField2() {
        return Adresse;
    }

    /**
     * @return the jTextField3
     */
    public javax.swing.JTextField getjTextField3() {
        return prenom;
    }

    /**
     * @return the jTextField4
     */
    /**
     * @return the jTextField6
     */
    public javax.swing.JTextField getjTextField6() {
        return numSS;
    }

    /**
     * @return the jTextField7
     */
    public javax.swing.JTextField getjTextField7() {
        return NomUsuel;
    }

    /**
     * @return the jTextField8
     */
    public javax.swing.JTextField getjTextField8() {
        return DateDeNaissance;
    }

    public JTextField getAdresse() {
        return Adresse;
    }

    public JTextField getDateDeNaissance() {
        return DateDeNaissance;
    }

    public JTextField getNomUsuel() {
        return NomUsuel;
    }

    public JTextField getChambre() {
        return chambre;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getNomDenaissance() {
        return nomDenaissance;
    }

    public JTextField getNumSS() {
        return numSS;
    }

    public JTextField getPrenom() {
        return prenom;
    }

    public JComboBox<String> getServicegeo() {
        return servicegeo;
    }

    public JComboBox<String> getServicerespo() {
        return servicerespo;
    }

    public JTextField getTel() {
        return tel;
    }

    public JComboBox<String> getSexe() {
        return Sexe;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * Creates new form CréationDPI
     */
    public ModificationDPI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        Adresse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numSS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        NomUsuel = new javax.swing.JTextField();
        DateDeNaissance = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        servicerespo = new javax.swing.JComboBox<>();
        servicegeo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        chambre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nomDenaissance = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Sexe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        typesejour = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Numéro de sécurité sociale :");

        tel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telActionPerformed(evt);
            }
        });

        Adresse.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdresseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setText("Prénom :");

        prenom.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setText("Nom de naissance :");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setText("Date de naissance :");

        numSS.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        numSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSSActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setText("Adresse :");

        NomUsuel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        NomUsuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomUsuelActionPerformed(evt);
            }
        });

        DateDeNaissance.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        DateDeNaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateDeNaissanceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setText("Email :");

        email.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setText("Téléphone :");

        jButton1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton1.setText("Valider");

        jButton2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton2.setText("Annuler");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel13.setText("Service géographique :");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel14.setText("Service responsable :");

        servicerespo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        servicerespo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anapathologie", "Anesthesie", "Cardiologie", "Chirurgie", "Dermatologie", "Gynecologie", "Hematologie", "Laboratoire", "Médecine", "Obstetrique", "Psychiatrie", "Radiologie", "Urologie" }));

        servicegeo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        servicegeo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anapathologie", "Anesthesie", "Cardiologie", "Chirurgie", "Dermatologie", "Gynecologie", "Hematologie", "Laboratoire", "Medecine", "Obstetrique", "Psychiatrie", "Radiologie", "Urologie" }));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel15.setText("Chambre :");

        chambre.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        chambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chambreActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel16.setText("Nom usuel :");

        nomDenaissance.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        nomDenaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomDenaissanceActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel17.setText("Genre :");

        Sexe.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Féminin", "Masculin", "Autre" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("IPP");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setText("IPP :");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel18.setText("Type de séjour :");

        typesejour.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        typesejour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultation externe", "Hospitalisation" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomDenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NomUsuel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DateDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numSS, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(51, 51, 51))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(typesejour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1)
                            .addComponent(servicegeo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicerespo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(394, 394, 394)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nomDenaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomUsuel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel2)
                    .addComponent(numSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(DateDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(chambre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel18)
                                .addComponent(typesejour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(servicerespo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(servicegeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(57, 57, 57))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void AdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdresseActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void numSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numSSActionPerformed

    private void NomUsuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomUsuelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomUsuelActionPerformed

    private void DateDeNaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateDeNaissanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateDeNaissanceActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void chambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chambreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chambreActionPerformed

    private void nomDenaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomDenaissanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomDenaissanceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adresse;
    private javax.swing.JTextField DateDeNaissance;
    private javax.swing.JTextField NomUsuel;
    private javax.swing.JComboBox<String> Sexe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField chambre;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nomDenaissance;
    private javax.swing.JTextField numSS;
    private javax.swing.JTextField prenom;
    private javax.swing.JComboBox<String> servicegeo;
    private javax.swing.JComboBox<String> servicerespo;
    private javax.swing.JTextField tel;
    private javax.swing.JComboBox<String> typesejour;
    // End of variables declaration//GEN-END:variables
}
