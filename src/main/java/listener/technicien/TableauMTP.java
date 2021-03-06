/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import listener.commun.RafraichitLesPanels;
import static bd.MethodeBD.executeQuery;


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
             ResultSet rs = executeQuery("Select * from medicotechniques WHERE idMt ='" + idMT+"'");

             while (rs.next()) {
                 
                 
                 String id = rs.getString(1);
                 String mdp = rs.getString(2);
                 String Nom = rs.getString(3);
                 String Prenom = rs.getString(4);
                 
                 mp.getPrénom().setText(Prenom);
                 mp.getNom().setText(Nom);
                 mp.getId().setText(id);
                 mp.getMdp().setText(mdp);
                 mp.getType().setSelectedItem("medicotechniques");
                 mp.getType().setEnabled(false);
                 
                 
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,mp); 
                 
                 mp.getService().setVisible(false);
                 mp.getjLabel7().setVisible(false);
             }
            } catch (SQLException ex) {
             Logger.getLogger(TableauMTP.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
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
             
         }  } 

