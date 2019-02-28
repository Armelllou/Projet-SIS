/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAccueilInfosMedIDE implements ActionListener {

    InfosMedicalesIDE ai;
    ConsulterDPIPHetIDE dpiphide;
    Fenetre jframe;
    Sih sih;

    public BoutonAccueilInfosMedIDE(Fenetre jframe, InfosMedicalesIDE ai, ConsulterDPIPHetIDE dpiphide, Sih sih) {
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
