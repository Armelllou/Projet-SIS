/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.interfaces.AjouterPrescription;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.InfosMedicalesPH;
import main.java.nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAjouterPrescription implements ActionListener {

    AjouterPrescription ac;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonAjouterPrescription(Fenetre jframe, AjouterPrescription ac, InfosMedicalesPH im, Sih sih) {
        this.jframe = jframe;
        this.ac = ac;
        this.im = im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(ac);
        ac.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
