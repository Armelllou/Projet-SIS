/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener.ph;

import main.java.interfaces.ConsulterDPIPHetIDE;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.ActeInfirmierPH;
import main.java.nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAccueilActeInfirmierPH implements ActionListener {

    ActeInfirmierPH ai;
    ConsulterDPIPHetIDE dpiphide;
    Fenetre jframe;
    Sih sih;

    public BoutonAccueilActeInfirmierPH(Fenetre jframe, ActeInfirmierPH ai, ConsulterDPIPHetIDE dpiphide, Sih sih) {
        this.jframe = jframe;
        this.ai = ai;
        this.dpiphide = dpiphide;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(dpiphide);
        dpiphide.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
