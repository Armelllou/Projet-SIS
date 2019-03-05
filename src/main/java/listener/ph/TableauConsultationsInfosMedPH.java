/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ConsultationPH;
import interfaces.InfosMedicalesPH;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.ide.TableauConsultationsInfosMedIDE;

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
        try {
            String ipp = imph.getjLabelipp().getText();
            String idIde = "";
            int id = 0;

            int numLigne = table.getSelectedRow();

            String Nomemdecin = (String) table.getModel().getValueAt(numLigne, 0);
            String dates = (String) table.getModel().getValueAt(numLigne, 1);

            String Sql1 = "Select * from consultation WHERE IPP ='" + ipp + "'and NomMedecin='" + Nomemdecin + "'and Date ='" + dates + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;

            ps = conn.getConnexion().prepareStatement(Sql1);

            ResultSet Rs = ps.executeQuery();;

            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (Rs.next()) {

                String nomMedecin = Rs.getString(4);
                String observation = Rs.getString(1);
                String date = Rs.getString(3);

                cph.getObservation().setText(observation);
                cph.getDate().setText(date);
                cph.getNoMedecin().setText(nomMedecin);

                fen.panelVisibleFalse();
                fen.add(cph);
                cph.setVisible(true);
                fen.revalidate();
                fen.repaint();

            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsultationsInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
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
