/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DPIIDE;
import interfaces.Fenetre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import nf.Sih;


public class TableauConsulterIDE implements MouseListener{

    DPIIDE imide;
    ConsulterDPIPHetIDE cdpi;
    Fenetre fen;
    Sih sih;
    JTable table;
    ListenerConnexion conn;
    
    
    public TableauConsulterIDE(DPIIDE imide, ConsulterDPIPHetIDE cdpi, Fenetre fen, JTable table, ListenerConnexion conn) {
        this.imide = imide;
        this.fen = fen;
        this.sih = sih;
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
                String typeSejour;
                String etat;
                int ippS = Integer.parseInt(ipp);

                imide.getjLabelnom().setText(nomDeNaissance);
                imide.getjLabelnom1().setText(nomUsuel);
                imide.getjLabelprenom().setText(prenom);
                imide.getjLabelipp().setText(ipp);

                String Sql1 = "Select * from patient WHERE IPP ='" + ipp + "'";
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement ps;
                ps = conn.getConnexion().prepareStatement(Sql1);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();

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

                    imide.getjLabeladresse().setText(Adresse);
                    imide.getjLabelnumsecu().setText(NumSS);
                    imide.getjLabelemail().setText(email);
                    imide.getjLabeltelephone().setText(telephone);
                    imide.getjLabelannée().setText(DateDeNaissance);
                    imide.getSexe().setText(Sexe);
                    imide.getTypeDeSejour().setText(typeSejour);
                    imide.getEtat().setText(etat);
                    String type=typeSejour;



                String sql23 = "Select * from hospitalisation WHERE IPP = '" + ipp + "'";
                PreparedStatement ps23;
                ps23 = conn.getConnexion().prepareStatement(sql23);
                ResultSet rs23 = ps23.executeQuery();

                while (rs23.next()) {
                    if (type.equals("Hospitalisation")) {
                        String dateentre = rs23.getString(2);
                        System.out.println(dateentre);
                        imide.getDateentree().setText(dateentre);
                        String datesortie = rs23.getString(3);
                        System.out.println(datesortie);
                        imide.getDatesortie().setText(datesortie);

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
                        imide.getDateentree().setText(dateentre);
                        String datesortie = rs24.getString(3);
                        System.out.println(datesortie);
                        imide.getDatesortie().setText(datesortie);

                    }}

            }

                String Sql2 = "Select * from localisations WHERE IPP = '" + ipp + "'";
                PreparedStatement ps2;
                ps2 = conn.getConnexion().prepareStatement(Sql2);
                ResultSet rs2 = ps2.executeQuery();


                while (rs2.next()) {

                    String ServiceGegraphique = rs2.getString(2);
                    String ServiceRespo = rs2.getString(3);
                    String chambre = rs2.getString(4);

                    imide.getServiceRespo().setText(ServiceRespo);
                    imide.getServiceGeo().setText(ServiceGegraphique);

                    imide.getjLabelchamnre().setText(chambre);

                    fen.panelVisibleFalse();
                    fen.add(imide);
                    imide.setVisible(true);
                    fen.revalidate();
                    fen.repaint();
                }

                fen.repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableauConsulterDPIPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
