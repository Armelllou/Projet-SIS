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
            int numLigne = table.getSelectedRow();

            String nomDeNaissance = (String) table.getModel().getValueAt(numLigne, 0);
            String nomUsuel = (String) table.getModel().getValueAt(numLigne, 1);
            String prenom = (String) table.getModel().getValueAt(numLigne, 2);
            String ipp = (String) table.getModel().getValueAt(numLigne, 3);
            int ippS = Integer.parseInt(ipp);

            dpis.getjLabelnom().setText(nomDeNaissance);
            dpis.getjLabelnom1().setText(nomUsuel);
            dpis.getjLabelprenom().setText(prenom);
            dpis.getjLabelipp().setText(ipp);

            String sql1 = "Select * from Patient WHERE IPP ='" + ipp + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;

            ps = conn.getConnexion().prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {

                String dateDeNaissance = rs.getString(5);

                String sexe = rs.getString(6);
                String medecinG = rs.getString(7);
                String adresse = rs.getString(8);
                String numSS = rs.getString(9);
                String email = rs.getString(10);
                String telephone = rs.getString(11);

                dpis.getjLabeladresse().setText(adresse);
                dpis.getjLabelnumsecu().setText(numSS);
                dpis.getjLabelemail().setText(email);
                dpis.getjLabeltelephone().setText(telephone);
                dpis.getjLabelannée().setText(dateDeNaissance);
                dpis.getSexe().setText(sexe);

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

                fen.panelVisibleFalse();
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
