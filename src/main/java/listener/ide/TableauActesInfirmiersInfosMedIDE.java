/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ActeInfirmierIDE;
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

public class TableauActesInfirmiersInfosMedIDE implements MouseListener {

    InfosMedicalesIDE imph;
    ActeInfirmierIDE cph;
    Fenetre fen;
    BarreDuHaut bh;
    JTable table;

    public TableauActesInfirmiersInfosMedIDE(InfosMedicalesIDE imph, ActeInfirmierIDE cph, Fenetre fen, BarreDuHaut bh, JTable table) {
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
            String idIde = "";
            int id = 0;

            
            int numLigne = table.getSelectedRow();
            
            String types = (String) table.getModel().getValueAt(numLigne, 0);
            String dates = (String) table.getModel().getValueAt(numLigne, 2);
             
             
             
            String Sql1 = "Select * from actes WHERE IPP ='" + ipp + "'and type='" + types +"'and idActe ='"+dates+"'";
       
           
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;

            ps = conn.getConnexion().prepareStatement(Sql1);

            ResultSet Rs = ps.executeQuery();;

            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (Rs.next()) {
                
                idIde   = Rs.getString(1);
                id = Integer.decode(idIde);
                String type = Rs.getString(3);
                String observation = Rs.getString(4);
                String date = Rs.getString(5);

                cph.getObservations().setText(observation);
                cph.getDate().setText(dates);
                cph.getType().setText(type);

            }

            String Sql2 = "Select * from ide WHERE idIDE = '" + id + "'";
            PreparedStatement ps2;

            ps2 = conn.getConnexion().prepareStatement(Sql2);

            ResultSet Rs2 = ps2.executeQuery();;

            ResultSetMetaData rsmd2 = Rs2.getMetaData();
            int columnsNumber2 = rsmd2.getColumnCount();

            while (Rs2.next()) {

                String nom = Rs2.getString(3);
                String prenom = Rs2.getString(4);
                

                cph.getNomide().setText(nom);
                cph.getPrenomide().setText(prenom);

               
            }
            
            
            fen.panelVisibleFalse();
            fen.add(cph);
            cph.setVisible(true);
            fen.revalidate();
            fen.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(TableauActesInfirmiersInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
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
