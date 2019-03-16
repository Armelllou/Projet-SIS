/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ActeInfirmier;
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
import listener.commun.RafraichitLesPanels;
import listener.ide.TableauActesInfirmiersInfosMedIDE;

public class TableauActesInfirmiersInfosMedPH implements MouseListener {


    InfosMedicalesPH imph;
    ActeInfirmier cph;
    Fenetre fen;
  
    JTable table;

    public TableauActesInfirmiersInfosMedPH(InfosMedicalesPH imph, ActeInfirmier cph, Fenetre fen, JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;
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
             
             
             
            String Sql1 = "Select * from actes WHERE IPP ='" + ipp + "'and type='" + types +"'and Date ='"+dates+"'";
       
           
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
                cph.getDate1().setText(dates);
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
                

                cph.getNomide1().setText(nom);
                cph.getPrenomide1().setText(prenom);

               
            }
            
            
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,cph);
        } catch (SQLException ex) {
            Logger.getLogger(TableauActesInfirmiersInfosMedPH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
