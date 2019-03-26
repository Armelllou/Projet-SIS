/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ide;

import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPIIDE;
import interfaces.Fenetre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import listener.commun.ListenerConnexion;
import listener.commun.RafraichitLesPanels;


import static bd.MethodeBD.executeQuery;

/**
 *
 * @author annel
 */
public class TableauConsulterIDE implements MouseListener{

    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;
 Fenetre fen; JTable table;
    ListenerConnexion conn;
    
    
    public TableauConsulterIDE(DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imide = imide;
        this.fen = fen;
      
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


                ResultSet rs = executeQuery("Select * from patient WHERE IPP ='" + ipp + "'");


                while (rs.next()) {

                    String dateDeNaissance = rs.getString(5);

                    String sexe = rs.getString(6);
                    String medecinG = rs.getString(7);
                    String adresse = rs.getString(8);
                    String numSS = rs.getString(9);
                    String email = rs.getString(10);
                    String telephone = rs.getString(11);
                    String etat = rs.getString(13);

                    imide.getjLabeladresse().setText(adresse);
                    imide.getjLabelnumsecu().setText(numSS);
                    imide.getjLabelemail().setText(email);
                    imide.getjLabeltelephone().setText(telephone);
                    imide.getjLabelannée().setText(dateDeNaissance);
                    imide.getSexe().setText(sexe);
                    imide.getEtat().setText(etat);



                    ResultSet rs23 = executeQuery("Select * from hospitalisation WHERE IPP = '" + ipp + "'");

                    while (rs23.next()) {
                        if (rs.getString(12).equals("Hospitalisation")) {
                            String dateentre = rs23.getString(2);
                            System.out.println(dateentre);
                            imide.getDateentree().setText(dateentre);
                            String datesortie = rs23.getString(3);
                            System.out.println(datesortie);
                            imide.getDatesortie().setText(datesortie);

                        }
                    }

                    ResultSet rs24 = executeQuery("Select * from consultationexterne WHERE IPP = '" + ipp + "'");

                    while (rs24.next()) {
                        if (rs.getString(12).equals("Consultation externe")) {
                            String dateentre = rs24.getString(2);
                            System.out.println(dateentre);
                            imide.getDateentree().setText(dateentre);
                            String datesortie = rs24.getString(3);
                            System.out.println(datesortie);
                            imide.getDatesortie().setText(datesortie);

                        }
                    }

                }


                ResultSet rs2 = executeQuery("Select * from localisations WHERE IPP = '" + ipp + "'");

                while (rs2.next()) {

                    String ServiceGegraphique = rs2.getString(2);
                    String ServiceRespo = rs2.getString(3);
                    String chambre = rs2.getString(4);

                    imide.getServiceRespo().setText(ServiceRespo);
                    imide.getServiceGeo().setText(ServiceGegraphique);

                    imide.getjLabelchamnre().setText(chambre);

                    RafraichitLesPanels rf = new RafraichitLesPanels(fen, imide);
                }


            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterIDE.class.getName()).log(Level.SEVERE, null, ex);

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
       
    }
}
