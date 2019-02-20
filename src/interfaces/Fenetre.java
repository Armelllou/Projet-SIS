/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listener.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Listener.BoutonModifierDPI;
import Listener.BoutonRetourDPISecretaireVersAccueil;
import Listener.BoutonRetourDPIVersConsulterDPI;
import Listener.BoutonValiderConnexion;
import NF.Sih;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    DPISecretaire dpis = new DPISecretaire();
    DPIPHetIDE dpiphide = new DPIPHetIDE();
    InfosMedicales infosmed = new InfosMedicales();
    ModificationDPI modifdpi = new ModificationDPI();
    JPanel jp = new JPanel();
    AjouterPrestation ajouterpresta = new AjouterPrestation();
    PrestationFaite prestafaite = new PrestationFaite();
    Prestations prestations = new Prestations();

    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barreduhaut = new BarreDuHaut();

    Sih sih;

    // Déclarations Boutons, JTextField etc
    private JButton valider = connexion.getjButton1();
    private JButton creerDPI = accueilsecretaires.getjButton1();
    private JButton consulterDPI = accueilsecretaires.getjButton2();
    private JButton deconnexion = barreduhaut.getjButton1();
    private JButton validerDMA = creationdpi.getjButton1();
    private JButton recherchePatient = consultdpis.getjButton1();
    private JButton getRecherchePatient2= consultdpiphide.getjButton1();
    private JButton retourDPISVersAS = consultdpis.getjButton2();
    private JButton annulercreationDPI = creationdpi.getjButton2();
    private JButton retourDPIVersConsulterDPISecretaire = dpis.getjButton2();
    private JButton accueilDPISecretaire = dpis.getjButton1();
    private JButton modificationdpi = dpis.getjButtonmodifier();
    private JButton retourActeInfVersInfosMed = acteinfirmier.getjButton4();
    private JButton accueilActeInfirmier = acteinfirmier.getjButton3();
    private JButton accueilAjouterActeInfirmier = ajouterai.getjButton3();
    private JButton annulerAjouterAI = ajouterai.getjButton1();
    private JButton accueilAjouterConsult = ajouterconsult.getjButton3();
    private JButton annulerAjouterConsult = ajouterconsult.getjButton1();
    private JButton accueilAjouterPresta = ajouterpresta.getjButton3();
    private JButton annulerAjouterPresta = ajouterpresta.getjButton1();
    private JButton accueilconsult = consultation.getjButton3();
    private JButton retourConsultVersInfosMed = consultation.getjButton4();
    private JButton accueilDPIPHetIDE = dpiphide.getjButton1();

    public Fenetre() {
        //state = State.NONCO;
        add(connexion);
        this.setSize(1700, 830);

        valider.addActionListener(new BoutonValiderConnexion(barreduhaut, connexion, consultdpis, consultdpiphide,prestations, this));
        creerDPI.addActionListener(new BoutonCreerDPI(accueilsecretaires, creationdpi, this));

        consulterDPI.addActionListener(new BoutonConsulterDPE(accueilsecretaires,consultdpis,this));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this,accueilsecretaires));
        validerDMA.addActionListener(new BoutonValiderDMA(accueilsecretaires,consultdpis,this,creationdpi));
        getRecherchePatient2.addActionListener(new BoutonRecherchePatientPhEtIde(this,consultdpiphide));
        recherchePatient.addActionListener(new BoutonRecherchePatient(this,consultdpis));
        consulterDPI.addActionListener(new BoutonConsulterDPE(accueilsecretaires, consultdpis, this));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this, accueilsecretaires));
        validerDMA.addActionListener(new BoutonValiderDMA(accueilsecretaires, consultdpis, this, creationdpi));


        consulterDPI.addActionListener(new BoutonConsulterDPE(accueilsecretaires, consultdpis, this));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this, accueilsecretaires));
        retourDPISVersAS.addActionListener(new BoutonRetourDPISecretaireVersAccueil(this, accueilsecretaires, consultdpis, sih));
        annulercreationDPI.addActionListener(new BoutonAnnulerCreationDPI(this, accueilsecretaires, creationdpi, sih));
        retourDPIVersConsulterDPISecretaire.addActionListener(new BoutonRetourDPIVersConsulterDPI(this, consultdpis, dpis, sih));
        accueilDPISecretaire.addActionListener(new BoutonAccueilDPISecretaire(this, dpis, accueilsecretaires, sih));
        modificationdpi.addActionListener(new BoutonModifierDPI(this, dpis, modifdpi, sih));
        retourActeInfVersInfosMed.addActionListener(new BoutonRetourActeInfirmierVersInfosMedicales(this,infosmed,acteinfirmier,sih));
        accueilActeInfirmier.addActionListener(new BoutonAccueilActeInfirmier(this,acteinfirmier,consultdpiphide,sih));
        accueilAjouterActeInfirmier.addActionListener(new BoutonAccueilAjouterActeInfirmier(this,ajouterai, consultdpiphide,sih));
        annulerAjouterAI.addActionListener(new BoutonAnnulerAjouterActeInfirmier(this,ajouterai,infosmed, sih));
        accueilAjouterConsult.addActionListener(new BoutonAccueilAjouterConsultation(this,ajouterconsult,consultdpiphide,sih));
        annulerAjouterConsult.addActionListener(new BoutonAnnulerAjouterConsultation(this,ajouterconsult, infosmed,sih));
        accueilAjouterPresta.addActionListener(new BoutonAccueilAjouterPrestation(this,ajouterpresta,consultdpiphide,sih));
        annulerAjouterPresta.addActionListener(new BoutonAnnulerAjouterPrestation(this,ajouterpresta,infosmed,sih));
        accueilconsult.addActionListener(new BoutonAccueilConsultation(this,consultation,consultdpiphide,sih));
        retourConsultVersInfosMed.addActionListener(new BoutonRetourConsultationVersInfosMed(this,consultation,infosmed,sih));
        accueilDPIPHetIDE.addActionListener(new BoutonAccueilDPIPHetIDE(this,dpiphide,consultdpiphide,sih));


        //Confirmation pour quitter l'application SOUCI POUR QD ON VEUT PAS FERMER
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int reponse = JOptionPane.showConfirmDialog(frame,
                        "Voulez-vous quitter l'application",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (reponse == JOptionPane.YES_OPTION) {
                    
                    System.exit(0);
                }
            }
        });

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fenetre frame = new Fenetre();
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.setVisible(true);
               frame.setVisible(true);

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
        dpis.setVisible(false);
        infosmed.setVisible(false);
        modifdpi.setVisible(false);
        dpiphide.setVisible(false);
        prestations.setVisible(false);
        ajouterpresta.setVisible(false);
        prestafaite.setVisible(false);

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
