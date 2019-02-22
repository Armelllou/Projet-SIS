/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.ActeInfirmierPH;
import interfaces.ConsultationIDE;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.PrescriptionIDE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAccueilPrescriptionIDE implements ActionListener {
    
    PrescriptionIDE ai;
    ConsulterDPIPHetIDE dpiphide;
    Fenetre jframe;
    Sih sih;

    public BoutonAccueilPrescriptionIDE(Fenetre jframe,PrescriptionIDE ai, ConsulterDPIPHetIDE dpiphide, Sih sih) {
        this.jframe = jframe;
        this.ai=ai;
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