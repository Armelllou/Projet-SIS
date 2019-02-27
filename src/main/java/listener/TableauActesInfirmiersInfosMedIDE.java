/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.interfaces.Fenetre;
import main.java.interfaces.ide.ActeInfirmierIDE;
import main.java.interfaces.ide.InfosMedicalesIDE;
import main.java.nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TableauActesInfirmiersInfosMedIDE implements MouseListener {


    InfosMedicalesIDE imph;
    ActeInfirmierIDE cph;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauActesInfirmiersInfosMedIDE(InfosMedicalesIDE imph, ActeInfirmierIDE cph, Fenetre fen, Sih sih, JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int numLigne = table.getSelectedRow();
        fen.PanelVisibleFalse();
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
