/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import interfaces.ModificationDPI;
import listener.secretairemedical.TableauConsulterDPISecretaire;
import nf.Sih;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


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

        ConnexionBD conn = ConnexionBD.getInstance();
        try {
            String ipp = mdpi.getjLabel3().getText();
            String dateSortie = mdpi.getJoursortie().getText() + mdpi.getMoissortie().getText() + mdpi.getAnneesortie().getText();
            PreparedStatement prep2;
            prep2 = conn.getConnexion().prepareStatement("UPDATE patient SET NomDeNaissance= ?, NomUsuel= ?, Prénom = ?,DateDeNaissance= ?,Sexe= ?,idAdresse= ?,NumDeSS= ?,email= ?,telephone= ?,typeSejour= ? WHERE ipp = ?");
            prep2.setString(1, mdpi.getNomDenaissance().getText());
            prep2.setString(2, mdpi.getNomUsuel().getText());
            prep2.setString(3, mdpi.getPrenom().getText());
            prep2.setString(4, mdpi.getDateDeNaissance().getText());
            prep2.setString(5, mdpi.getSexe().getSelectedItem().toString());
            prep2.setString(6, mdpi.getAdresse().getText());
            prep2.setString(7, mdpi.getNumSS().getText());
            prep2.setString(8, mdpi.getEmail().getText());
            prep2.setString(9, mdpi.getTel().getText());
            prep2.setString(10, mdpi.getTypesejour().getSelectedItem().toString());
            prep2.setString(11, ipp);
            prep2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderModificationDPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //-------------------------------------------------------Update localisation -----------------------
        try {
            conn = ConnexionBD.getInstance();
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

        //------------------------------

        try {
            String ipp = mdpi.getjLabel3().getText();
            String sql1 = "Select * from patient WHERE IPP ='" + ipp + "'";
            PreparedStatement ps;
            ps = conn.getConnexion().prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                String ipps = rs.getString(1);
                String nomDeNaissance = rs.getString(2);
                String nomUsuel = rs.getString(3);
                String prenom = rs.getString(4);
                String DateDeNaissance = rs.getString(5);
                String Sexe = rs.getString(6);
                String MedecinG = rs.getString(7);
                String Adresse = rs.getString(8);
                String NumSS = rs.getString(9);
                String email = rs.getString(10);
                String telephone = rs.getString(11);
                String typeSejour = rs.getString("typeSejour");


//------------------changement de table pour un changement de type de sejour
                if (typeSejour.equals("Hospitalisation") && !dpis.getTypeDeSejour().getText().equals(mdpi.getTypesejour().getSelectedItem().toString())) {

                    ipp = mdpi.getjLabel3().getText();
                    String sql3 = "Select * from consultationexterne WHERE IPP ='" + ipp + "'";
                    PreparedStatement ps3;
                    ps3 = conn.getConnexion().prepareStatement(sql3);
                    ResultSet rs3 = ps3.executeQuery();
                    PreparedStatement prep3 = conn.getConnexion().prepareStatement("UPDATE patient SET typeSejour= ? WHERE ipp = ?");
                    prep3.setString(1, mdpi.getTypesejour().getSelectedItem().toString());
                    prep3.setString(2, ipp);
                    prep3.executeUpdate();

                    while (rs3.next()) {
                        String dateEntree = rs3.getString("dateEntreeC");
                        String dateSortie = rs3.getString("dateSortieC");
                        //suppression dans hospitalisation
                        PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from consultationexterne WHERE IPP ='" + ipp + "'");
                        prep2.executeUpdate();

                        //transfert des données en Consultation externe
                        String sql = " INSERT INTO hospitalisation (IPP, dateEntreeH,dateSortieH) VALUES(?,?,?) ";
                        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
                        statement.setObject(1, ipp, Types.INTEGER);
                        statement.setObject(2, dateEntree, Types.DATE);
                        statement.setObject(3, dateSortie, Types.DATE);

                        statement.executeUpdate();

                    }
                } else {
                    ipp = mdpi.getjLabel3().getText();
                    String sql2 = "Select * from hospitalisation WHERE IPP ='" + ipp + "'";
                    PreparedStatement ps2;
                    ps2 = conn.getConnexion().prepareStatement(sql2);
                    ResultSet rs2 = ps2.executeQuery();

                    PreparedStatement prep3 = conn.getConnexion().prepareStatement("UPDATE patient SET typeSejour= ? WHERE ipp = ?");
                    prep3.setString(1, mdpi.getTypesejour().getSelectedItem().toString());
                    prep3.setString(2, ipp);
                    prep3.executeUpdate();


                    while (rs2.next()) {
                        String dateEntree = rs2.getString("dateEntreeH");
                        String dateSortie = rs2.getString("dateSortieH");
                        //suppression dans hospitalisation
                        PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from hospitalisation WHERE IPP ='" + ipp + "'");
                        prep2.executeUpdate();

                        //transfert des données en Consultation externe
                        String sql = " INSERT INTO consultationexterne (IPP, dateEntreeC,dateSortieC) VALUES(?,?,?) ";
                        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
                        statement.setObject(1, ipp, Types.INTEGER);
                        statement.setObject(2, dateEntree, Types.DATE);
                        statement.setObject(3, dateSortie, Types.DATE);

                        statement.executeUpdate();

                    }

                }



////-----------------------------------marche pas-----------------
//
//                String dateSortie = mdpi.getJoursortie().getText() + mdpi.getMoissortie().getText() + mdpi.getAnneesortie().getText();
//
//                if (typeSejour.equals("Hospitalisation") && mdpi.getEtatsejour().toString().equals("Terminé")) {
//
//                    System.out.println("test1");
//
//                    String format = "dd/MM/yy";
//                    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
//                    java.util.Date date = new java.util.Date();
//
//                    String sql = " UPDATE hospitalisation SET dateSortieH=? WHERE IPP = ?";
//                    PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
//                    statement.setObject(1, date, Types.DATE);
//                    dpis.getDatesortie().setText(dateSortie);
//
//                    String s = " UPDATE patient SET etat=? WHERE IPP = ?";
//                    PreparedStatement statement1 = conn.getConnexion().prepareStatement(s);
//                    statement1.setObject(1, "Terminé", Types.VARCHAR);
//                    dpis.getEtat().setText("Terminé");
//                }
//
//                if (typeSejour.equals("Consultation externe") && mdpi.getEtatsejour().equals("Terminé")) {
//
//                    System.out.println("test2");
//
//                    String format = "dd/MM/yy";
//                    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
//                    java.util.Date date = new java.util.Date();
//
//                    String sql = " UPDATE consultationexterne SET dateSortieC=? WHERE IPP = ?";
//                    PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
//                    statement.setObject(1, date, Types.DATE);
//                    dpis.getDatesortie().setText(dateSortie);
//
//                    String s = " UPDATE patient SET etat=? WHERE IPP = ?";
//                    PreparedStatement statement1 = conn.getConnexion().prepareStatement(s);
//                    statement1.setObject(1, "Terminé", Types.VARCHAR);
//                    dpis.getEtat().setText("Terminé");
//                }
////-----------------------------------marche pas-----------------

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
                dpis.getTypeDeSejour().setText(typeSejour);

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
