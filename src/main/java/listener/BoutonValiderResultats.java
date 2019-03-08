/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import bd.MethodeBD;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
import interfaces.BarreDuHaut;
import interfaces.ConsulterDPIPHetIDE;
import interfaces.DetailsPrestation;
import interfaces.Fenetre;
import interfaces.PrestationFaite;
import interfaces.Prestations;
import interfaces.Resultat;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
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
    ConsulterDPIPHetIDE cdpiphetide;
    Resultat rr;

    public BoutonValiderResultats(PrestationFaite pf, DetailsPrestation dp, Fenetre fen, BarreDuHaut bh, Prestations p, ConsulterDPIPHetIDE cdpiphetide,Resultat rr) {
        this.pf = pf;
        this.dp = dp;
        this.fen = fen;
        this.bh = bh;
        this.p = p;
        this.cdpiphetide=cdpiphetide;
        this.rr=rr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            Dimension PremierCompte = rr.getTablePrestation().size();
            String NomMedicoTech = bh.getNom().getText();
            String PrenomMedicoTech = bh.getPrenom().getText();
            int idMedicoTech = Integer.parseInt(bh.getId().getText());
            String NomPatient = dp.getNomPatient().getText();
            String PrenomPatient = dp.getPrenomPatient().getText();
            String ipp = dp.getIPP().getText();
            String ServiceDemandeur = dp.getSrvice().getText();
            String Resultats = pf.getResultats().getContentType();

            String idDemande = dp.getDateDeDemande().getText();

            Resultats r = new Resultats(ServiceDemandeur, NomPatient, PrenomPatient, ipp, NomMedicoTech, PrenomMedicoTech, idMedicoTech, Resultats);
            r.AjouterResutatsSurBD(r);
            ConnexionBD conn = ConnexionBD.getInstance();
            PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from prestationaeffectuer WHERE DateDeDemande ='" + idDemande + "'");
            prep2.executeUpdate();
            p.getTablePrestation().setFont(new Font("Calibri", 0, 18));
            p.getTablePrestation().setModel(new MethodeBD().listePrestation());

            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Résultat Correctement Envoyée", "Information", JOptionPane.INFORMATION_MESSAGE);

          if (rr.getTablePrestation().size()!= PremierCompte){
          String notification =  cdpiphetide.getNotification().getText();
          int notif =  Integer.parseInt(notification);
          int increment = notif+=1;
          String notificationFinale = Integer.toString(increment);
          cdpiphetide.getNotification().setText(notificationFinale);
            
          }
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
