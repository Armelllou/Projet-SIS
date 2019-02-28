/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;


import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.CreationDPI;
import interfaces.ConsulterDPISecretaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author annel
 */
public class BoutonCreerDPI implements ActionListener {

    CreationDPI dpi;
    ConsulterDPISecretaire cdpi;
    Fenetre fen;
    BarreDuHaut bh;

    public BoutonCreerDPI(ConsulterDPISecretaire cdpi, CreationDPI dpi, Fenetre jframe) {
        this.fen = jframe;
        this.dpi = dpi;
        this.cdpi = cdpi;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        fen.panelVisibleFalse();

        fen.add(dpi);
        dpi.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

}
