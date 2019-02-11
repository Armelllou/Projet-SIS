/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import BD.ConnexionBD;
import interfaces.AccueilSecretaire;
import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPI;
import interfaces.Fenetre;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author annel
 */
public abstract class ListenerConnexion implements ActionListener {

    Connexion c;
    JPanel jp;
    Fenetre jframe;
    BarreDuHaut bh;

    ConnexionBD conn = new ConnexionBD();

    ;
 
    

    public ListenerConnexion(BarreDuHaut bh, Connexion c, JPanel jp, Fenetre jframe) {
        this.bh = bh;
        this.c = c;
        this.jframe = jframe;
        this.jp = jp;

    }

    public void connexion() throws SQLException {
        
        
        if (connexionSecretaire()==true){
           
        }
        else  {
           ConnexionIde();
        
    }
        
       //ConnexionPH();
       
    
    }
    
    
    
    public void ConnexionPH() throws SQLException{
        //            String Sql1 = "Select from  praticienhospitalier WHERE idPH ='" + c.getjTextField1().getText() + "'and motDePasse ='" + c.getjPasswordField1().getText()+ "'";
//            ps = conn.getConnexion().prepareStatement(Sql1);
//            Rs = ps.executeQuery();
//            if (Rs.next()) {
//                JOptionPane.showMessageDialog(null, "Correct");
//                jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//                jframe.setLayout(new BorderLayout());
//
//                jframe.PanelVisibleFalse();
//                ConsulterDPIPHetIDE cdpiphetide = new ConsulterDPIPHetIDE();
//                jframe.add(cdpiphetide, BorderLayout.CENTER);
//                jframe.add(bh, BorderLayout.NORTH);
//
//                bh.setVisible(true);
//                cdpiphetide.setVisible(true);
//                jframe.revalidate();
//                jframe.repaint();
//            }
//            else {
//                 JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
//            }
//        }catch (Exception e){
//             JOptionPane.showMessageDialog(null, e);
//        }

    }
    

public boolean ConnexionIde() throws SQLException {
        boolean j = false;
    
    
          String Sql1 = "Select * from ide WHERE idIDE ='" +c.getjTextField1().getText()+"'and motDePasse='"+c.getjPasswordField1().getText()+"'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet Rs = ps.executeQuery();
        
        
        if (Rs.next()) {
//                JOptionPane.showMessageDialog(null, "Correct");
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();
            ConsulterDPIPHetIDE cdpiphetide = new ConsulterDPIPHetIDE();
            jframe.add(cdpiphetide, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.setVisible(true);
            cdpiphetide.setVisible(true);
            jframe.revalidate();
            jframe.repaint();
            
            j= true;

        } else {
           // JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;
    
}
        
        
        
        
        
public boolean connexionSecretaire() throws SQLException {
boolean j = false;
 String Sql2 = "Select * from secretaireadministrative WHERE idSA ='" +c.getjTextField1().getText()+"'and motDePasse='"+c.getjPasswordField1().getText()+"'";
        PreparedStatement ps2 = conn.getConnexion().prepareStatement(Sql2);
        ResultSet Rs2 = ps2.executeQuery();

        if (Rs2.next()) {
//                JOptionPane.showMessageDialog(null, "Correct");
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();
            AccueilSecretaire as = new AccueilSecretaire();
            jframe.add(as, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.setVisible(true);
            as.setVisible(true);
            jframe.revalidate();
            jframe.repaint();
            
            j= true;

        } else {
            JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;

    }
}

