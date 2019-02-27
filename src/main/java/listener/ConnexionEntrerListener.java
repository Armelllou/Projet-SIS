/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;


import main.java.bd.ConnexionBD;
import main.java.interfaces.*;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionEntrerListener implements KeyListener {

    Connexion c;
    JPanel jp;
    Fenetre jframe;
    BarreDuHaut bh;
    ConnexionBD conn = ConnexionBD.getInstance();
    ConsulterDPIPHetIDE cdpiphetide;
    ConsulterDPISecretaire as;
    Prestations p;

    public ConnexionEntrerListener(BarreDuHaut bh, Connexion c, ConsulterDPISecretaire as, ConsulterDPIPHetIDE cdpiphetide, Prestations p, Fenetre jframe) {
        this.bh = bh;
        this.c = c;
        this.jframe = jframe;
        this.jp = jp;
        this.cdpiphetide = cdpiphetide;
        this.as = as;
        this.p = p;

    }

    public void connexion() throws SQLException {
        connexionSecretaire();
        ConnexionIde();
        ConnexionPH();
        ConnexionMedicoTechniques();
    }

    public boolean ConnexionPH() throws SQLException {
        boolean j = false;
        String nom = " ";
        String prenom = " ";
        String service = " ";
        String id = "";
        String mdp = "";

        String sql1 = "Select * from praticienhospitaliers WHERE idPh ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = rs.getString(1);
            mdp = rs.getString(2);
            nom = rs.getString(3);
            prenom = rs.getString(4);
            service = rs.getString(5);
            String Total = nom + " " + prenom + " " + service;

            System.out.print(Total);
            //JOptionPane.showMessageDialog(null, "Correct");
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();
            ConsulterDPIPHetIDE cdpiphetide = new ConsulterDPIPHetIDE();
            jframe.add(cdpiphetide, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);
            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(nom);
            bh.getPrenom().setText(prenom);
            bh.getService().setText(service);
            bh.setVisible(true);
            cdpiphetide.setVisible(true);
            bh.getId().setVisible(false);
            bh.getMdp().setVisible(false);

//            cdpiphetide.getjTable1().TableauSecretaire();
            jframe.revalidate();
            jframe.repaint();

            j = true;
        } else {
            // JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;
    }

    public boolean ConnexionIde() throws SQLException {
        boolean j = false;
        String nom = " ";
        String prenom = " ";
        String service = " ";
        String id = "";
        String mdp = "";

        String sql1 = "Select * from ide WHERE idIDE ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            id = rs.getString(1);
            mdp = rs.getString(2);
            nom = rs.getString(3);
            prenom = rs.getString(4);
            service = rs.getString(5);
            String Total = nom + " " + prenom + " " + service;

            System.out.print(Total);
//                

            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();

            jframe.add(cdpiphetide, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(nom);
            bh.getPrenom().setText(prenom);
            bh.getService().setText(service);
            bh.setVisible(true);
            cdpiphetide.setVisible(true);
            bh.getId().setVisible(false);
            bh.getMdp().setVisible(false);
            jframe.revalidate();
            jframe.repaint();

            j = true;

        } else {
            // JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;

    }

    public boolean connexionSecretaire() throws SQLException {
        boolean j = false;
        String nom = " ";
        String prenom = " ";
        String service = " ";
        String id = "";
        String mdp = "";

        String sql2 = "Select * from secretaireadministrative WHERE idSA ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps2 = conn.getConnexion().prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();

        if (rs2.next()) {
            ResultSetMetaData rsmd = rs2.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = rs2.getString(1);
            mdp = rs2.getString(2);
            nom = rs2.getString(3);
            prenom = rs2.getString(4);
            service = rs2.getString(5);
            String Total = nom + " " + prenom + " " + service;

            System.out.print(Total);
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();

            jframe.add(as, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(nom);
            bh.getPrenom().setText(prenom);
            bh.getService().setText(service);
            bh.setVisible(true);
            as.setVisible(true);
            bh.getId().setVisible(false);
            bh.getMdp().setVisible(false);

            jframe.revalidate();
            jframe.repaint();

            j = true;

        } else {
            //JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;

    }

    public boolean ConnexionMedicoTechniques() throws SQLException {
        boolean j = false;
        String nom = " ";
        String prenom = " ";
        String service = " ";
        String id = "";
        String mdp = "";

        String sql1 = "Select * from medicoTechniques WHERE idMT ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = rs.getString(1);
            mdp = rs.getString(2);
            nom = rs.getString(3);
            prenom = rs.getString(4);

            String Total = nom + " " + prenom + " " + service;

            System.out.print(Total);
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());
            jframe.PanelVisibleFalse();
            jframe.add(p, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);
            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(nom);
            bh.getPrenom().setText(prenom);
            bh.getService().setText(" ");
            bh.setVisible(true);
            p.setVisible(true);
            bh.getId().setVisible(false);
            bh.getMdp().setVisible(false);
            jframe.revalidate();
            jframe.repaint();

            j = true;

        } else {
            // JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }
        return j;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                connexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConnexionEntrerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
