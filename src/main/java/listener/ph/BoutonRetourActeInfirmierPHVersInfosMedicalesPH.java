/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.Fenetre;
import interfaces.ActeInfirmierPH;
import interfaces.InfosMedicalesPH;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourActeInfirmierPHVersInfosMedicalesPH implements ActionListener {

    ActeInfirmierPH ai;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourActeInfirmierPHVersInfosMedicalesPH(Fenetre jframe, InfosMedicalesPH im, ActeInfirmierPH ai) {
        this.jframe = jframe;
        this.ai = ai;
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
