/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import interfaces.BarreDuHaut;
import interfaces.DetailsPrestation;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nf.sejour.Resultats;

/**
 *
 * @author annel
 */
public class BoutonValiderResultats implements ActionListener {

    PrestationFaite pf;
    DetailsPrestation dp;
    Fenetre fen;
    BarreDuHaut bh;
    Prestations p;

    public BoutonValiderResultats(PrestationFaite pf, DetailsPrestation dp, Fenetre fen, BarreDuHaut bh, Prestations p) {
        this.pf = pf;
        this.dp = dp;
        this.fen = fen;
        this.bh = bh;
        this.p=p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String NomMedicoTech = bh.getNom().getText();
            String PrenomMedicoTech = bh.getPrenom().getText();
            int idMedicoTech = Integer.parseInt(bh.getId().getText());
            String NomPatient = dp.getNomPatient().getText();
            String PrenomPatient = dp.getPrenomPatient().getText();
            String ipp = dp.getIPP().getText();
            String ServiceDemandeur = dp.getSrvice().getText();

            Resultats r = new Resultats(ServiceDemandeur, NomPatient, PrenomPatient, ipp, NomMedicoTech, PrenomMedicoTech, idMedicoTech);
            r.AjouterResutatsSurBD(r);

            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Résultat Correctement Envoyée", "Information", JOptionPane.INFORMATION_MESSAGE);

            fen.panelVisibleFalse();
            fen.add(p);
            p.setVisible(true);
            fen.revalidate();
            fen.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderResultats.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
