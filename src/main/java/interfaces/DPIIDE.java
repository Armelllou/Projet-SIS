/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Manon
 */
public class DPIIDE extends javax.swing.JPanel {

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
     * @return the jButtoninfomed
     */
    public javax.swing.JButton getjButtoninfomed() {
        return jButtoninfomed;
    }

    /**
     * @return the jButtonmodifier
     */
    

    /**
     * @return the jComboBox1
     */
  

    /**
     * @return the jLabeladresse
     */
    public javax.swing.JLabel getjLabeladresse() {
        return ServiceRespo;
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
    public JLabel getjLabelipp() { 
        return jLabelipp;
    }

    /**
     * @return the jLabeljour
     */
    public javax.swing.JLabel getjLabeljour() {
        return jLabeljour;
    }

    /**
     * @return the jLabelmois
     */
    public javax.swing.JLabel getjLabelmois() {
        return jLabelmois;
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


   

    public JLabel getjLabelnom1() {
        return jLabelnom1;
    }

    public JLabel getSexe() {
        return Sexe;
    }

    public JLabel getServiceGeo() {
        return ServiceGeo;
    }

    public JLabel getServiceRespo() {
        return ServiceRespo;
    }

    
    
    

    /**
     * Creates new form DPI
     */
    public DPIIDE() {
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
        jLabeljour = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelannée = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelmois = new javax.swing.JLabel();
        jLabelnumsecu = new javax.swing.JLabel();
        jLabelipp = new javax.swing.JLabel();
        ServiceRespo = new javax.swing.JLabel();
        jLabelemail = new javax.swing.JLabel();
        jLabeltelephone = new javax.swing.JLabel();
        jButtoninfomed = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelchamnre = new javax.swing.JLabel();
        jLabelnom1 = new javax.swing.JLabel();
        Sexe = new javax.swing.JLabel();
        ServiceGeo = new javax.swing.JLabel();
        jLabeladresse2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 10, true));
        setPreferredSize(new java.awt.Dimension(1700, 760));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/logo.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/flcheretour-ConvertImage.png"))); // NOI18N

        jLabelprenom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelprenom.setText("Prénom");

        jLabelnom.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom.setText("NOM");

        jLabeljour.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeljour.setText("JJ");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel2.setText("/");

        jLabelannée.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelannée.setText("AAAA");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel3.setText("/");

        jLabelmois.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelmois.setText("MM");

        jLabelnumsecu.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelnumsecu.setText("2971162574323");

        jLabelipp.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelipp.setText("AAMMXXXXX");

        ServiceRespo.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ServiceRespo.setText("Anpathologie");

        jLabelemail.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelemail.setText("nom.prenom@email.com");

        jLabeltelephone.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeltelephone.setText("0675984286");

        jButtoninfomed.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtoninfomed.setText("Accéder aux informations médicales");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel4.setText("Service responsable :");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel5.setText("Service géographique :");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel6.setText("Chambre :");

        jLabelchamnre.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabelchamnre.setText("XXX");

        jLabelnom1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabelnom1.setText("NOM");

        Sexe.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        Sexe.setText("Sexe");

        ServiceGeo.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ServiceGeo.setText("Anapathologie");

        jLabeladresse2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabeladresse2.setText("4 rue de la liberté");

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
                        .addGap(339, 339, 339)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelnom)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabelnom1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                        .addComponent(jLabelprenom)
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabelipp))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelemail)
                                            .addComponent(jLabelnumsecu))))
                                .addGap(405, 405, 405))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabeljour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelmois)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelannée)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabeltelephone)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ServiceRespo)
                                                    .addComponent(ServiceGeo))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelchamnre)))
                                        .addGap(405, 405, 405))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Sexe)
                                        .addGap(393, 393, 393)))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtoninfomed)
                .addGap(598, 598, 598))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(349, 349, 349)
                    .addComponent(jLabeladresse2)
                    .addContainerGap(1115, Short.MAX_VALUE)))
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
                            .addComponent(jLabelipp)
                            .addComponent(jLabelnom1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeljour)
                            .addComponent(jLabel2)
                            .addComponent(jLabelmois)
                            .addComponent(jLabel3)
                            .addComponent(jLabelannée))
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ServiceRespo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ServiceGeo)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Sexe)
                        .addGap(37, 37, 37)
                        .addComponent(jLabelnumsecu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelemail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabeltelephone)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelchamnre))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jButtoninfomed)
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(jLabeladresse2)
                    .addContainerGap(502, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ServiceGeo;
    private javax.swing.JLabel ServiceRespo;
    private javax.swing.JLabel Sexe;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtoninfomed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabeladresse2;
    private javax.swing.JLabel jLabelannée;
    private javax.swing.JLabel jLabelchamnre;
    private javax.swing.JLabel jLabelemail;
    private javax.swing.JLabel jLabelipp;
    private javax.swing.JLabel jLabeljour;
    private javax.swing.JLabel jLabelmois;
    private javax.swing.JLabel jLabelnom;
    private javax.swing.JLabel jLabelnom1;
    private javax.swing.JLabel jLabelnumsecu;
    private javax.swing.JLabel jLabelprenom;
    private javax.swing.JLabel jLabeltelephone;
    // End of variables declaration//GEN-END:variables
}
