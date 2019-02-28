/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.Fenetre;
import interfaces.CreationDPI;
import interfaces.ConsulterDPISecretaire;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAnnulerCreationDPI implements ActionListener {

    ConsulterDPISecretaire cdpi;
    CreationDPI dpi;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerCreationDPI(Fenetre jframe, ConsulterDPISecretaire cdpi, CreationDPI dpi, Sih sih) {
        this.jframe = jframe;
        this.cdpi = cdpi;
        this.dpi = dpi;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(cdpi);
        cdpi.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
}
