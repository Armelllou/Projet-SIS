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


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import listener.commun.RafraichitLesPanels;

public class TableauPrestations implements MouseListener {

    Prestations p;
    DetailsPrestation pf;
    Fenetre fen;
    JTable table;

    public TableauPrestations(Prestations p, DetailsPrestation pf, Fenetre fen,  JTable table) {
        this.p = p;
        this.pf = pf;
        this.fen = fen;
       
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
        
    RafraichitLesPanels rf = new RafraichitLesPanels(fen,pf);
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    
    }

    @Override
    public void mouseExited(MouseEvent me) {
    
    }

}
