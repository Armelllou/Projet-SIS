/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.ModificationDPI;
import interfaces.DPISecretaire;
import listener.secretairemedical.TableauConsulterDPISecretaire;
import nf.Sih;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manon
 */
public class BoutonValiderModificationDPI implements ActionListener {

    DPISecretaire dpis;
    ModificationDPI mdpi;
    Fenetre jframe;
    Sih sih;

    public BoutonValiderModificationDPI(Fenetre jframe, DPISecretaire dpis, ModificationDPI mdpi, Sih sih) {
        this.jframe = jframe;
        this.mdpi = mdpi;
        this.dpis = dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String ipp = mdpi.getjLabel3().getText();
            // String SQL = "UPDATE patient SET Prénom '" + mdpi.getPrenom().getText() + "' WHERE CODE = '" + ipp + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE patient SET NomDeNaissance= ?, NomUsuel= ?, Prénom = ?,DateDeNaissance= ?,Sexe= ?,idAdresse= ?,NumDeSS= ?,email= ?,telephone= ? WHERE ipp = ?");
            prep2.setString(1, mdpi.getNomDenaissance().getText());
            prep2.setString(2, mdpi.getNomUsuel().getText());
            prep2.setString(3, mdpi.getPrenom().getText());
            prep2.setString(4, mdpi.getDateDeNaissance().getText());
            prep2.setString(5, mdpi.getSexe().getSelectedItem().toString());
            prep2.setString(6, mdpi.getAdresse().getText());
            prep2.setString(7, mdpi.getNumSS().getText());
            prep2.setString(8, mdpi.getEmail().getText());
            prep2.setString(9, mdpi.getTel().getText());
            prep2.setString(10, ipp);
            prep2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderModificationDPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ConnexionBD conn = ConnexionBD.getInstance();
            String ipp = mdpi.getjLabel3().getText();
            PreparedStatement prep = conn.getConnexion().prepareStatement("UPDATE localisations SET ServiceResponsable= ?, ServiceGeographique= ?, lit=? WHERE ipp = ?");
            prep.setString(1, mdpi.getServicerespo().getSelectedItem().toString());
            prep.setString(2, mdpi.getServicegeo().getSelectedItem().toString());
            prep.setString(3, mdpi.getChambre().getText());
            prep.setString(4, ipp);
            prep.executeUpdate();

            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Informations correctement modifiées", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderModificationDPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String ipp = mdpi.getjLabel3().getText();
            String sql1 = "Select * from Patient WHERE IPP ='" + ipp + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;
            ps = conn.getConnexion().prepareStatement(sql1);
            ResultSet Rs = ps.executeQuery();

            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (Rs.next()) {
                String ipps = Rs.getString(1);
                String nomDeNaissance = Rs.getString(2);
                String nomUsuel = Rs.getString(3);
                String prenom = Rs.getString(4);
                String DateDeNaissance = Rs.getString(5);
                String Sexe = Rs.getString(6);
                String MedecinG = Rs.getString(7);
                String Adresse = Rs.getString(8);
                String NumSS = Rs.getString(9);
                String email = Rs.getString(10);
                String telephone = Rs.getString(11);

                dpis.getjLabelnom().setText(nomDeNaissance);
                dpis.getjLabelnom1().setText(nomUsuel);
                dpis.getjLabelprenom().setText(prenom);
                dpis.getjLabelipp().setText(ipps);
                dpis.getjLabeladresse().setText(Adresse);
                dpis.getjLabelnumsecu().setText(NumSS);
                dpis.getjLabelemail().setText(email);
                dpis.getjLabeltelephone().setText(telephone);
                dpis.getjLabelannée().setText(DateDeNaissance);
                dpis.getSexe().setText(Sexe);

            }

            String sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
            PreparedStatement ps2;

            ps2 = conn.getConnexion().prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            int columnsNumber2 = rsmd2.getColumnCount();

            while (rs2.next()) {

                String serviceGeographique = rs2.getString(2);
                String serviceRespo = rs2.getString(3);
                String chambre = rs2.getString(4);

                dpis.getSereviceRespo().setText(serviceRespo);
                dpis.getServiceGeo().setText(serviceGeographique);
                dpis.getjLabelchamnre().setText(chambre);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPISecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }

        jframe.panelVisibleFalse();
        jframe.add(dpis);
        dpis.setVisible(true);
        jframe.revalidate();
        jframe.repaint();

    }

}
