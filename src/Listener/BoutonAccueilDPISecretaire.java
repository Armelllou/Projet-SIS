/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AccueilSecretaires;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonAccueilDPISecretaire implements ActionListener {
    
    DPISecretaire dpis;
    AccueilSecretaires as;
    Fenetre jframe;
    Sih sih;

    public BoutonAccueilDPISecretaire(Fenetre jframe,DPISecretaire dpis, AccueilSecretaires as, Sih sih) {
        this.jframe = jframe;
        this.as=as;
        this.dpis=dpis;
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
