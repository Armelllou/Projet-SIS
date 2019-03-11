/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import interfaces.PrescriptionIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourPrescriptionIDEVersInfosMedIDE implements ActionListener {

    PrescriptionIDE c;
    InfosMedicalesIDE im;
    Fenetre jframe;


    public BoutonRetourPrescriptionIDEVersInfosMedIDE(Fenetre jframe, PrescriptionIDE c, InfosMedicalesIDE im) {
        this.jframe = jframe;
        this.c = c;
        this.im = im;
       
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(im);
        im.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
