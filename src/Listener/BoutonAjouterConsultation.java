/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AjouterConsultation;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAjouterConsultation implements ActionListener {
    
    AjouterConsultation ac;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonAjouterConsultation(Fenetre jframe,AjouterConsultation ac, InfosMedicalesPH im, Sih sih) {
        this.jframe = jframe;
        this.ac=ac;
        this.im=im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(ac);
        ac.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}