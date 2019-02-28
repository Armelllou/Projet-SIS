/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.Fenetre;
import interfaces.ConsultationIDE;
import interfaces.InfosMedicalesIDE;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TableauConsultationsInfosMedIDE implements MouseListener {


    InfosMedicalesIDE imph;
    ConsultationIDE cph;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauConsultationsInfosMedIDE(InfosMedicalesIDE imph, ConsultationIDE cph, Fenetre fen, Sih sih, JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int numLigne = table.getSelectedRow();
        fen.panelVisibleFalse();
        fen.add(cph);
        cph.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
