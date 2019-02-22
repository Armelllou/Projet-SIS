/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AjouterActeInfirmier;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAjouterActeInfirmier implements ActionListener {
    
    AjouterActeInfirmier ai;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;

    public BoutonAjouterActeInfirmier(Fenetre jframe,AjouterActeInfirmier ai,InfosMedicalesIDE im, Sih sih) {
        this.jframe = jframe;
        this.ai=ai;
        this.im=im;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(ai);
        ai.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}