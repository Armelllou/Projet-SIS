/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.ResultatParPatient;
import interfaces.ResultatsConsulter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
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

        String NomPatient = (String) table.getModel().getValueAt(NumLigne, 0);
        String PrenomPatient = (String) table.getModel().getValueAt(NumLigne, 1);
        String IPP = (String) table.getModel().getValueAt(NumLigne, 2);
        String Resultats = (String) table.getModel().getValueAt(NumLigne, 3);
        String Date = (String) table.getModel().getValueAt(NumLigne, 4);

        pf.getNomPatient().setText(NomPatient);
        pf.getPrenomPatient().setText(PrenomPatient);
        pf.getIpp().setText(IPP);
        pf.getResultats().setText(Resultats);
        pf.getNomMedecin().setText(Date);

        fen.panelVisibleFalse();
        fen.add(pf);
        pf.setVisible(true);
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
