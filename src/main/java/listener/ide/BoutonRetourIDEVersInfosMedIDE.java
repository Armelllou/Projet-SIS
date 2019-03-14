/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.ConsultationIDE;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourIDEVersInfosMedIDE implements ActionListener {

    ConsultationIDE c;
    InfosMedicalesIDE im;
    Fenetre jframe;
 

    public BoutonRetourIDEVersInfosMedIDE(Fenetre jframe, InfosMedicalesIDE im) {
        this.jframe = jframe;
        this.c = c;
        
       this.im=im;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(im);
        im.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
