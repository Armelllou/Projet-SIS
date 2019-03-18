/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import interfaces.CreationPersonnel;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class BoutonAnnulerPersonnel implements ActionListener {
    Fenetre fen;
    ListePersonnel lp;
    CreationPersonnel cp;

    public BoutonAnnulerPersonnel(Fenetre fen, ListePersonnel lp, CreationPersonnel cp) {
        this.fen = fen;
        this.lp = lp;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
               RafraichitLesPanels rf = new RafraichitLesPanels(fen,lp);
    }

}
