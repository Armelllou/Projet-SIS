/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.nf.Sih;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;
import main.java.interfaces.dpi.CreationDPI;
import main.java.interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAnnulerCreationDPI implements ActionListener {
    
    ConsulterDPISecretaire cdpi;
    CreationDPI dpi;
    Fenetre jframe;
    Sih sih;

    public BoutonAnnulerCreationDPI(Fenetre jframe,ConsulterDPISecretaire cdpi, CreationDPI dpi, Sih sih) {
        this.jframe = jframe;
        this.cdpi=cdpi;
        this.dpi=dpi;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(cdpi);
        cdpi.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
}
