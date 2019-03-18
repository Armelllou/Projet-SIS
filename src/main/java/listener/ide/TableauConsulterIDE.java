/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import bd.ConnexionBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPIIDE;
import interfaces.DPIPH;
import interfaces.Fenetre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import listener.commun.ListenerConnexion;
import nf.Sih;

/**
 *
 * @author annel
 */
public class TableauConsulterIDE implements MouseListener{

    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;
    Fenetre fen;
    Sih sih;
    JTable table;
    ListenerConnexion conn;
    
    
    public TableauConsulterIDE(DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imide = imide;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
        this.conn = conn;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            int NumLigne = table.getSelectedRow();
            
            
            if (conn.ConnexionIde() == true) {

                String nomDeNaissance = (String) table.getModel().getValueAt(NumLigne, 0);
                String nomUsuel = (String) table.getModel().getValueAt(NumLigne, 1);
                String prenom = (String) table.getModel().getValueAt(NumLigne, 2);
                String ipp = (String) table.getModel().getValueAt(NumLigne, 3);

                imide.getjLabelnom().setText(nomDeNaissance);
                imide.getjLabelnom1().setText(nomUsuel);
                imide.getjLabelprenom().setText(prenom);
                imide.getjLabelipp().setText(ipp);

                String Sql1 = "Select * from patient WHERE IPP ='" + ipp + "'";
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement ps;

                ps = conn.getConnexion().prepareStatement(Sql1);

                ResultSet rs = ps.executeQuery();


                while (rs.next()) {

                    String DateDeNaissance = rs.getString(5);

                    String Sexe = rs.getString(6);
                    String MedecinG = rs.getString(7);
                    String Adresse = rs.getString(8);
                    String NumSS = rs.getString(9);
                    String email = rs.getString(10);
                    String telephone = rs.getString(11);

                    imide.getjLabeladresse().setText(Adresse);
                    imide.getjLabelnumsecu().setText(NumSS);
                    imide.getjLabelemail().setText(email);
                    imide.getjLabeltelephone().setText(telephone);
                    imide.getjLabelannée().setText(DateDeNaissance);
                    imide.getSexe().setText(Sexe);

                }

                String Sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
                PreparedStatement ps2;

                ps2 = conn.getConnexion().prepareStatement(Sql2);

                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {

                    String ServiceGegraphique = rs2.getString(2);
                    String ServiceRespo = rs2.getString(3);
                    String chambre = rs2.getString(4);

                    imide.getServiceRespo().setText(ServiceRespo);
                    imide.getServiceGeo().setText(ServiceGegraphique);

                    imide.getjLabelchamnre().setText(chambre);

                    fen.panelVisibleFalse();
                    fen.add(imide);
                    imide.setVisible(true);
                    fen.revalidate();
                    fen.repaint();
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterIDE.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
