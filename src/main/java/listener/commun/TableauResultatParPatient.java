/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;


import interfaces.Fenetre;

import interfaces.ResultatParPatient;
import interfaces.ResultatsConsulter;
;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

/**
 *
 * @author annel
 */
public class TableauResultatParPatient implements MouseListener {

    Fenetre fen;
    ResultatsConsulter pf;
    ResultatParPatient rp;
    JTable table;

    public TableauResultatParPatient(Fenetre fen, ResultatsConsulter pf, ResultatParPatient rp, JTable table) {
        this.fen = fen;
        this.pf = pf;
        this.rp = rp;
        this.table = table;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int NumLigne = table.getSelectedRow();


        pf.getNomPatient().setText((String) table.getModel().getValueAt(NumLigne, 0));
        pf.getPrenomPatient().setText((String) table.getModel().getValueAt(NumLigne, 1));
        pf.getIpp().setText((String) table.getModel().getValueAt(NumLigne, 2));
        pf.getResultats().setText((String) table.getModel().getValueAt(NumLigne, 3));
        pf.getNomMedecin().setText((String) table.getModel().getValueAt(NumLigne, 4));

           RafraichitLesPanels rf = new RafraichitLesPanels(fen,pf);
        
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
