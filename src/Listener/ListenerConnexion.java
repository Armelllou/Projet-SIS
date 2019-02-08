/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.AccueilSecretaire;
import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.Fenetre;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author annel
 */
public abstract class ListenerConnexion implements ActionListener {
    Connexion c;
    AccueilSecretaire as;
      JPanel jp;
    Fenetre jframe;
    BarreDuHaut bh;
    
   public ListenerConnexion(BarreDuHaut bh, Connexion c, JPanel jp,Fenetre jframe) {
        this.bh = bh;
        this.c = c;
        this.jframe = jframe;
        this.jp=jp;
       
    }
   
    public void connexion(){
//         String id = c.getjTextField1().getText();
//        String mdp = c.getjPasswordField1().getText();
//        Identification identif2 = new Identification(id, mdp);
//        Connexion con = new Connexion();

        
//            if (con.VerificationConnexion(identif2) && identif2.Type() == 1) {
//                jframe.setState(State.MED);
//                jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//                jframe.setLayout(new BorderLayout());
//                b.getjLabel2().setText(con.getType());
                //b.getjLabel2().setIcon(new javax.swing.ImageIcon(getClass().getResource(con.getPhoto())));
                
                jframe.add(jp,BorderLayout.CENTER);
                jframe.add(bh,BorderLayout.NORTH);
                bh.setVisible(true);
                jp.setVisible(true);         
                c.setVisible(false);
                jframe.revalidate();
                jframe.repaint();
                
                
//            } else if (con.VerificationConnexion(identif2) && identif2.Type() == 2) {
//               jframe.setState(State.ADMIN);
//                jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//                jframe.setLayout(new BorderLayout());
//                b.getjLabel2().setText(identif2.getType());
//               // b.getjLabel2().setIcon(new javax.swing.ImageIcon(getClass().getResource(identif2.getPhoto())));
//                jframe.add(m,BorderLayout.WEST);
//                jframe.add(jp,BorderLayout.CENTER);
//                jframe.add(b,BorderLayout.NORTH);
//                m.setVisible(true);
//                jp.setVisible(true);         
//                c.setVisible(false);
//                jframe.repaint();
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Identifiant ou mdp incorrect");
//                System.out.println("test");
//            }
   

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        jframe.PanelVisibleFalse();
//        jframe.add(as);
//        as.setVisible(true);
//        jframe.revalidate();
//        jframe.repaint();
//    
}
}
 

   
    
   

    