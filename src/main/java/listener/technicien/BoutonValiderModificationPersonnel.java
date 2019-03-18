/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.Fenetre;
import interfaces.ListePersonnel;
import interfaces.ModifierPersonnel;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoutonValiderModificationPersonnel implements ActionListener {

    Fenetre fen;
    ListePersonnel lp;
    ModifierPersonnel mp;

    public BoutonValiderModificationPersonnel(Fenetre fen, ListePersonnel lp, ModifierPersonnel mp) {
        this.fen = fen;
        this.lp = lp;
        this.mp = mp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nom = mp.getNom().getText();
        String prenom = mp.getPrénom().getText();
        int id = Integer.parseInt(mp.getId().getText());
        int mdp = Integer.parseInt(mp.getMdp().getText());
        String service = mp.getService().getSelectedItem().toString();
        String personnel = mp.getType().getSelectedItem().toString();

        try {
            if (personnel == "ide") {
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE ide SET Nom= ?, Prenom = ?,idIDE= ?,motDePasse= ?,Service= ?WHERE idIDE= ?");
                prep2.setString(1, nom);
                prep2.setString(2, prenom);
                prep2.setInt(3, id);
                prep2.setInt(4, mdp);
                prep2.setString(5, service);
                prep2.setInt(6, id);

                prep2.executeUpdate();
                System.out.println("ok ide");
                lp.getTableIDE().setFont(new Font("Calibri", 0, 18));
                lp.getTableIDE().setModel(new MethodeBD().listeIDE());
            }
            if (personnel == "praticienhospitaliers") {
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE praticienhospitaliers SET Nom= ?, Prenom = ?,idPh= ?,motDePasse= ?,Service= ?WHERE idPh= ?");
                prep2.setString(1, nom);
                prep2.setString(2, prenom);
                prep2.setInt(3, id);
                prep2.setInt(4, mdp);
                prep2.setString(5, service);
                prep2.setInt(6, id);
                prep2.executeUpdate();

                System.out.println("ok ph");
                lp.getTablePH().setFont(new Font("Calibri", 0, 18));
                lp.getTablePH().setModel(new MethodeBD().listePH());
            }
            if (personnel == "Technicien") {
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE Technicien SET Nom= ?, Prenom = ?,idTECH= ?,motDePasse= ?,Service= ?WHERE idTECH= ?");
                prep2.setString(1, nom);
                prep2.setString(2, prenom);
                prep2.setInt(3, id);
                prep2.setInt(4, mdp);
                prep2.setString(5, service);
                prep2.setInt(6, id);
                prep2.executeUpdate();

                System.out.println("ok technicien");
            }
            if (personnel == "medicotechniques") {
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE medicotechniques SET Nom= ?, Prenom = ?,idMT= ?,motDePasse= ?,Service= ?WHERE idMT= ?");
                prep2.setString(1, nom);
                prep2.setString(2, prenom);
                prep2.setInt(3, id);
                prep2.setInt(4, mdp);
                prep2.setString(5, service);
                prep2.setInt(6, id);
                prep2.executeUpdate();

                lp.getTableMT().setFont(new Font("Calibri", 0, 18));
                lp.getTableMT().setModel(MethodeBD.listeMT());
                System.out.println("ok medicotechnicien");
            }
            if (personnel == "SecretaireAdministrative") {
                ConnexionBD conn = ConnexionBD.getInstance();
                PreparedStatement prep2 = conn.getConnexion().prepareStatement("UPDATE secretaireadministrative SET Nom= ?, Prénom = ?,idSA= ?,motDePasse= ?,Service= ?WHERE idSA= ?");
                prep2.setString(1, nom);
                prep2.setString(2, prenom);
                prep2.setInt(3, id);
                prep2.setInt(4, mdp);
                prep2.setString(5, service);
                prep2.setInt(6, id);
                prep2.executeUpdate();

                lp.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
                lp.getTableSecretaire().setModel(new MethodeBD().listeSA());
                System.out.println("ok sa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
        }

        fen.panelVisibleFalse();
        fen.add(lp);
        lp.setVisible(true);
        fen.revalidate();
        fen.repaint();

    }

}
