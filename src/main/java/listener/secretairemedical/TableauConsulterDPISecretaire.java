/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.secretairemedical;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ConsulterDPISecretaire;
import interfaces.DPISecretaire;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.RafraichitLesPanels;


public class TableauConsulterDPISecretaire implements MouseListener {

    ConsulterDPISecretaire cdpis;
    DPISecretaire dpis;
    Fenetre fen;

    JTable table;

    public TableauConsulterDPISecretaire(ConsulterDPISecretaire cdpis, DPISecretaire dpis, Fenetre fen, JTable table) {
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.fen = fen;
        this.table = table;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void mouseClicked(MouseEvent me) {

        try {
            int numLigne = table.getSelectedRow();
            String nomDeNaissance = (String) table.getModel().getValueAt(numLigne, 0);
            String nomUsuel = (String) table.getModel().getValueAt(numLigne, 1);
            String prenom = (String) table.getModel().getValueAt(numLigne, 2);
            String ipp = (String) table.getModel().getValueAt(numLigne, 3);
            String typeSejour;
            String etat;


            dpis.getjLabelnom().setText(nomDeNaissance);
            dpis.getjLabelnom1().setText(nomUsuel);
            dpis.getjLabelprenom().setText(prenom);
            dpis.getjLabelipp().setText(ipp);

            String sql1 = "Select * from patient WHERE IPP ='" + ipp + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;
            ps = conn.getConnexion().prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String dateDeNaissance = rs.getString(5);
                String sexe = rs.getString(6);
                String medecinG = rs.getString(7);
                String adresse = rs.getString(8);
                String numSS = rs.getString(9);
                String email = rs.getString(10);
                String telephone = rs.getString(11);
                typeSejour =rs.getString("typeSejour");
                etat = rs.getString("etat");


                dpis.getjLabeladresse().setText(adresse);
                dpis.getjLabelnumsecu().setText(numSS);
                dpis.getjLabelemail().setText(email);
                dpis.getjLabeltelephone().setText(telephone);
                dpis.getjLabelannée().setText(dateDeNaissance);
                dpis.getSexe().setText(sexe);
                dpis.getTypeDeSejour().setText(typeSejour);
                dpis.getEtat().setText(etat);
                String type=typeSejour;



            String sql23 = "Select * from hospitalisation WHERE IPP = '" + ipp + "'";
            PreparedStatement ps23;
            ps23 = conn.getConnexion().prepareStatement(sql23);
            ResultSet rs23 = ps23.executeQuery();

            while (rs23.next()) {
                if (type.equals("Hospitalisation")) {
                    String dateentre = rs23.getString(2);
                    System.out.println(dateentre);
                    dpis.getDateentree().setText(dateentre);
                    String datesortie = rs23.getString(3);
                    System.out.println(datesortie);
                    dpis.getDatesortie().setText(datesortie);

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
                    dpis.getDateentree().setText(dateentre);
                    String datesortie = rs24.getString(3);
                        System.out.println(datesortie);
                    dpis.getDatesortie().setText(datesortie);

                }}

            }


            String sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
            PreparedStatement ps2;
            ps2 = conn.getConnexion().prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();


            while (rs2.next()) {

                String serviceGeographique = rs2.getString(2);
                String serviceRespo = rs2.getString(3);
                String chambre = rs2.getString(4);

                dpis.getServiceRespo().setText(serviceRespo);
                dpis.getServiceGeo().setText(serviceGeographique);

                dpis.getjLabelchamnre().setText(chambre);

             RafraichitLesPanels rf = new RafraichitLesPanels(fen,dpis);
            }


           
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPISecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            }

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
