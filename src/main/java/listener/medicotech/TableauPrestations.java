/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.medicotech;

import interfaces.DetailsPrestation;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableauPrestations implements MouseListener {

    Prestations p;
    DetailsPrestation pf;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauPrestations(Prestations p, DetailsPrestation pf, Fenetre fen, Sih sih, JTable table) {
        this.p = p;
        this.pf = pf;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int numLigne = table.getSelectedRow();

        String NomPatient = (String) table.getModel().getValueAt(numLigne, 0);
        String PrenomPatient = (String) table.getModel().getValueAt(numLigne, 1);
        String IPP = (String) table.getModel().getValueAt(numLigne, 2);
        String details = (String) table.getModel().getValueAt(numLigne, 3);
        String Service = (String) table.getModel().getValueAt(numLigne, 4);
        String NomMedecin = (String) table.getModel().getValueAt(numLigne, 5);
        String idPresta = (String) table.getModel().getValueAt(numLigne, 6);

        pf.getPrenomPatient().setText(PrenomPatient);
        pf.getNomPatient().setText(NomPatient);
        pf.getNomMedecin().setText(NomMedecin);
        pf.getDetails().setText(details);
        pf.getIPP().setText(IPP);
        pf.getSrvice().setText(Service);
        pf.getDateDeDemande().setText(idPresta);
        pf.getDateDeDemande().setVisible(false);

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
