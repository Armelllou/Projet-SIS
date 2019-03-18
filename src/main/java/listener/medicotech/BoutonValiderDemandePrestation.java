/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.medicotech;

import bd.MethodeBD;
import interfaces.AjouterPrestation;
import interfaces.BarreDuHaut;
import interfaces.Fenetre;
import interfaces.InfosMedicalesPH;
import interfaces.Prestations;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listener.commun.RafraichitLesPanels;
import nf.sejour.PrestationDemandee;

/**
 *
 * @author annel
 */
public class BoutonValiderDemandePrestation implements ActionListener {

    AjouterPrestation ap;
    InfosMedicalesPH imph;
    BarreDuHaut bh;
    Fenetre fen;
    Prestations p;

    public BoutonValiderDemandePrestation(AjouterPrestation ap, InfosMedicalesPH imph, BarreDuHaut bh, Fenetre fen, Prestations p) {
        this.ap = ap;
        this.imph = imph;
        this.bh = bh;
        this.fen = fen;
        this.p=p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = imph.getjLabelnom().getText();
        String prenom = imph.getjLabelprenom().getText();
        String ipp = imph.getjLabelipp().getText();
        String PrestationDemandee = ap.getPrestationDemandee().getText();
        String Service = ap.getServiceDemandeur().getSelectedItem().toString();
        String NomMedecin = bh.getNom().getText();
        String PrenomMedecin = bh.getPrenom().getText();
        int idph =Integer.parseInt(bh.getId().getText()) ;

        try {
            PrestationDemandee pd = new PrestationDemandee(Service, PrestationDemandee, nom, prenom, ipp,NomMedecin,PrenomMedecin,idph);
            pd.AjouterDemandeDePrestationSurBD(pd);
            
            JOptionPane jop1 = new JOptionPane();
            JOptionPane.showMessageDialog(null, "Prestation correctement demandée", "Information", JOptionPane.INFORMATION_MESSAGE);
            
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,imph);
            
            
         p.getTablePrestation().setFont(new Font("Calibri", 0, 18));
        p.getTablePrestation().setModel(MethodeBD.listePrestation());
        
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderDemandePrestation.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
         }

    }

}
