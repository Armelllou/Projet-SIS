/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JLabel;

/**
 *
 * @author Manon
 */
public class DPISecretaire extends javax.swing.JPanel {

    

    /**
     * @return the jButton2
     */
    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    /**
     * @return the jButtoninfomed
     */
    

    /**
     * @return the jButtonmodifier
     */
    public javax.swing.JButton getjButtonmodifier() {
        return jButtonmodifier;
    }

    public JLabel getServiceGeo() {
        return ServiceGeo;
    }

    public JLabel getSereviceRespo() {
        return sereviceRespo;
    }

   
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

    public JLabel getChambre() {
        return chambre;
    }

    
   

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
     * @return the jLabeljour
     */
 

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
        return jLabelnumsecu;
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

 

    public void setjLabelipp(JLabel jLabelipp) {
        this.jLabelipp = jLabelipp;
    }

    public void setjLabelnom(JLabel jLabelnom) {
        this.jLabelnom = jLabelnom;
    }

    public void setjLabelprenom(JLabel jLabelprenom) {
        this.jLabelprenom = jLabelprenom;
    }

    public JLabel getjLabelnom1() {
        return jLabelnom1;
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
        jLabelprenom = new javax.swing.JLabel();
        jLabelnom = new javax.swing.JLabel();
        jLabelannée = new javax.swing.JLabel();
        jLabelnumsecu = new javax.swing.JLabel();
        jLabelipp = new javax.swing.JLabel();
        jLabeladresse = new javax.swing.JLabel();
        jLabelemail = new javax.swing.JLabel();
        jLabeltelephone = new javax.swing.JLabel();
        jButtonmodifier = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chambre = new javax.swing.JLabel();
        jLabelchamnre = new javax.swing.JLabel();
        ServiceGeo = new javax.swing.JLabel();
        sereviceRespo = new javax.swing.JLabel();
        jLabelnom1 = new javax.swing.JLabel();
        Sexe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));
        setPreferredSize(new java.awt.Dimension(1700, 760));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/flcheretour-ConvertImage.png"))); // NOI18N

        jLabelprenom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelprenom.setText("Prénom");

        jLabelnom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom.setText("NOM");

        jLabelannée.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelannée.setText("AAAA");

        jLabelnumsecu.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelnumsecu.setText("2971162574323");

        jLabelipp.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelipp.setText("AAMMXXXXX");

        jLabeladresse.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeladresse.setText("4 rue de la liberté");

        jLabelemail.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelemail.setText("nom.prenom@email.com");

        jLabeltelephone.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeltelephone.setText("0675984286");

        jButtonmodifier.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtonmodifier.setText("Modifier le dossier");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel4.setText("Service responsable :");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel5.setText("Service géographique :");

        chambre.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        chambre.setText("Chambre :");

        jLabelchamnre.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelchamnre.setText("XXX");

        ServiceGeo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ServiceGeo.setText("Mort");

        sereviceRespo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sereviceRespo.setText("Anapathologie");

        jLabelnom1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom1.setText("NOM");

        Sexe.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sexe.setText("Sexe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sereviceRespo, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                                            .addComponent(jLabeladresse, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ServiceGeo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelannée, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(252, 252, 252)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelnumsecu, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(chambre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelchamnre))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addComponent(jLabelnom1)
                                        .addGap(224, 224, 224)
                                        .addComponent(jLabelprenom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelipp))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabelnom)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(166, 166, 166)
                                        .addComponent(Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelemail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabeltelephone, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(192, 192, 192)))
                        .addGap(213, 213, 213)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonmodifier)
                .addGap(678, 678, 678))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelnom)
                            .addComponent(jLabelprenom)
                            .addComponent(jLabelnom1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabelipp)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelannée)
                    .addComponent(jLabelnumsecu))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabeladresse)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chambre)
                                    .addComponent(jLabelchamnre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(sereviceRespo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(ServiceGeo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                                .addComponent(jButtonmodifier)
                                .addGap(132, 132, 132))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelemail)
                        .addGap(18, 18, 18)
                        .addComponent(jLabeltelephone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ServiceGeo;
    private javax.swing.JLabel Sexe;
    private javax.swing.JLabel chambre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonmodifier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabeladresse;
    private javax.swing.JLabel jLabelannée;
    private javax.swing.JLabel jLabelchamnre;
    private javax.swing.JLabel jLabelemail;
    private javax.swing.JLabel jLabelipp;
    private javax.swing.JLabel jLabelnom;
    private javax.swing.JLabel jLabelnom1;
    private javax.swing.JLabel jLabelnumsecu;
    private javax.swing.JLabel jLabelprenom;
    private javax.swing.JLabel jLabeltelephone;
    private javax.swing.JLabel sereviceRespo;
    // End of variables declaration//GEN-END:variables
}
