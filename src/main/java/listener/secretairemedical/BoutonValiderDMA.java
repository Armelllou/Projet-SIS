/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.secretairemedical;


import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.CreationDPI;
import interfaces.ConsulterDPISecretaire;
import nf.Dates;
import nf.localisation.Localisation;
import nf.patient.Adresse;
import nf.patient.Patient;
import nf.sejour.Hospitalisation;
import nf.sejour.consultation.ConsultExt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listener.commun.RafraichitLesPanels;

public class BoutonValiderDMA implements ActionListener {

    Fenetre fen;
    ConsulterDPISecretaire cdpis;
    CreationDPI cdpi;

    public BoutonValiderDMA(ConsulterDPISecretaire cdpis, Fenetre jframe, CreationDPI cdpi) {
        this.fen = jframe;
        this.cdpis = cdpis;
        this.cdpi = cdpi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Patient p = new Patient(cdpi.getNomdeNaissance().getText(), cdpi.getNom().getText(), new Dates(cdpi.getJour().getText(), cdpi.getMois().getText(), cdpi.getAnnee().getText()), cdpi.getGenre().getSelectedItem().toString(), cdpi.getPrenom().getText(), new Adresse(cdpi.getAdresse().getText(), cdpi.getVille().getText(), cdpi.getCodePostal().getText()), cdpi.getNumSS().getText(), cdpi.getEmail().getText(), cdpi.getTelephone().getText(), cdpi.getTypesejour().getSelectedItem().toString());
            Localisation localisation;
            localisation = new Localisation(p, cdpi.getServiceGeo().getSelectedItem().toString(), cdpi.getServiceRespo().getSelectedItem().toString());
            p.AjouterSurBdPatient(p);

            if (p.getTypeSejour() == "Hospitalisation") {
                Hospitalisation.AjouterPatientHospitalisation(p);
            } else {
                ConsultExt.AjouterPatientConsultationExterne(p);
            }

            localisation.AjouterSurBdLocalisation(localisation);
            JOptionPane jop1 = new JOptionPane();

            jop1.showMessageDialog(null, "Patient correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
            fen.panelVisibleFalse();

            MethodeBD.listeAllPatientJTable();
            cdpis.getjTable1().setGridColor(new Color(153, 153, 153));
            cdpis.getjTable1().setModel(MethodeBD.listeAllPatientJTable());
            cdpis.getjTable1().setFont(new Font("Calibri", 0, 18));
            cdpis.repaint();

            MethodeBD.PatientSecretaire(cdpis.getjTable1());
            RafraichitLesPanels rf = new RafraichitLesPanels(fen,cdpis);

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderDMA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

    }

}
