/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listener.BoutonConsulterDPE;
import Listener.BoutonCreerDPI;

import Listener.BoutonDeconnexion;

import Listener.BoutonValiderConnexion;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Manon
 */


public class Fenetre extends JFrame {

    // Déclaration de tous les JPanel
    Connexion connexion = new Connexion();
    AccueilSecretaires accueilsecretaires = new AccueilSecretaires();
    CreationDPI creationdpi = new CreationDPI();
    ConsulterDPISecretaire consultdpis = new ConsulterDPISecretaire();
    ActeInfirmier acteinfirmier = new ActeInfirmier();
    AjouterActeInfirmier ajouterai = new AjouterActeInfirmier();
    AjouterConsultation ajouterconsult = new AjouterConsultation();
    Consultation consultation = new Consultation();
    ConsulterDPIPHetIDE consultdpiphide = new ConsulterDPIPHetIDE();
    DPI dpi = new DPI();
    InfosMedicales infosmed = new InfosMedicales();
    ModificationDPI modifdpi = new ModificationDPI();
    JPanel jp = new JPanel();

    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barreduhaut = new BarreDuHaut();

    // Déclarations Boutons, JTextField etc
    private JButton valider = connexion.getjButton1();
    private JButton creerDPI = accueilsecretaires.getjButton1();
    private JButton consulterDPI = accueilsecretaires.getjButton2();
    private JButton deconnexion = barreduhaut.getjButton1();

    public Fenetre() {
        //state = State.NONCO;
        add(connexion);
        this.setSize(1700, 830);

        valider.addActionListener(new BoutonValiderConnexion(barreduhaut, connexion,accueilsecretaires,consultdpiphide,this));
        creerDPI.addActionListener(new BoutonCreerDPI(accueilsecretaires, creationdpi, this));
        consulterDPI.addActionListener(new BoutonConsulterDPE(accueilsecretaires,consultdpis,this));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this,accueilsecretaires));
        
        //Confirmation pour quitter l'application SOUCI POUR QD ON VEUT PAS FERMER
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int reponse = JOptionPane.showConfirmDialog(frame,
                        "Voulez-vous quitter l'application",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (reponse == JOptionPane.YES_OPTION) {
                    //InscriptionFichierXML sauvegarde = new InscriptionFichierXML();
                    //sauvegarde.Xml(sih);
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);
            }
        });
    }

    public void PanelVisibleFalse() {
        connexion.setVisible(false);
        accueilsecretaires.setVisible(false);
        creationdpi.setVisible(false);
        consultdpis.setVisible(false);
        acteinfirmier.setVisible(false);
        consultdpiphide.setVisible(false);
        ajouterai.setVisible(false);
        ajouterconsult.setVisible(false);
        consultation.setVisible(false);
        dpi.setVisible(false);
        infosmed.setVisible(false);
        modifdpi.setVisible(false);

    }

    public void TotaliteFalse() {
        barreduhaut.setVisible(false);
        connexion.setVisible(false);
        this.PanelVisibleFalse();
    }

    public void setState(State state) {
        //this.state = state;
    }

    public State getStates() {
        //return state;
        return null;
    }

}
