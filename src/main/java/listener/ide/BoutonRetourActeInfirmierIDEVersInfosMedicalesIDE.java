/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.ActeInfirmierIDE;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourActeInfirmierIDEVersInfosMedicalesIDE implements ActionListener {

    ActeInfirmierIDE ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourActeInfirmierIDEVersInfosMedicalesIDE(Fenetre jframe, InfosMedicalesIDE im, ActeInfirmierIDE ai, Sih sih) {
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
