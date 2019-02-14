/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AccueilSecretaires;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAnnulerCreationDPI implements ActionListener {
    
    AccueilSecretaires as;
    CreationDPI dpi;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerCreationDPI(Fenetre jframe,AccueilSecretaires as, CreationDPI dpi, Sih sih) {
        this.jframe = jframe;
        this.as=as;
        this.dpi=dpi;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(as);
        as.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
}
