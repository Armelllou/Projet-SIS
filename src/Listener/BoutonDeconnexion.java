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
    Fenetre fen;

    public BoutonDeconnexion(Connexion c, Fenetre fen,BarreDuHaut b) {
        this.c = c;
        this.fen = fen;
        this.b=b;
    }

    public void actionPerformed(ActionEvent e) {
        fen.TotaliteFalse();
      
        fen.add(c);
        c.setVisible(true);
        c.getjPasswordField1().setText("*******************");
        c.getjTextField1().setText("");

        fen.setSize(1700, 830);
        fen.revalidate();
        fen.repaint();

        //jframe.setState(State.NONCO);
    }
}
