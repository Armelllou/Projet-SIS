/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AjouterConsultation;
import interfaces.Fenetre;
import interfaces.InfosMedicales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAnnulerAjouterConsultation implements ActionListener {
    
    AjouterConsultation ac;
    InfosMedicales im;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerAjouterConsultation(Fenetre jframe,AjouterConsultation ac, InfosMedicales im, Sih sih) {
        this.jframe = jframe;
        this.ac=ac;
        this.im=im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(im);
        im.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}