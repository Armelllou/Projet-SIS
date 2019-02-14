/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import interfaces.ModificationDPI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonModifierDPI implements ActionListener {
    
    DPISecretaire dpis;
    ModificationDPI mdpi;
    Fenetre jframe;
    Sih sih;

    public BoutonModifierDPI(Fenetre jframe, DPISecretaire dpis, ModificationDPI mdpi, Sih sih) {
        this.jframe = jframe;
        this.mdpi=mdpi;
        this.dpis=dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(mdpi);
        mdpi.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}
