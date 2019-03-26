/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import interfaces.DPIPH;
import interfaces.Fenetre;
import interfaces.TransfertService;
import listener.commun.RafraichitLesPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonDPIPHVersTransfert implements ActionListener {
    DPIPH dpi;
    TransfertService im;
    Fenetre fen;

    public BoutonDPIPHVersTransfert(DPIPH dpi, TransfertService im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String IPP = dpi.getjLabelipp().getText();
        String NomUsuel = dpi.getjLabelnom().getText();
        String NomDeNaissance = dpi.getjLabelnom1().getText();
        String Prenom = dpi.getjLabelprenom().getText();

        im.getjLabelnom().setText(NomUsuel);
        im.getjLabelnom1().setText(NomDeNaissance);
        im.getjLabelprenom().setText(Prenom);
        im.getjLabelipp().setText(IPP);

        RafraichitLesPanels rf = new RafraichitLesPanels(fen, im);
    }
}
