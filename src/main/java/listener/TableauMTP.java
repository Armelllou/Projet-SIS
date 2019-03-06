/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author annel
 */
public class TableauMTP implements MouseListener {
     Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public TableauMTP(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp, JTable table) {
      
        
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
        this.table = table;
        
    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
         try {
             int NumLigne = table.getSelectedRow();
        
             String idMT = (String) table.getModel().getValueAt(NumLigne, 2);
             String Sql1 = "Select * from medicotechniques WHERE idMt ='" + idMT+"'";
             ConnexionBD conn = ConnexionBD.getInstance();
             PreparedStatement ps;
             
             ps = conn.getConnexion().prepareStatement(Sql1);
             
             ResultSet Rs = ps.executeQuery();;
             
             ResultSetMetaData rsmd = Rs.getMetaData();
             int columnsNumber = rsmd.getColumnCount();
             while (Rs.next()) {
                 
                 
                 String id = Rs.getString(1);
                 String mdp = Rs.getString(2);
                 String Nom = Rs.getString(3);
                 String Prenom = Rs.getString(4);
                 String Service = Rs.getString(5);
                 
                 
                 mp.getPrénom().setText(Prenom);
                 mp.getNom().setText(Nom);
                 mp.getId().setText(id);
                 mp.getMdp().setText(mdp);
                 mp.getType().setSelectedItem("medicotechniques");
                   mp.getType().setEnabled(false);
                 
                 
                 fen.panelVisibleFalse();
                 fen.add(mp);
                 mp.setVisible(true);
                 fen.revalidate();
                 fen.repaint();
                 
                 mp.getService().setVisible(false);
                 mp.getjLabel7().setVisible(false);
             }
            } catch (SQLException ex) {
             Logger.getLogger(TableauMTP.class.getName()).log(Level.SEVERE, null, ex);
         } } 
         
         
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
             
         }  } 

