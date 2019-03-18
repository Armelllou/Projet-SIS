/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.secretairemedical;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ConsulterDPISecretaire;
import interfaces.DPISecretaire;
import nf.Sih;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.RafraichitLesPanels;

/**
 * @author Manon
 */
public class BoutonRetourDPISVersConsulterDPISecretaire implements ActionListener {

    DPISecretaire dpis;
    ConsulterDPISecretaire cdpis;
    Fenetre jframe;
    Sih sih;

    public BoutonRetourDPISVersConsulterDPISecretaire(Fenetre jframe, ConsulterDPISecretaire cdpis, DPISecretaire dpis) {
        this.jframe = jframe;
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.sih = sih;
    }

    public void actionPerformed(ActionEvent ae) {


            MethodeBD.PatientSecretaire(cdpis.getjTable1());


           RafraichitLesPanels rf = new RafraichitLesPanels(jframe,cdpis);
    }

}
