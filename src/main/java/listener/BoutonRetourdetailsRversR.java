/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.DetailsResultats;
import interfaces.Fenetre;
import interfaces.Resultat;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonRetourdetailsRversR implements ActionListener {

    Resultat r;
    DetailsResultats dr;
    Fenetre fen;
    BarreDuHaut bh;

    public BoutonRetourdetailsRversR(Resultat r, DetailsResultats dr, Fenetre fen, BarreDuHaut bh) {
        this.dr = dr;
        this.r = r;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        r.getTablePrestation().setFont(new Font("Calibri", 0, 18));
//        r.getTablePrestation().setModel(new MethodeBD().listeResultats(bh.getService().getText()));

        fen.panelVisibleFalse();
        fen.add(r);
        r.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}
