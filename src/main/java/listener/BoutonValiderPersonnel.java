/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.MethodeBD;
import interfaces.CreationPersonnel;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nf.personnel.Infirmier;
import nf.personnel.Medecin;
import nf.personnel.SecretaireMedical;
import nf.personnel.Technicien;

/**
 *
 * @author annel
 */
public class BoutonValiderPersonnel implements ActionListener {

    Fenetre fen;
    ListePersonnel lp;
    CreationPersonnel cp;

    public BoutonValiderPersonnel(Fenetre fen, ListePersonnel lp, CreationPersonnel cp) {
        this.fen = fen;
        this.lp = lp;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Nom = cp.getNom().getText();
        String Prenom = cp.getPrénom().getText();
        int id = Integer.parseInt(cp.getId().getText());
        int mdp = Integer.parseInt(cp.getMdp().getText());
        String Service = cp.getService().getSelectedItem().toString();
        String Personnel = cp.getType().getSelectedItem().toString();
        
        System.out.println(Personnel);

        System.out.println(Personnel);
        try {

            if (Personnel == "ide") {
                Infirmier i = new Infirmier(Nom, Prenom, id, mdp, Service);
                i.AjouterSurBdIDE(i);
                System.out.println("ok ide");

            }
            if (Personnel == "praticienhospitaliers") {
                Medecin m = new Medecin(Nom, Prenom, id, mdp, Service);
                m.AjouterSurBdMedecin(m);
                System.out.println("ok ph");

            }
            if (Personnel == "Technicien") {
                Technicien t = new Technicien(Nom, Prenom, id, mdp, Service);
                t.AjouterSurBdTechnicien(t);
                System.out.println("ok technicien");
            } else {
                SecretaireMedical sm = new SecretaireMedical(Nom, Prenom, id, mdp, Service);
                sm.AjouterSurBdSecretaireMedical(sm);
                System.out.println("ok sa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        lp.getjTable3().setFont(new Font("Calibri", 0, 18));
        lp.getjTable3().setModel(new MethodeBD().listeIDE());
        lp.getTablePH().setFont(new Font("Calibri", 0, 18));
        lp.getTablePH().setModel(new MethodeBD().listePH());
        lp.getTableMT().setFont(new Font("Calibri", 0, 18));
        lp.getTableMT().setModel(new MethodeBD().listeMT());

        fen.panelVisibleFalse();
        fen.add(lp);
        lp.setVisible(true);
        fen.revalidate();
        fen.repaint();

    }

}
