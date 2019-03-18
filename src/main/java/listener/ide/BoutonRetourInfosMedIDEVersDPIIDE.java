/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.DPIIDE;
import interfaces.InfosMedicalesIDE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonRetourInfosMedIDEVersDPIIDE implements ActionListener {
    DPIIDE dpi;
    InfosMedicalesIDE im;
    Fenetre fen;

    public BoutonRetourInfosMedIDEVersDPIIDE(DPIIDE dpi, InfosMedicalesIDE im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          RafraichitLesPanels rf = new RafraichitLesPanels(fen,dpi);
    }
}
