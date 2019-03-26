/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.ConsultationIDE;
import interfaces.Fenetre;
import interfaces.InfosMedicalesIDE;
import listener.commun.RafraichitLesPanels;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static bd.MethodeBD.executeQuery;

public class TableauConsultationsInfosMedIDE implements MouseListener {

    InfosMedicalesIDE imph;
    ConsultationIDE cph;
    Fenetre fen;

    JTable table;

    public TableauConsultationsInfosMedIDE(InfosMedicalesIDE imph, ConsultationIDE cph, Fenetre fen, JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;

        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            String ipp = imph.getjLabelipp().getText();
            int numLigne = table.getSelectedRow();
            String Nomemdecin = (String) table.getModel().getValueAt(numLigne, 0);
            String dates = (String) table.getModel().getValueAt(numLigne, 1);


            ResultSet rs = executeQuery("Select * from consultation WHERE IPP ='" + ipp + "'and NomMedecin='" + Nomemdecin + "'and Date ='" + dates + "'");

            while (rs.next()) {

                String nomMedecin = rs.getString(4);
                String observation = rs.getString(1);
                String date = rs.getString(3);

                cph.getObservation().setText(observation);
                cph.getDate().setText(date);
                cph.getNoMedecin().setText(nomMedecin);

                RafraichitLesPanels rf = new RafraichitLesPanels(fen, cph);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsultationsInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
//throw new UnsupportedOperationException();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//throw new UnsupportedOperationException();
    }

    @Override
    public void mouseExited(MouseEvent e) {
//throw new UnsupportedOperationException();
    }


}
