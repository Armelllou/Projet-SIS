/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.ph;

import bd.MethodeBD;
import interfaces.AjouterPrescription;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listener.commun.RafraichitLesPanels;
import nf.sejour.Prescription;


public class BoutonValiderPrescription implements ActionListener {

    AjouterPrescription ac;
    InfosMedicalesPH im;
    Fenetre fen;
    BarreDuHaut bh;

    public BoutonValiderPrescription(AjouterPrescription ac, InfosMedicalesPH im, Fenetre fen, BarreDuHaut bh) {
        this.ac = ac;
        this.im = im;
        this.fen = fen;
        this.bh = bh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String ipp = im.getjLabelipp().getText();
            String NomMedecin = bh.getNom().getText();
            String PrenomMedecin = bh.getPrenom().getText();

            ac.getIPP().setText(ipp);
            ac.getNomMedecin().setText(NomMedecin);
            ac.getPrenomMedecin().setText(PrenomMedecin);

            String observation = ac.getPrescription().getText();
            String idMedecin = bh.getId().getText();
            String Type = ac.getTypePrescription().getText();

            Prescription p = new Prescription(observation, Type, idMedecin, ipp);
            p.AjouterActeSurBD(p);
            im.getjTable1().setFont(new Font("Calibri", 0, 18));
            im.getjTable1().setModel(MethodeBD.listePrescriptionJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD

            JOptionPane.showMessageDialog(null, "Prescription correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderPrescription.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
         }

            RafraichitLesPanels rf = new RafraichitLesPanels(fen,im);
    }
}
