/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import BD.ConnexionBD;
import interfaces.ConsulterDPISecretaire;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author annel
 */
public class TableauSecretaire implements MouseListener {
    
    
      ConsulterDPISecretaire as;
ConnexionBD conn = new ConnexionBD();
ConsulterDPISecretaire cdpiS;
    public TableauSecretaire(ConsulterDPISecretaire cdpiS) throws SQLException {
        
          this.cdpiS=cdpiS;
      
}

    @Override
    public void mouseClicked(MouseEvent e) {
         String Sql1 = "Select * from patient";
            PreparedStatement ps;
          try {
              ps = conn.getConnexion().prepareStatement(Sql1);
              ResultSet resultSet = ps.executeQuery();
 
      String col[] = { "IPP", "Nom de Naissance", "Nom Usuel ","Prenom" };
      String cont[][] = new String[10][4];
      int i = 0;
      while (resultSet.next()) {
        int id = resultSet.getInt("IPP");
        String nomDN = resultSet.getString("NomDeNaissance");
        String nomUsuel = resultSet.getString("NomUsuel");
            String prenom = resultSet.getString("prénom");
        cont[i][0] = id +"";
        cont[i][1] = nomDN;
         cont[i][2] = nomUsuel;
        cont[i][3] = prenom;
        i++;
      }
      DefaultTableModel model = new DefaultTableModel(cont, col);
      JTable table = cdpiS.getjTable1();
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
   
   
          } catch (SQLException ex) {
              Logger.getLogger(TableauSecretaire.class.getName()).log(Level.SEVERE, null, ex);
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
