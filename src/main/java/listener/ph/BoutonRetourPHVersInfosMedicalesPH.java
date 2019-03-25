/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.Fenetre;

import interfaces.InfosMedicalesPH;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.ListenerConnexion;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonRetourPHVersInfosMedicalesPH implements ActionListener {

 
    InfosMedicalesPH im;
    Fenetre jframe;
   
     ListenerConnexion l;

    public BoutonRetourPHVersInfosMedicalesPH(Fenetre jframe, InfosMedicalesPH im,ListenerConnexion l) {
        this.jframe = jframe;
        this.im = im;
        this.l = l;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (l.ConnexionPH() == true){
                RafraichitLesPanels rf = new RafraichitLesPanels(jframe,im);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoutonRetourPHVersInfosMedicalesPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
