/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import interfaces.DetailsPrestation;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author annel
 */
public class BoutonAnnulerResultats implements ActionListener{
    PrestationFaite pf;
    DetailsPrestation dp;
    Fenetre fen;

    public BoutonAnnulerResultats(PrestationFaite pf, DetailsPrestation dp, Fenetre fen) {
        this.pf = pf;
        this.dp = dp;
        this.fen = fen;
    }

            

    @Override
    public void actionPerformed(ActionEvent e) {
          RafraichitLesPanels rf = new RafraichitLesPanels(fen,dp);
    }
}
