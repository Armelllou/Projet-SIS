/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.bd.ConnexionBD;
import main.java.nf.Sih;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;
import main.java.interfaces.secretaire.DPISecretaire;
import main.java.interfaces.Fenetre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Manon
 */
public class TableauConsulterDPISecretaire implements MouseListener {

    ConsulterDPISecretaire cdpis;
    DPISecretaire dpis;
    Fenetre fen;
    Sih sih;
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
            int NumLigne;
            NumLigne = table.getSelectedRow();

            String nomDeNaissance = (String) table.getModel().getValueAt(NumLigne, 0);
            String nomUsuel = (String) table.getModel().getValueAt(NumLigne, 1);
            String prenom = (String) table.getModel().getValueAt(NumLigne, 2);
            String ipp = (String) table.getModel().getValueAt(NumLigne, 3);
            int ippS = Integer.parseInt(ipp);

            dpis.getjLabelnom().setText(nomDeNaissance);
            dpis.getjLabelnom1().setText(nomUsuel);
            dpis.getjLabelprenom().setText(prenom);
            dpis.getjLabelipp().setText(ipp);

            String Sql1 = "Select * from Patient WHERE IPP ='" + ipp + "'";
            ConnexionBD conn = new ConnexionBD();
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

                dpis.getjLabeladresse().setText(Adresse);
                dpis.getjLabelnumsecu().setText(NumSS);
                dpis.getjLabelemail().setText(email);
                dpis.getjLabeltelephone().setText(telephone);
                dpis.getjLabelannée().setText(DateDeNaissance);
                dpis.getSexe().setText(Sexe);

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
          
                dpis.getSereviceRespo().setText(ServiceRespo);
                dpis.getServiceGeo().setText(ServiceGegraphique);

                dpis.getjLabelchamnre().setText(chambre);
               
                fen.PanelVisibleFalse();
                fen.add(dpis);
                dpis.setVisible(true);
                fen.revalidate();

            }

            fen.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPISecretaire.class.getName()).log(Level.SEVERE, null, ex);
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
