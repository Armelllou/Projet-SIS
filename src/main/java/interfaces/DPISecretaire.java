/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Manon
 */
public class DPISecretaire extends javax.swing.JPanel {

    public JButton getjButtonmodifier() {
        return jButtonmodifier;
    }

    /**
     * @return the dateentree
     */
    public javax.swing.JLabel getDateentree() {
        return dateentree;
    }

    /**
     * @param dateentree the dateentree to set
     */
    public void setDateentree(javax.swing.JLabel dateentree) {
        this.dateentree = dateentree;
    }

    /**
     * @return the datesortie
     */
    public javax.swing.JLabel getDatesortie() {
        return datesortie;
    }

    /**
     * @param datesortie the datesortie to set
     */
    public void setDatesortie(javax.swing.JLabel datesortie) {
        this.datesortie = datesortie;
    }

    /**
     * @return the etat
     */
    public javax.swing.JLabel getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(javax.swing.JLabel etat) {
        this.etat = etat;
    }

    /**
     * @return the typeDeSejour
     */
    public javax.swing.JLabel getTypeDeSejour() {
        return typeDeSejour;
    }

    /**


    /**
     * @return the jButton1
     */
    
    /**
     * @return the jButton2
     */
    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

  

    /**
     * @return the jButtonmodifier
     */
    

    /**
     * @return the jComboBox1
  
    /**
     * @return the jLabeladresse
     */
    public javax.swing.JLabel getjLabeladresse() {
        return jLabeladresse;
    }

    /**
     * @return the jLabelannée
     */
    public javax.swing.JLabel getjLabelannée() {
        return jLabelannée;
    }

    /**
     * @return the jLabelchamnre
     */
    public javax.swing.JLabel getjLabelchamnre() {
        return jLabelchamnre;
    }

    /**
     * @return the jLabelcodepostal
     */
   
    /**
     * @return the jLabelemail
     */
    public javax.swing.JLabel getjLabelemail() {
        return jLabelemail;
    }

    /**
     * @return the jLabelipp
     */
    public javax.swing.JLabel getjLabelipp() {
        return jLabelipp;
    }

    /**
     * @return the jLabelnom
     */
    public javax.swing.JLabel getjLabelnom() {
        return jLabelnom;
    }

    /**
     * @return the jLabelnumsecu
     */
    public javax.swing.JLabel getjLabelnumsecu() {
        return jLabelnumsecu1;
    }

    /**
     * @return the jLabelprenom
     */
    public javax.swing.JLabel getjLabelprenom() {
        return jLabelprenom;
    }

    /**
     * @return the jLabeltelephone
     */
    public javax.swing.JLabel getjLabeltelephone() {
        return jLabeltelephone;
    }

  
   

    public JLabel getjLabelnom1() {
        return jLabelnom1;
    }

    public JLabel getServiceGeo() {
        return ServiceGeo;
    }

    public JLabel getServiceRespo() {
        return ServiceRespo;
    }

    public JLabel getSexe() {
        return Sexe;
    }
    
    
    

    /**
     * Creates new form DPI
     */
    public DPISecretaire() {
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelannée = new javax.swing.JLabel();
        Sexe = new javax.swing.JLabel();
        jLabeladresse = new javax.swing.JLabel();
        jLabelemail = new javax.swing.JLabel();
        jLabeltelephone = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelchamnre = new javax.swing.JLabel();
        ServiceRespo = new javax.swing.JLabel();
        ServiceGeo = new javax.swing.JLabel();
        jLabelnumsecu1 = new javax.swing.JLabel();
        typeDeSejour = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etat = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateentree = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        datesortie = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelnom = new javax.swing.JLabel();
        jLabelnom1 = new javax.swing.JLabel();
        jLabelprenom = new javax.swing.JLabel();
        jLabelipp = new javax.swing.JLabel();
        jButtonmodifier = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));
        setPreferredSize(new java.awt.Dimension(1700, 760));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/flcheretour-ConvertImage.png"))); // NOI18N

        jLabelannée.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelannée.setText("AAAA");

        Sexe.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        Sexe.setText("Sexe");

        jLabeladresse.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeladresse.setText("4 rue de la liberté");

        jLabelemail.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelemail.setText("nom.prenom@email.com");

        jLabeltelephone.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeltelephone.setText("0675984286");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel4.setText("Service responsable :");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel5.setText("Service géographique :");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel6.setText("Chambre :");

        jLabelchamnre.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelchamnre.setText("XXX");

        ServiceRespo.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ServiceRespo.setText("4 rue de la liberté");

        ServiceGeo.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ServiceGeo.setText("4 rue de la liberté");

        jLabelnumsecu1.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelnumsecu1.setText("2971162574323");

        typeDeSejour.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        typeDeSejour.setText("Type de séjour");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        jLabel2.setText("Etat :");

        etat.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        etat.setText("état");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        jLabel7.setText("Date d'entrée :");

        dateentree.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        dateentree.setText("Date d'entrée");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        jLabel8.setText("Date de sortie :");

        datesortie.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        datesortie.setText("Date de sortie");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelnom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom.setText("NOM");

        jLabelnom1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom1.setText("NOM");

        jLabelprenom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelprenom.setText("Prénom");

        jLabelipp.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelipp.setText("AAMMXXXXX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelnom)
                .addGap(126, 126, 126)
                .addComponent(jLabelnom1)
                .addGap(119, 119, 119)
                .addComponent(jLabelprenom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jLabelipp)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnom)
                    .addComponent(jLabelnom1)
                    .addComponent(jLabelprenom)
                    .addComponent(jLabelipp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonmodifier.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtonmodifier.setText("Modifier le dossier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeladresse)
                            .addComponent(jLabelannée, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelnumsecu1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Sexe, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelemail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(typeDeSejour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabeltelephone))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(369, 369, 369))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateentree, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datesortie, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ServiceGeo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ServiceRespo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelchamnre))
                        .addGap(283, 283, 283))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonmodifier)
                .addGap(533, 533, 533)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelannée)
                    .addComponent(Sexe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeladresse)
                    .addComponent(jLabelnumsecu1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltelephone)
                    .addComponent(typeDeSejour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etat))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ServiceGeo)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ServiceRespo)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabelchamnre))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 122, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonmodifier)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dateentree))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(datesortie))
                        .addGap(227, 227, 227))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ServiceGeo;
    private javax.swing.JLabel ServiceRespo;
    private javax.swing.JLabel Sexe;
    private javax.swing.JLabel dateentree;
    private javax.swing.JLabel datesortie;
    private javax.swing.JLabel etat;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonmodifier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabeladresse;
    private javax.swing.JLabel jLabelannée;
    private javax.swing.JLabel jLabelchamnre;
    private javax.swing.JLabel jLabelemail;
    private javax.swing.JLabel jLabelipp;
    private javax.swing.JLabel jLabelnom;
    private javax.swing.JLabel jLabelnom1;
    private javax.swing.JLabel jLabelnumsecu1;
    private javax.swing.JLabel jLabelprenom;
    private javax.swing.JLabel jLabeltelephone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel typeDeSejour;
    // End of variables declaration//GEN-END:variables
}
