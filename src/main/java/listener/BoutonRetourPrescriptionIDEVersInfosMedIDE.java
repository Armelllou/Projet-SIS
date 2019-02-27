/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.nf.Sih;
import main.java.interfaces.Fenetre;
import main.java.interfaces.ide.InfosMedicalesIDE;
import main.java.interfaces.ide.PrescriptionIDE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonRetourPrescriptionIDEVersInfosMedIDE implements ActionListener {
    
    PrescriptionIDE c;
    InfosMedicalesIDE im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourPrescriptionIDEVersInfosMedIDE(Fenetre jframe,PrescriptionIDE c,InfosMedicalesIDE im, Sih sih) {
        this.jframe = jframe;
        this.c=c;
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
