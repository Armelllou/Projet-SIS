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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author annel
 */
public class BoutonValiderConnexion extends ListenerConnexion implements ActionListener {
   
    public BoutonValiderConnexion(BarreDuHaut bh,Connexion c, JPanel jp ,Fenetre jframe) {
        super(bh,c,jp,jframe);  
        
    }

    public void actionPerformed(ActionEvent e) {
        try {
            super.connexion();
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
   
        
    
    
    
}
