/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonDeconnexion implements ActionListener {

    BarreDuHaut b;
    Connexion c;
    Fenetre fen;

    public BoutonDeconnexion(Connexion c, Fenetre fen, BarreDuHaut b) {
        this.c = c;
        this.fen = fen;
        this.b = b;
    }

    public void actionPerformed(ActionEvent e) {
        fen.totaliteFalse();

//        fen.add(c);
//        c.setVisible(true);
//         fen.revalidate();
//        fen.repaint();
        
    RafraichitLesPanels rf = new RafraichitLesPanels(fen,c);
        c.getjPasswordField1().setSize(2,5);
        c.getjPasswordField1().setText("");
        c.getjTextField1().setText("");

        fen.setSize(1700, 830);
       

        //jframe.setState(State.NONCO);
    }
}
