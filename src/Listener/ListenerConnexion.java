/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import BD.ConnexionBD;
import javax.swing.*;
import interfaces.BarreDuHaut;
import interfaces.Connexion;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.ConsulterDPISecretaire;
import interfaces.Fenetre;
import interfaces.Prestations;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ListenerConnexion implements ActionListener {

    Connexion c;
    JPanel jp;
    Fenetre jframe;
    BarreDuHaut bh;

    ConnexionBD conn = new ConnexionBD();
    ConsulterDPIPHetIDE cdpiphetide;
    ConsulterDPISecretaire as;
    Prestations p;

    public ListenerConnexion(BarreDuHaut bh, Connexion c, ConsulterDPISecretaire as, ConsulterDPIPHetIDE cdpiphetide, Prestations p, Fenetre jframe) {
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
        String Nom = " ";
        String Prenom = " ";
        String Service = " ";
        String id = "";
        String mdp = "";

        String Sql1 = "Select * from praticienhospitaliers WHERE idPh ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet Rs = ps.executeQuery();
        if (Rs.next()) {
            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = Rs.getString(1);
            mdp = Rs.getString(2);
            Nom = Rs.getString(3);
            Prenom = Rs.getString(4);
            Service = Rs.getString(5);
            String Total = Nom + " " + Prenom + " " + Service;

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
            bh.getNom().setText(Nom);
            bh.getPrenom().setText(Prenom);
            bh.getService().setText(Service);
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
        String Nom = " ";
        String Prenom = " ";
        String Service = " ";
        String id = "";
        String mdp = "";

        String Sql1 = "Select * from ide WHERE idIDE ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet Rs = ps.executeQuery();

        if (Rs.next()) {
            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            id = Rs.getString(1);
            mdp = Rs.getString(2);
            Nom = Rs.getString(3);
            Prenom = Rs.getString(4);
            Service = Rs.getString(5);
            String Total = Nom + " " + Prenom + " " + Service;

            System.out.print(Total);
//                

            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();

            jframe.add(cdpiphetide, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(Nom);
            bh.getPrenom().setText(Prenom);
            bh.getService().setText(Service);
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
        String Nom = " ";
        String Prenom = " ";
        String Service = " ";
        String id = "";
        String mdp = "";

        String Sql2 = "Select * from secretaireadministrative WHERE idSA ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps2 = conn.getConnexion().prepareStatement(Sql2);
        ResultSet Rs2 = ps2.executeQuery();

        if (Rs2.next()) {
            ResultSetMetaData rsmd = Rs2.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = Rs2.getString(1);
            mdp = Rs2.getString(2);
            Nom = Rs2.getString(3);
            Prenom = Rs2.getString(4);
            Service = Rs2.getString(5);
            String Total = Nom + " " + Prenom + " " + Service;

            System.out.print(Total);
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();

            jframe.add(as, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);

            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(Nom);
            bh.getPrenom().setText(Prenom);
            bh.getService().setText(Service);
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
        String Nom = " ";
        String Prenom = " ";
        String Service = " ";
        String id = "";
        String mdp = "";

        String Sql1 = "Select * from medicoTechniques WHERE idMT ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet Rs = ps.executeQuery();

        if (Rs.next()) {
            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            id = Rs.getString(1);
            mdp = Rs.getString(2);
            Nom = Rs.getString(3);
            Prenom = Rs.getString(4);

            String Total = Nom + " " + Prenom + " " + Service;

            System.out.print(Total);
//                

            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());

            jframe.PanelVisibleFalse();

            jframe.add(p, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);
            bh.getId().setText(id);
            bh.getMdp().setText(mdp);
            bh.getNom().setText(Nom);
            bh.getPrenom().setText(Prenom);
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
    public void actionPerformed(ActionEvent e) {
        try {
            connexion();
                    } catch (SQLException ex) {
            Logger.getLogger(ListenerConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}

 
