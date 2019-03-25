/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.ConsultationIDE;
import interfaces.InfosMedicalesIDE;


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
public class BoutonRetourIDEVersInfosMedIDE implements ActionListener {

    ConsultationIDE c;
    InfosMedicalesIDE im;
    Fenetre jframe;
 ListenerConnexion l;

    public BoutonRetourIDEVersInfosMedIDE(Fenetre jframe, InfosMedicalesIDE im,ListenerConnexion l) {
        
        
        this.jframe = jframe;
       
        this.l=l;
       this.im=im;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            if (l.ConnexionIde() == true) {
                RafraichitLesPanels rf = new RafraichitLesPanels(jframe,im);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoutonRetourIDEVersInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
