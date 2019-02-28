/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import interfaces.PrescriptionPH;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourPrescriptionPHVersInfosMedPH implements ActionListener {

    PrescriptionPH c;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourPrescriptionPHVersInfosMedPH(Fenetre jframe, PrescriptionPH c, InfosMedicalesPH im, Sih sih) {
        this.jframe = jframe;
        this.c = c;
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
