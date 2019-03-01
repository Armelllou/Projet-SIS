/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.DPIIDE;
import interfaces.InfosMedicalesIDE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Manon
 */
public class BoutonDPIIDEVersInfosMedIDE implements ActionListener {
    DPIIDE dpi;
    InfosMedicalesIDE im;
    Fenetre fen;
    String ipp;

    public BoutonDPIIDEVersInfosMedIDE(DPIIDE dpi, InfosMedicalesIDE im, Fenetre fen) {
        this.dpi = dpi;
        this.im = im;
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {
        fen.panelVisibleFalse();
        fen.add(im);
        im.setVisible(true);
        fen.revalidate();
        fen.repaint();


        String ipp = DPIIDE.getjLabelipp().getText();
        im.getjTable3().setFont(new Font("Calibri", 0, 18));
        im.getjTable3().setModel(MethodeBD.listeConsultationJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD


        im.getjTable2().setFont(new Font("Calibri", 0, 18));
        im.getjTable2().setModel(MethodeBD.listeActeJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD


        im.getjTable1().setFont(new Font("Calibri", 0, 18));
        im.getjTable1().setModel(MethodeBD.listePrescriptionJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD

    }
}
