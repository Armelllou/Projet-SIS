/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.Fenetre;
import interfaces.ActeInfirmier;
import interfaces.InfosMedicalesPH;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.ListenerConnexion;

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

    public void actionPerformed(ActionEvent ae) {
        
        
        jframe.panelVisibleFalse();
        jframe.add(im);
        im.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
