/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener.ph;

import main.java.interfaces.AjouterConsultation;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.InfosMedicalesPH;
import main.java.nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAnnulerAjouterConsultation implements ActionListener {

    AjouterConsultation ac;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerAjouterConsultation(Fenetre jframe, AjouterConsultation ac, InfosMedicalesPH im, Sih sih) {
        this.jframe = jframe;
        this.ac = ac;
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
