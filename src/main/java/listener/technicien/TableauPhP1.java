/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import listener.commun.RafraichitLesPanels;

import static bd.MethodeBD.executeQuery;

/**
 *
 * @author annel
 */
public class TableauPhP1 implements MouseListener {
     Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public TableauPhP1(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp, JTable table) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
        this.table = table;
    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
         try {
             int NumLigne = table.getSelectedRow();

             String idPH = (String) table.getModel().getValueAt(NumLigne, 2);
             
             ResultSet rs = executeQuery("Select * from praticienhospitaliers WHERE idPh ='" + idPH +"'");

             while (rs.next()) {
                 
                 
                 String id = rs.getString(1);
                 String mdp = rs.getString(2);
                 String nom = rs.getString(3);
                 String prenom = rs.getString(4);
                 String service = rs.getString(5);
                 
                 
                 mp.getPrénom().setText(prenom);
                 mp.getNom().setText(nom);
                 mp.getId().setText(id);
                 mp.getMdp().setText(mdp);
                 mp.getService().setSelectedItem(service);
                 mp.getType().setSelectedItem("praticienhospitaliers");
                 mp.getType().setEnabled(false);
                 
               RafraichitLesPanels rf = new RafraichitLesPanels(fen,mp); 
             }
             } catch (SQLException ex) {
             Logger.getLogger(TableauPhP1.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
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
