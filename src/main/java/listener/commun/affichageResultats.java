/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import bd.ConnexionBD;

import interfaces.BarreDuHaut;

import interfaces.DetailsResultats;
import interfaces.Fenetre;

import interfaces.Resultat;



import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


public class affichageResultats implements MouseListener {

    DetailsResultats pf;
    Resultat r;
    Fenetre fen;
    JTable table;
    BarreDuHaut bh;

    public affichageResultats(DetailsResultats pf, Resultat r, Fenetre fen, JTable table, BarreDuHaut bh) {
        this.pf = pf;
        this.r = r;
        this.fen = fen;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {

            int numLigne = table.getSelectedRow();
            String nomPatient = (String) table.getModel().getValueAt(numLigne, 0);
            String prenomPatient = (String) table.getModel().getValueAt(numLigne, 1);
            String ipp = (String) table.getModel().getValueAt(numLigne, 2);
            String service = (String) table.getModel().getValueAt(numLigne, 4);
            String date = (String) table.getModel().getValueAt(numLigne, 5);
            String nomMedecin = "";
            String prenomMedecin = "";
            String labelMedecin = "";
            String details = "";
            int idTech = 0;

            String Sql1 = "Select * from prestationsfaites WHERE DateEffectuee ='" + date + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;
            ps = conn.getConnexion().prepareStatement(Sql1);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                nomMedecin = rs.getString(7);
                prenomMedecin = rs.getString(8);
                labelMedecin = rs.getString(7) + " " + rs.getString(8);
                details = rs.getString(4);
                idTech = Integer.parseInt(rs.getString(9));

                pf.getPrenomPatient().setText(prenomPatient);
                pf.getNomPatient().setText(nomPatient);
                pf.getNomMedecin().setText(labelMedecin);
                pf.getResultats().setText(details);
                pf.getResultats().setEditable(false);
                pf.getIpp().setText(ipp);
                pf.getType().setText("MedicoTechnicien");
                pf.getBoutonValider().setVisible(false);
                pf.getBoutonAnnuler().setText("Retour");
                javax.swing.ImageIcon icone = new javax.swing.ImageIcon(getClass().getResource("/interfaces/flcheretour-ConvertImage.png"));
                pf.getBoutonAnnuler().setIcon(icone);
                pf.getBoutonAnnuler().setText("");


            PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from prestationsfaites WHERE DateEffectuee ='" + date + "'");
            prep2.executeUpdate();

            String sql = " INSERT INTO ResultatsLus (ServiceDemandeur,NomPatient,IPP,NomMedicoTech,PrenomMedicotehc,idTECH,Resultats,DateEffectuee,PrenomPatient) VALUES(?,?,?,?,?,?,?,?,?) ";
            PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
            statement.setObject(1, service, Types.VARCHAR);
            statement.setObject(2, nomPatient, Types.VARCHAR);
            statement.setObject(3, ipp, Types.VARCHAR);
            statement.setObject(4, nomMedecin, Types.VARCHAR);
            statement.setObject(5, prenomMedecin, Types.VARCHAR);
            statement.setObject(6, idTech, Types.INTEGER);
            statement.setObject(7, details, Types.VARCHAR);
            statement.setObject(8, date, Types.VARCHAR);
            statement.setObject(9, prenomPatient, Types.VARCHAR);
            statement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(affichageResultats.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
       }
        
          RafraichitLesPanels rf = new RafraichitLesPanels(fen,pf);
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
