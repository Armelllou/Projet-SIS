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
        
          RafraichitLesPanels rf = new RafraichitLesPanels(jframe,im);
    }

}
