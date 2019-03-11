/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.BarreDuHaut;
import interfaces.DetailsPrestation;
import interfaces.DetailsResultats;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import interfaces.Resultat;
import java.awt.Font;
import nf.Sih;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.GroupLayout.Alignment.CENTER;

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
            String NomPatient = (String) table.getModel().getValueAt(numLigne, 0);
            String PrenomPatient = (String) table.getModel().getValueAt(numLigne, 1);
            String IPP = (String) table.getModel().getValueAt(numLigne, 2);
            String Service = (String) table.getModel().getValueAt(numLigne, 4);
            String Date = (String) table.getModel().getValueAt(numLigne, 5);
            String NomMedecin = "";
            String PrenomMedecin = "";
            String LabelMedecin = "";
            String details = "";
            int idTech = 0;

            String Sql1 = "Select * from prestationsfaites WHERE DateEffectuee ='" + Date + "'";
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement ps;
            ps = conn.getConnexion().prepareStatement(Sql1);
            ResultSet Rs = ps.executeQuery();;
            ResultSetMetaData rsmd = Rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (Rs.next()) {

                NomMedecin = Rs.getString(7);
                PrenomMedecin = Rs.getString(8);
                LabelMedecin = Rs.getString(7) + " " + Rs.getString(8);
                details = Rs.getString(4);
                idTech = Integer.parseInt(Rs.getString(9));

                pf.getPrenomPatient().setText(PrenomPatient);
                pf.getNomPatient().setText(NomPatient);
                pf.getNomMedecin().setText(LabelMedecin);
                pf.getResultats().setText(details);
                pf.getResultats().setEditable(false);
                pf.getIpp().setText(IPP);
                pf.getType().setText("MedicoTechnicien");
                pf.getBoutonValider().setVisible(false);
                pf.getBoutonAnnuler().setText("Retour");
            

            

            PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from prestationsfaites WHERE DateEffectuee ='" + Date + "'");
            prep2.executeUpdate();

            String sql = " INSERT INTO ResultatsLus (ServiceDemandeur,NomPatient,IPP,NomMedicoTech,PrenomMedicotehc,idTECH,Resultats,DateEffectuee) VALUES(?,?,?,?,?,?,?,?) ";
            PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
            statement.setObject(1, Service, Types.VARCHAR);
            statement.setObject(2, NomPatient, Types.VARCHAR);
            statement.setObject(3, IPP, Types.VARCHAR);
            statement.setObject(4, NomMedecin, Types.VARCHAR);
            statement.setObject(5, PrenomMedecin, Types.VARCHAR);
            statement.setObject(6, idTech, Types.INTEGER);
            statement.setObject(7, details, Types.VARCHAR);
            statement.setObject(8, Date, Types.VARCHAR);
            statement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(affichageResultats.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fen.panelVisibleFalse();
            fen.add(pf);
            pf.setVisible(true);
            fen.revalidate();
            fen.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
