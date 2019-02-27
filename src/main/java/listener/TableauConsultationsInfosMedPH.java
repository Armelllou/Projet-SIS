/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.interfaces.Fenetre;
import main.java.interfaces.ph.ConsultationPH;
import main.java.interfaces.ph.InfosMedicalesPH;
import main.java.nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableauConsultationsInfosMedPH implements MouseListener {


    InfosMedicalesPH imph;
    ConsultationPH cph;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauConsultationsInfosMedPH(InfosMedicalesPH imph, ConsultationPH cph, Fenetre fen, Sih sih, JTable table) {
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
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
