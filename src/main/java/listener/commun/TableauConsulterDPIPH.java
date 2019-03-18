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


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static bd.MethodeBD.executeQuery;

public class TableauConsulterDPIPH implements MouseListener {

    DPIPH imph;
    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;

    Fenetre fen;
  

    JTable table;
    ListenerConnexion conn;

    public TableauConsulterDPIPH(DPIPH imph, DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imph = imph;
        this.imide = imide;
        this.fen = fen;
     
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


                ResultSet rs = executeQuery("Select * from patient WHERE IPP ='" + ipp + "'");


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

                    ResultSet rs23 = executeQuery("Select * from hospitalisation WHERE IPP = '" + ipp + "'");

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

                    ResultSet rs24 = executeQuery("Select * from consultationexterne WHERE IPP = '" + ipp + "'");

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


                ResultSet rs2 = executeQuery("Select * from localisations WHERE IPP = '" + ipp + "'");


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
        finally {
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
