/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener.ide;

import main.java.interfaces.Fenetre;
import main.java.interfaces.ide.DPIIDE;
import main.java.interfaces.ide.InfosMedicalesIDE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonDPIIDEVersInfosMedIDE implements ActionListener {
    DPIIDE dpi;
    InfosMedicalesIDE im;
    Fenetre fen;

    public BoutonDPIIDEVersInfosMedIDE(DPIIDE dpi, InfosMedicalesIDE im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {
        fen.PanelVisibleFalse();
        fen.add(im);
        im.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}
