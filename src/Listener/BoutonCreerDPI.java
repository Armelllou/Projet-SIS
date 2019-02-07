/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.AccueilSecretaire;
import interfaces.CreationDPI;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonCreerDPI implements ActionListener {

    CreationDPI dpi;
    AccueilSecretaire as;
    Fenetre jframe;

    public BoutonCreerDPI(AccueilSecretaire as, CreationDPI dpi, Fenetre jframe) {
        this.jframe = jframe;
        this.dpi = dpi;
        this.as = as;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jframe.PanelVisibleFalse();
        jframe.add(dpi);
        dpi.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    }

}
