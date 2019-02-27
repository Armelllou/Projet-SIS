/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.nf.Sih;
import main.java.interfaces.ph.ActeInfirmierPH;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.InfosMedicalesPH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonRetourActeInfirmierPHVersInfosMedicalesPH implements ActionListener {
    
    ActeInfirmierPH ai;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourActeInfirmierPHVersInfosMedicalesPH(Fenetre jframe,InfosMedicalesPH im, ActeInfirmierPH ai, Sih sih) {
        this.jframe = jframe;
        this.ai=ai;
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
