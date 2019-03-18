/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.ConnexionBD;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import interfaces.PrescriptionPH;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.RafraichitLesPanels;
import listener.ide.TableauActesInfirmiersInfosMedIDE;

import static bd.MethodeBD.executeQuery;


public class TableauPrescriptionsInfosMedPH implements MouseListener {


    InfosMedicalesPH imph;
    PrescriptionPH cph;
    Fenetre fen;

    JTable table;

    public TableauPrescriptionsInfosMedPH(InfosMedicalesPH imph, PrescriptionPH cph, Fenetre fen,  JTable table) {
        this.imph = imph;
        this.cph = cph;
        this.fen = fen;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       try {
            String ipp = imph.getjLabelipp().getText();
            String idIde = null;
            int id = 0;

            
            int numLigne = table.getSelectedRow();
            
            String types = (String) table.getModel().getValueAt(numLigne, 0);
            String Nom =(String) table.getModel().getValueAt(numLigne, 1);
            String dates = (String) table.getModel().getValueAt(numLigne, 2);



            ResultSet rs = executeQuery("Select * from prescription WHERE IPP ='" + ipp + "'and Type='" + types +"'and Date ='"+dates+"'");

            while (rs.next()) {

                String observation = rs.getString(5);
                cph.getDetail().setText(observation);
                cph.getDATE().setText(dates);
                cph.getNom().setText(Nom);

            }

         
            
             RafraichitLesPanels rf = new RafraichitLesPanels(fen,cph);
         
        } catch (SQLException ex) {
            Logger.getLogger(TableauActesInfirmiersInfosMedIDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}
