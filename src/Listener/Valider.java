/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.AccueilSecretaire;
import interfaces.Connexion;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class Valider implements ActionListener {
    Connexion c;
    AccueilSecretaire as;
    Fenetre jframe;

    public Valider(AccueilSecretaire as, Connexion c, Fenetre jframe) {
        this.jframe = jframe;
        this.c = c;
        this.as = as;
    }


    public void actionPerformed(ActionEvent e) {
        jframe.PanelVisibleFalse();
        jframe.add(as);
        as.setVisible(true);
        jframe.revalidate();
        jframe.repaint();
    
}
}
