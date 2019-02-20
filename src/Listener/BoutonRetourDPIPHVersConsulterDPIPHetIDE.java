/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.ConsulterDPISecretaire;
import interfaces.DPIIDE;
import interfaces.DPIPH;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonRetourDPIPHVersConsulterDPIPHetIDE implements ActionListener {
    
    DPIPH dpis;
    ConsulterDPIPHetIDE cdpis;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourDPIPHVersConsulterDPIPHetIDE(Fenetre jframe,ConsulterDPIPHetIDE cdpis, DPIPH dpis, Sih sih) {
        this.jframe = jframe;
        this.cdpis=cdpis;
        this.dpis=dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.PanelVisibleFalse();
        jframe.add(cdpis);
        cdpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }
    
}
