/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.AccueilSecretaires;
import interfaces.ConsulterDPISecretaire;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author Manon
 */
public class BoutonRetourDPISecretaireVersAccueil implements ActionListener {

    AccueilSecretaires as;
    ConsulterDPISecretaire dpis;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourDPISecretaireVersAccueil(Fenetre jframe,AccueilSecretaires as, ConsulterDPISecretaire dpis, Sih sih) {
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
