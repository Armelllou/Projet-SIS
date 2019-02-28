/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TableauPrestations implements MouseListener {

    Prestations p;
    PrestationFaite pf;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauPrestations(Prestations p, PrestationFaite pf, Fenetre fen, Sih sih, JTable table) {
        this.p = p;
        this.pf = pf;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        int numLigne = table.getSelectedRow();
        fen.panelVisibleFalse();
        fen.add(pf);
        pf.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
