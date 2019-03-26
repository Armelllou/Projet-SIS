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
public class TableauIdeP implements MouseListener {

    Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public TableauIdeP(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp, JTable table) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
        this.table = table;
    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            int NumLigne = table.getSelectedRow();
            
            String idide = (String) table.getModel().getValueAt(NumLigne, 2);


            ResultSet rs = executeQuery("Select * from ide WHERE idIDE ='" + idide +"'");
            while (rs.next()) {

                
                String id = rs.getString(1);
                String mdp = rs.getString(2);
                String Nom = rs.getString(3);
                String Prenom = rs.getString(4);
                String Service = rs.getString(5);

               
                mp.getPrénom().setText(Prenom);
                mp.getNom().setText(Nom);
                mp.getId().setText(id);
                mp.getMdp().setText(mdp);
                mp.getService().setSelectedItem(Service);
                mp.getType().setSelectedItem("ide");
                mp.getType().setEnabled(false);
                
                
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,mp); 
            }
             } catch (SQLException ex) {
            Logger.getLogger(TableauIdeP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
           
        
        
        
    }@Override
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
