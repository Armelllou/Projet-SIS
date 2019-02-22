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
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public abstract class ListenerConnexion {

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

    public void ConnexionPH() throws SQLException {
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
        } else {
            // JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur inconnu");
        }

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
           
//            
//            String Sql1 = "Select * from patient";
//            PreparedStatement ps;
//            ps = conn.getConnexion().prepareStatement(Sql1);
//            ResultSet resultSet = ps.executeQuery();
//       
//
//            String col[] = {"IPP", "Nom de Naissance", "Nom Usuel ", "Prenom"};
//            String cont[][] = new String[5000][4];
//            int i = 0;
//            while (resultSet.next()) {
//                int idz = resultSet.getInt("IPP");
//                String nomDN = resultSet.getString("NomDeNaissance");
//                String nomUsuel = resultSet.getString("NomUsuel");
//                String prenom = resultSet.getString("prénom");
//                cont[i][0] = id + "";
//                cont[i][1] = nomDN;
//                cont[i][2] = nomUsuel;
//                cont[i][3] = prenom;
//                i++;
//            }
//            DefaultTableModel model = new DefaultTableModel(cont, col);
//            JTable table = new JTable(model);
//            jframe.add(table,BorderLayout.CENTER);
//            table.setShowGrid(true);
//            table.setShowVerticalLines(true);

            
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
}
