/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bd.MethodeBD;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nf.Dates;
import nf.sejour.Prescription;

/**
 *
 * @author annel
 */
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
            Dates dates = new Dates(ac.getDate().getText(), ac.getJour().getText(), ac.getAnnee().getText());

            Prescription p = new Prescription(observation, Type, idMedecin, ipp);
            p.AjouterActeSurBD(p);
            im.getjTable1().setFont(new Font("Calibri", 0, 18));
            im.getjTable1().setModel(MethodeBD.listePrescriptionJTableServiceIde(ipp)); // rempli la JTable avec les patients de la BD

            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Prescription correctement ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderPrescription.class.getName()).log(Level.SEVERE, null, ex);
        }

        fen.panelVisibleFalse();
        fen.add(im);
        im.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }
}