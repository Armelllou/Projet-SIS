/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.interfaces.AjouterActeInfirmier;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ide.InfosMedicalesIDE;
import main.java.nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonAjouterActeInfirmier implements ActionListener {

    AjouterActeInfirmier ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;

    public BoutonAjouterActeInfirmier(Fenetre jframe, AjouterActeInfirmier ai, InfosMedicalesIDE im, Sih sih) {
        this.jframe = jframe;
        this.ai = ai;
        this.im = im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(ai);
        ai.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
