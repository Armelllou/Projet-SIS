/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.interfaces.AjouterPrestation;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.InfosMedicalesPH;
import main.java.nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAnnulerAjouterPrestation implements ActionListener {

    AjouterPrestation ap;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerAjouterPrestation(Fenetre jframe, AjouterPrestation ap, InfosMedicalesPH im, Sih sih) {
        this.jframe = jframe;
        this.ap = ap;
        this.im = im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(im);
        im.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
}
