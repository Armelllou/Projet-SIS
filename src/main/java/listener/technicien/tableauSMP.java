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
import javax.swing.*;

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
              String sql1 = "Select * from secretaireadministrative WHERE idSA ='" + idSA +"'";
              ConnexionBD conn = ConnexionBD.getInstance();
              PreparedStatement ps;
              
              ps = conn.getConnexion().prepareStatement(sql1);
              
              ResultSet rs = ps.executeQuery();

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
                  mp.getType().setSelectedItem("SecretaireAdministrative");
                  mp.getType().setEnabled(false);
                  
                  
                  fen.panelVisibleFalse();
                  fen.add(mp);
                  mp.setVisible(true);
                  fen.revalidate();
                  fen.repaint();
                  
                  
              }
               } catch (SQLException ex) {
              Logger.getLogger(tableauSMP.class.getName()).log(Level.SEVERE, null, ex);
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
