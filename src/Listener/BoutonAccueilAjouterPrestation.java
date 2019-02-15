/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AjouterPrestation;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAccueilAjouterPrestation implements ActionListener {
    
    AjouterPrestation ap;
    ConsulterDPIPHetIDE dpiphide;
    Fenetre jframe;
    Sih sih;

    public BoutonAccueilAjouterPrestation(Fenetre jframe,AjouterPrestation ap, ConsulterDPIPHetIDE dpiphide, Sih sih) {
        this.jframe = jframe;
        this.ap=ap;
        this.dpiphide=dpiphide;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(dpiphide);
        dpiphide.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}
