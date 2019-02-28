/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.Fenetre;
import interfaces.TransfertService;
import interfaces.DPIPH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonAnnulerTransfert implements ActionListener {
    DPIPH dpi;
    TransfertService im;
    Fenetre fen;

    public BoutonAnnulerTransfert(DPIPH dpi, TransfertService im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {
        fen.panelVisibleFalse();
        fen.add(dpi);
        dpi.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}
