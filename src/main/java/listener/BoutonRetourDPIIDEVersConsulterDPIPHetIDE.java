/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.DPIIDE;
import nf.Sih;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonRetourDPIIDEVersConsulterDPIPHetIDE implements ActionListener {

    DPIIDE dpis;
    ConsulterDPIPHetIDE cdpis;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourDPIIDEVersConsulterDPIPHetIDE(Fenetre jframe, ConsulterDPIPHetIDE cdpis, DPIIDE dpis, Sih sih) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {
        jframe.panelVisibleFalse();
        jframe.add(cdpis);
        cdpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
