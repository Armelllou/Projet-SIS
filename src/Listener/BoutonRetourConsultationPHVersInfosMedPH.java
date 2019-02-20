/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.ConsultationPH;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonRetourConsultationPHVersInfosMedPH implements ActionListener {
    
    ConsultationPH c;
    InfosMedicalesPH im;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourConsultationPHVersInfosMedPH(Fenetre jframe,ConsultationPH c,InfosMedicalesPH im, Sih sih) {
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
