/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.ConnexionBD;
import interfaces.ActeInfirmier;
import interfaces.ActeInfirmieride;
import interfaces.Fenetre;
import interfaces.BarreDuHaut;
import interfaces.InfosMedicalesIDE;
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
import listener.commun.RafraichitLesPanels;

import static bd.MethodeBD.executeQuery;

public class TableauActesInfirmiersInfosMedIDE implements MouseListener {

    InfosMedicalesIDE imph;
    ActeInfirmieride cph;
    Fenetre fen;
    BarreDuHaut bh;
    JTable table;

    public TableauActesInfirmiersInfosMedIDE(InfosMedicalesIDE imph, ActeInfirmieride cph, Fenetre fen, BarreDuHaut bh, JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;
        this.bh = bh;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            String ipp = imph.getjLabelipp().getText();
            String idIde ;
            int id = 0;

            
            int numLigne = table.getSelectedRow();
            
            String types = (String) table.getModel().getValueAt(numLigne, 0);
            String dates = (String) table.getModel().getValueAt(numLigne, 2);
       
           

            ResultSet rs = executeQuery("Select * from actes WHERE IPP ='" + ipp + "'and type='" + types +"'and Date ='"+dates+"'");

            while (rs.next()) {
                
                idIde   = rs.getString(1);
                id = Integer.decode(idIde);
                String type = rs.getString(3);
                String observation = rs.getString(4);
                String date = rs.getString(5);

                cph.getObservations().setText(observation);
                cph.getDate1().setText(dates);
                cph.getType().setText(type);

            }

            ResultSet rs2 = executeQuery("Select * from ide WHERE idIDE = '" + id + "'");


            while (rs2.next()) {

                String nom = rs2.getString(3);
                String prenom = rs2.getString(4);
                

                cph.getNomide1().setText(nom);
                cph.getPrenomide1().setText(prenom);

               
            }
            
             RafraichitLesPanels rf = new RafraichitLesPanels(fen,cph);
        } catch (SQLException ex) {
            Logger.getLogger(TableauActesInfirmiersInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
          }
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
