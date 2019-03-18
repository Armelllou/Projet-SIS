/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.technicien;

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
import javax.swing.JOptionPane;
import listener.commun.RafraichitLesPanels;
import nf.personnel.Infirmier;
import nf.personnel.Medecin;
import nf.personnel.MedicoTechnique;
import nf.personnel.SecretaireMedical;
import nf.personnel.Technicien;

import javax.swing.*;

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

        String nom = cp.getNom().getText();
        String prenom = cp.getPrénom().getText();
        int id = Integer.parseInt(cp.getId().getText());
        int mdp = Integer.parseInt(cp.getMdp().getText());
        String service = cp.getService().getSelectedItem().toString();
        String personnel = cp.getType().getSelectedItem().toString();

        
                    
                   try {
            if (personnel == "ide") {
                Infirmier i = new Infirmier(nom, prenom, id, mdp, service);
                i.AjouterSurBdIDE(i);
                System.out.println("ok ide");
                lp.getTableIDE().setFont(new Font("Calibri", 0, 18));
                lp.getTableIDE().setModel(new MethodeBD().listeIDE());
            }
            if (personnel == "praticienhospitaliers") {
                Medecin m = new Medecin(nom, prenom, id, mdp, service);
                m.AjouterSurBdMedecin(m);
                System.out.println("ok ph");
                lp.getTablePH().setFont(new Font("Calibri", 0, 18));
                lp.getTablePH().setModel(new MethodeBD().listePH());
            }
            if (personnel == "Technicien") {
                Technicien t = new Technicien(nom, prenom, id, mdp);
                t.AjouterSurBdTechnicien(t);
                System.out.println("ok technicien");
            }
            if (personnel == "medicotechniques") {
                MedicoTechnique mt = new MedicoTechnique(nom, prenom, id, mdp);
                mt.AjouterSurBdMedicoTechnique(mt);
                lp.getTableMT().setFont(new Font("Calibri", 0, 18));
                lp.getTableMT().setModel(MethodeBD.listeMT());
                System.out.println("ok medicotechnicien");    
                } 
            if(personnel=="SecretaireAdministrative") {
                SecretaireMedical sm = new SecretaireMedical(nom, prenom, id, mdp, service);
                sm.AjouterSurBdSecretaireMedical(sm);
                lp.getTableSecretaire().setFont(new Font("Calibri", 0, 18));
                lp.getTableSecretaire().setModel(new MethodeBD().listeSA());
                System.out.println("ok sa");
            }
        }  
        catch (SQLException ex) {
            Logger.getLogger(BoutonValiderPersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
                RafraichitLesPanels rf = new RafraichitLesPanels(fen,lp);       
                   
                }
                
                }
                
                
        

      
            
       

    


