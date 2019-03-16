/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

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

public class TableauConsulterDPIPH implements MouseListener {

    DPIPH imph;
    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;

    Fenetre fen;
    Sih sih;;

    JTable table;
    ListenerConnexion conn;

    public TableauConsulterDPIPH(DPIPH imph, DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
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
                String typeSejour;
                String etat;

                imph.getjLabelnom().setText(nomDeNaissance);
                imph.getjLabelnom1().setText(nomUsuel);
                imph.getjLabelprenom().setText(prenom);
                imph.getjLabelipp().setText(ipp);

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
                    typeSejour =rs.getString("typeSejour");
                    etat = rs.getString("etat");


                    imph.getjLabeladresse().setText(Adresse);
                    imph.getjLabelnumsecu().setText(NumSS);
                    imph.getjLabelemail().setText(email);
                    imph.getjLabeltelephone().setText(telephone);
                    imph.getjLabelannée().setText(DateDeNaissance);
                    imph.getSexe().setText(Sexe);
                    imph.getTypeDeSejour().setText(typeSejour);
                    imph.getEtat().setText(etat);
                    String type=typeSejour;


                    String sql23 = "Select * from hospitalisation WHERE IPP = '" + ipp + "'";
                    PreparedStatement ps23;
                    ps23 = conn.getConnexion().prepareStatement(sql23);
                    ResultSet rs23 = ps23.executeQuery();

                    while (rs23.next()) {
                        if (type.equals("Hospitalisation")) {
                            String dateentre = rs23.getString(2);
                            System.out.println(dateentre);
                            imph.getDateentree().setText(dateentre);
                            String datesortie = rs23.getString(3);
                            System.out.println(datesortie);
                            imph.getDatesortie().setText(datesortie);

                        }
                    }
                    String sql24 = "Select * from consultationexterne WHERE IPP = '" + ipp + "'";
                    PreparedStatement ps24;
                    ps24 = conn.getConnexion().prepareStatement(sql24);
                    ResultSet rs24 = ps24.executeQuery();

                    while (rs24.next()) {
                        if(type.equals("Consultation externe")){
                            String dateentre = rs24.getString(2);
                            System.out.println(dateentre);
                            imph.getDateentree().setText(dateentre);
                            String datesortie = rs24.getString(3);
                            System.out.println(datesortie);
                            imph.getDatesortie().setText(datesortie);

                        }}

                }

                String Sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
                PreparedStatement ps2;
                ps2 = conn.getConnexion().prepareStatement(Sql2);
                ResultSet rs2 = ps2.executeQuery();


                while (rs2.next()) {

                    String ServiceGegraphique = rs2.getString(2);
                    String ServiceRespo = rs2.getString(3);
                    String chambre = rs2.getString(4);

                    imph.getServiceRespo().setText(ServiceRespo);
                    imph.getServiceGeo().setText(ServiceGegraphique);

                    imph.getjLabelchamnre().setText(chambre);

                       RafraichitLesPanels rf = new RafraichitLesPanels(fen,imph);
                }

                fen.repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPIPH.class.getName()).log(Level.SEVERE, null, ex);
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
