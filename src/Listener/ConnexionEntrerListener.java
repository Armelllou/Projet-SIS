/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.ConsulterDPISecretaire;
import interfaces.Fenetre;
import interfaces.Prestations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annel
 */
public class ConnexionEntrerListener extends ListenerConnexion  implements KeyListener{

    public ConnexionEntrerListener(BarreDuHaut bh, Connexion c, ConsulterDPISecretaire as, ConsulterDPIPHetIDE cdpiphetide, Prestations p, Fenetre jframe) {
        super(bh, c, as, cdpiphetide, p, jframe);
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_ENTER){
           try {
               super.connexion();
               
           } catch (SQLException ex) {
               //Logger.getLogger(ConnexionEntrerListener.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
         
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    
}
