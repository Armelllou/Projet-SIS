/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.Fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manon
 */
public class BoutonDeconnexion implements ActionListener {

    BarreDuHaut b;
    Connexion c;
    Fenetre jframe;

    public BoutonDeconnexion(Connexion c, Fenetre jframe, BarreDuHaut b) {
        this.b = b;
        this.c = c;
        this.jframe = jframe;
    }

    public void actionPerformed(ActionEvent e) {
        jframe.PanelVisibleFalse();
        c.setVisible(true);
        c.getjPasswordField1().setText("");
        c.getjTextField1().setText("");
        jframe.setSize(1700, 830);
        jframe.repaint();

        //jframe.setState(State.NONCO);
    }
}
