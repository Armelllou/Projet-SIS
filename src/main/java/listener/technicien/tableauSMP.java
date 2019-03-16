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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import listener.commun.RafraichitLesPanels;

/**
 *
 * @author annel
 */
public class tableauSMP implements MouseListener  {
      Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;
    JTable table;

    public tableauSMP(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp, JTable table) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
        this.table = table;
    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
          try {
              int NumLigne = table.getSelectedRow();
              
              
              
              String idSA = (String) table.getModel().getValueAt(NumLigne, 2);
              String Sql1 = "Select * from secretaireadministrative WHERE idSA ='" + idSA +"'";
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
                  mp.getService().setSelectedItem(Service);
                  mp.getType().setSelectedItem("SecretaireAdministrative");
                    mp.getType().setEnabled(false);
                  
                  
                  RafraichitLesPanels rf = new RafraichitLesPanels(fen,mp); 
                  
                  
                  
              }
               } catch (SQLException ex) {
              Logger.getLogger(tableauSMP.class.getName()).log(Level.SEVERE, null, ex);
          }}
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
