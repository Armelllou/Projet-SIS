/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nf.personnel.Infirmier;
import nf.personnel.Medecin;
import nf.personnel.MedicoTechnique;
import nf.personnel.SecretaireMedical;
import nf.personnel.Technicien;

/**
 *
 * @author annel
 */
public class BoutonSupprimerPersonnel implements ActionListener {

    ListePersonnel lp;
    ModifierPersonnel mp;
    Fenetre fen;

    public BoutonSupprimerPersonnel(ListePersonnel lp, ModifierPersonnel mp, Fenetre fen) {
        this.lp = lp;
        this.mp = mp;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String id = mp.getId().getText();
        String Personnel = mp.getType().getSelectedItem().toString();

        int reponse = JOptionPane.showConfirmDialog(fen,
                "Voulez-vous vraiment supprimer ce personnel ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (reponse == JOptionPane.YES_OPTION) {
            try {
                if (Personnel == "ide") {
                   
                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from ide WHERE idIDE ='" + id + "'");
                    prep2.executeUpdate();
                    lp.getTableIDE().setFont(new Font("Calibri", 0, 18));
                    lp.getTableIDE().setModel(new MethodeBD().listeIDE());
                }
                if (Personnel == "praticienhospitaliers") {
                    
                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE from praticienhospitaliers WHERE idPh ='" + id + "'");
                    prep2.executeUpdate();
                    lp.getTablePH().setFont(new Font("Calibri", 0, 18));
                    lp.getTablePH().setModel(new MethodeBD().listePH());
                }
                if (Personnel == "Technicien") {

                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from Technicien WHERE idTECH ='" + id + "'");
                    prep2.executeUpdate();
                }
                if (Personnel == "medicotechniques") {
                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from medicotechniques WHERE idMT ='" + id + "'");
                    prep2.executeUpdate();

                    lp.getTableMT().setFont(new Font("Calibri", 0, 18));
                    lp.getTableMT().setModel(MethodeBD.listeMT());

                }
                if (Personnel == "SecretaireAdministrative") {
                  
                    ConnexionBD conn = ConnexionBD.getInstance();
                    PreparedStatement prep2 = conn.getConnexion().prepareStatement("DELETE  from secretaireadministrative WHERE idSA ='" + id + "'");
                    prep2.executeUpdate();

                    lp.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
                    lp.getTableSecretaire().setModel(new MethodeBD().listeSA());

                }
            } catch (SQLException ex) {
                Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }

            fen.panelVisibleFalse();
            fen.add(lp);
            lp.setVisible(true);
            fen.revalidate();
            fen.repaint();
        } else {
            fen.panelVisibleFalse();
            fen.add(mp);
            mp.setVisible(true);
            fen.revalidate();
            fen.repaint();

        }
    }
}
