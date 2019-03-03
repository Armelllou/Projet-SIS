/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.Fenetre;
import interfaces.DPIIDE;
import interfaces.DPIPH;
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

public class TableauConsulterDPIPHetIDE implements MouseListener {

    DPIPH imph;
    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;

    Fenetre fen;
    Sih sih;;

    JTable table;
    ListenerConnexion conn;

    public TableauConsulterDPIPHetIDE(DPIPH imph, DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imph = imph;
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
            
            
            if (conn.ConnexionPH() == true) {

                String nomDeNaissance = (String) table.getModel().getValueAt(NumLigne, 0);
                String nomUsuel = (String) table.getModel().getValueAt(NumLigne, 1);
                String prenom = (String) table.getModel().getValueAt(NumLigne, 2);
                String ipp = (String) table.getModel().getValueAt(NumLigne, 3);
                int ippS = Integer.parseInt(ipp);

                imph.getjLabelnom().setText(nomDeNaissance);
                imph.getjLabelnom1().setText(nomUsuel);
                imph.getjLabelprenom().setText(prenom);
                imph.getjLabelipp().setText(ipp);

                String Sql1 = "Select * from patient WHERE IPP ='" + ipp + "'";
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement ps;

                ps = conn.getConnexion().prepareStatement(Sql1);

                ResultSet Rs = ps.executeQuery();;

                ResultSetMetaData rsmd = Rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (Rs.next()) {

                    String DateDeNaissance = Rs.getString(5);

                    String Sexe = Rs.getString(6);
                    String MedecinG = Rs.getString(7);
                    String Adresse = Rs.getString(8);
                    String NumSS = Rs.getString(9);
                    String email = Rs.getString(10);
                    String telephone = Rs.getString(11);

                    imph.getjLabeladresse().setText(Adresse);
                    imph.getjLabelnumsecu().setText(NumSS);
                    imph.getjLabelemail().setText(email);
                    imph.getjLabeltelephone().setText(telephone);
                    imph.getjLabelannée().setText(DateDeNaissance);
                    imph.getSexe().setText(Sexe);

                }

                String Sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
                PreparedStatement ps2;

                ps2 = conn.getConnexion().prepareStatement(Sql2);

                ResultSet Rs2 = ps2.executeQuery();;

                ResultSetMetaData rsmd2 = Rs2.getMetaData();
                int columnsNumber2 = rsmd2.getColumnCount();

                while (Rs2.next()) {

                    String ServiceGegraphique = Rs2.getString(2);
                    String ServiceRespo = Rs2.getString(3);
                    String chambre = Rs2.getString(4);

                    imph.getServiceRespo().setText(ServiceRespo);
                    imph.getServiceGeo().setText(ServiceGegraphique);

                    imph.getjLabelchamnre().setText(chambre);

                    fen.panelVisibleFalse();
                    fen.add(imph);
                    imph.setVisible(true);
                    fen.revalidate();
                    fen.repaint();
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPIPHetIDE.class.getName()).log(Level.SEVERE, null, ex);
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
