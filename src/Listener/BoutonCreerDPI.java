/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.AccueilSecretaire;
import interfaces.BarreDuHaut;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author annel
 */
public class BoutonCreerDPI implements ActionListener {

    CreationDPI dpi;
    AccueilSecretaire as;
    Fenetre jframe;
    BarreDuHaut bh;

    public BoutonCreerDPI(AccueilSecretaire as, CreationDPI dpi, Fenetre jframe,BarreDuHaut bh) {
        this.jframe = jframe;
        this.dpi = dpi;
        this.as = as;
        this.bh=bh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setLayout(new BorderLayout());

        jframe.PanelVisibleFalse();
        dpi = new CreationDPI();
        jframe.add(dpi, BorderLayout.CENTER);
        jframe.add(bh, BorderLayout.NORTH);

        bh.setVisible(true);
        as.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
