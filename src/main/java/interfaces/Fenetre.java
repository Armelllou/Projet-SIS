/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import listener.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import listener.ide.*;
import listener.ph.*;
import listener.secretairemedical.*;
import nf.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;


public class Fenetre extends JFrame {

    // Déclaration de tous les JPanel
    Connexion connexion = new Connexion();
    CreationDPI creationdpi = new CreationDPI();
    ConsulterDPISecretaire consultdpis = new ConsulterDPISecretaire();
    ActeInfirmierPH acteinfirmierPH = new ActeInfirmierPH();
    AjouterActeInfirmier ajouterai = new AjouterActeInfirmier();
    AjouterConsultation ajouterconsult = new AjouterConsultation();
    ConsultationPH consultationPH = new ConsultationPH();
    ConsulterDPIPHetIDE consultdpiphide = new ConsulterDPIPHetIDE();
    DPISecretaire dpis = new DPISecretaire();
    DPIIDE dpiide = new DPIIDE();
    InfosMedicalesPH infosmedph = new InfosMedicalesPH();
    ModificationDPI modifdpi = new ModificationDPI();
    JPanel jp = new JPanel();
    AjouterPrestation ajouterpresta = new AjouterPrestation();
    PrestationFaite prestafaite = new PrestationFaite();
    Prestations prestations = new Prestations();
    TransfertService transfert = new TransfertService();
    AjouterPrescription ajouterprescri = new AjouterPrescription();
    DPIPH dpiph = new DPIPH();
    InfosMedicalesIDE infosmedide = new InfosMedicalesIDE();
    ActeInfirmierIDE acteinfirmieride = new ActeInfirmierIDE();
    ConsultationIDE consultationide = new ConsultationIDE();
    PrescriptionIDE prescriptionide = new PrescriptionIDE();
    PrescriptionPH prescriptionph = new PrescriptionPH();

    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barreduhaut = new BarreDuHaut();

    Sih sih;

    // Déclarations Boutons
    private JButton valider = connexion.getjButton1();
    private JButton creerDPI = consultdpis.getjButton2();
    private JButton deconnexion = barreduhaut.getjButton1();
    private JButton validerDMA = creationdpi.getjButton1();
    private JButton recherchePatient = consultdpis.getjButton1();
    private JButton getRecherchePatient2 = consultdpiphide.getjButton1();
    private JButton retourDPISVersAS = consultdpis.getjButton2();
    private JButton annulercreationDPI = creationdpi.getjButton2();
    private JButton retourDPIVersConsulterDPISecretaire = dpis.getjButton2();
    private JButton modificationdpi = dpis.getjButtonmodifier();
    private JButton retourActeInfVersInfosMedPH = acteinfirmierPH.getjButton4();
    private JButton accueilActeInfirmierPH = acteinfirmierPH.getjButton3();
    private JButton annulerAjouterAI = ajouterai.getjButton1();
    private JButton annulerAjouterConsult = ajouterconsult.getjButton1();
    private JButton annulerAjouterPresta = ajouterpresta.getjButton1();
    private JButton accueilconsultPH = consultationPH.getjButton3();
    private JButton retourConsultPHVersInfosMedPH = consultationPH.getjButton4();
    private JButton ConnexionEntrerListener = connexion.getjButton1();
    private JButton retourActeInfIDEVersInfosMedIDE = acteinfirmieride.getjButton4();
    private JButton accueilActeInfIDE = acteinfirmieride.getjButton3();
    private JButton annulerAjouterPrescri = ajouterpresta.getjButton1();
    private JButton retourConsultIDEVersInfosMedIDE = consultationide.getjButton4();
    private JButton accueilconsultationide = consultationide.getjButton3();
    private JButton accueilconsultationph = consultationPH.getjButton3();
    private JButton retourDPIIDEVersConsultDPIPHetIDE = dpiide.getjButton2();
    private JButton dpiideversinfosmedide = dpiide.getjButtoninfomed();
    private JButton retourDPIPHVersConsultDPIPHetIDE = dpiph.getjButton2();
    private JButton dpiphversinfosmedph = dpiph.getjButtoninfomed();
    private JButton dpiphverstransfert = dpiph.getjButton3();
    private JButton retourinfosmedIDEVersDPIIDE = infosmedide.getjButton2();
    private JButton accueilinfosmedIDE = infosmedide.getjButton1();
    private JButton ajouteracteinf = infosmedide.getjButton3();
    private JButton retourinfosmedPHversDPIPH = infosmedph.getjButton2();
    private JButton accueilinfmedphversconsultdpiphide = infosmedph.getjButton1();
    private JButton ajouterconsultation = infosmedph.getjButton4();
    private JButton ajouterprescription = infosmedph.getjButton6();
    private JButton ajouterprestation = infosmedph.getjButton5();
    private JButton annulermodifDPI = modifdpi.getjButton2();
    private JButton accueilprescriIDE = prescriptionide.getjButton3();
    private JButton retourPrescriIDEVersInfMedIDE = prescriptionide.getjButton4();
    private JButton accueilprescriPH = prescriptionph.getjButton3();
    private JButton retourPrescriPHVersInfMedPH = prescriptionph.getjButton4();
    private JButton annulerprestafaite = prestafaite.getjButton1();
    private JButton annulertransfert = transfert.getjButton2();
    private JButton validermodifdpi = modifdpi.getjButton1();
    private JButton validerActe = ajouterai.getjButton2();
    
    //Déclarations Tableaux
    private JTable tableauconsultdpis = consultdpis.getjTable1();
    private JTable tableauconsultdpiphide = consultdpiphide.getjTable1();
    private JTable tableauconsultinfmedph = infosmedph.getjTable3();
    private JTable tableauconsultinfmedide = infosmedide.getjTable3();
    private JTable tableauacteinfirmierinfmedph = infosmedph.getjTable2();
    private JTable tableauacteinfirmierinfmedide = infosmedide.getjTable2();
    private JTable tableauprescriinfmedide = infosmedide.getjTable1();
    private JTable tableauprescriinfmedph = infosmedph.getjTable1();
    private JTable tableauprestations = prestations.getjTable1();


    public Fenetre() {
        //state = State.NONCO;
        add(connexion);
        this.setSize(1700, 830);
        
        ListenerConnexion l = new ListenerConnexion(barreduhaut, connexion, consultdpis, consultdpiphide, prestations, this);
        
        //connexion
        valider.addActionListener(l);
        connexion.getjPasswordField1().addKeyListener(l);
        
        //boutons
        creerDPI.addActionListener(new BoutonCreerDPI(consultdpis, creationdpi, this));
        validerDMA.addActionListener(new BoutonValiderDMA(consultdpis, this, creationdpi));
        getRecherchePatient2.addActionListener(new BoutonRecherchePatientPhEtIde(this, consultdpiphide));
        recherchePatient.addActionListener(new BoutonRecherchePatient(this, consultdpis));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this, barreduhaut));
        annulercreationDPI.addActionListener(new BoutonAnnulerCreationDPI(this, consultdpis, creationdpi, sih));
        retourDPIVersConsulterDPISecretaire.addActionListener(new BoutonRetourDPISVersConsulterDPISecretaire(this, consultdpis, dpis, sih));
        modificationdpi.addActionListener(new BoutonModifierDPI(this, dpis, modifdpi, sih));
        retourActeInfVersInfosMedPH.addActionListener(new BoutonRetourActeInfirmierPHVersInfosMedicalesPH(this, infosmedph, acteinfirmierPH, sih));
        accueilActeInfirmierPH.addActionListener(new BoutonAccueilActeInfirmierPH(this, acteinfirmierPH, consultdpiphide, sih));
        annulerAjouterAI.addActionListener(new BoutonAnnulerAjouterActeInfirmier(this, ajouterai, infosmedide, sih));
        annulerAjouterConsult.addActionListener(new BoutonAnnulerAjouterConsultation(this, ajouterconsult, infosmedph, sih));
        annulerAjouterPresta.addActionListener(new BoutonAnnulerAjouterPrestation(this, ajouterpresta, infosmedph, sih));
        retourConsultPHVersInfosMedPH.addActionListener(new BoutonRetourConsultationPHVersInfosMedPH(this, consultationPH, infosmedph, sih));
        retourActeInfIDEVersInfosMedIDE.addActionListener(new BoutonRetourActeInfirmierIDEVersInfosMedicalesIDE(this, infosmedide, acteinfirmieride, sih));
        accueilActeInfIDE.addActionListener(new BoutonAccueilActeInfirmierIDE(this, acteinfirmieride, consultdpiphide, sih));
        annulerAjouterPrescri.addActionListener(new BoutonAnnulerAjouterPrescription(this, ajouterprescri, infosmedph, sih));
        retourConsultIDEVersInfosMedIDE.addActionListener(new BoutonRetourConsultationIDEVersInfosMedIDE(this, consultationide, infosmedide, sih));
        accueilconsultationide.addActionListener(new BoutonAccueilConsultationIDE(this, consultationide, consultdpiphide, sih));
        accueilconsultationph.addActionListener(new BoutonAccueilConsultationPH(this, consultationPH, consultdpiphide, sih));
        retourDPIIDEVersConsultDPIPHetIDE.addActionListener(new BoutonRetourDPIIDEVersConsulterDPIPHetIDE(this, consultdpiphide, dpiide, sih));
        dpiideversinfosmedide.addActionListener(new BoutonDPIIDEVersInfosMedIDE(dpiide, infosmedide, this));
        retourDPIPHVersConsultDPIPHetIDE.addActionListener(new BoutonRetourDPIPHVersConsulterDPIPHetIDE(this, consultdpiphide, dpiph, sih));
        dpiphversinfosmedph.addActionListener(new BoutonDPIPHVersInfosMedPH(dpiph, infosmedph, this));
        dpiphverstransfert.addActionListener(new BoutonDPIPHVersTransfert(dpiph, transfert, this));
        retourinfosmedIDEVersDPIIDE.addActionListener(new BoutonRetourInfosMedIDEVersDPIIDE(dpiide, infosmedide, this));
        accueilinfosmedIDE.addActionListener(new BoutonAccueilInfosMedIDE(this, infosmedide, consultdpiphide, sih));
        ajouteracteinf.addActionListener(new BoutonAjouterActeInfirmier(this, ajouterai, infosmedide, sih));
        retourinfosmedPHversDPIPH.addActionListener(new BoutonRetourInfosMedPHVersDPIPH(dpiph, infosmedph, this));
        accueilinfmedphversconsultdpiphide.addActionListener(new BoutonAccueilInfMedPH(this, infosmedph, consultdpiphide, sih));
        ajouterconsultation.addActionListener(new BoutonAjouterConsultation(this, ajouterconsult, infosmedph, sih));
        ajouterprescription.addActionListener(new BoutonAjouterPrescription(this, ajouterprescri, infosmedph, sih));
        ajouterprestation.addActionListener(new BoutonAjouterPrestation(this, ajouterpresta, infosmedph, sih));
        annulermodifDPI.addActionListener(new BoutonAnnulerModificationDPI(this, dpis, modifdpi, sih));
        accueilprescriIDE.addActionListener(new BoutonAccueilPrescriptionIDE(this, prescriptionide, consultdpiphide, sih));
        retourPrescriIDEVersInfMedIDE.addActionListener(new BoutonRetourPrescriptionIDEVersInfosMedIDE(this, prescriptionide, infosmedide, sih));
        accueilprescriPH.addActionListener(new BoutonAccueilPrescriptionPH(this, prescriptionph, consultdpiphide, sih));
        retourPrescriPHVersInfMedPH.addActionListener(new BoutonRetourPrescriptionPHVersInfosMedPH(this, prescriptionph, infosmedph, sih));
        annulerprestafaite.addActionListener(new BoutonAnnulerPrestaFaite(prestafaite, prestations, this));
        annulertransfert.addActionListener(new BoutonAnnulerTransfert(dpiph, transfert, this));
        validermodifdpi.addActionListener (new BoutonValiderModificationDPI(this, dpis, modifdpi, sih));
        validerActe.addActionListener(new BoutonValiderActe(barreduhaut,infosmedide, this,ajouterai));
        
        
        //tableaux
        tableauconsultdpis.addMouseListener(new TableauConsulterDPISecretaire(consultdpis, dpis, this, consultdpis.getjTable1()));
        tableauconsultdpiphide.addMouseListener(new TableauConsulterDPIPHetIDE (dpiph, dpiide, consultdpiphide,this,consultdpiphide.getjTable1(),l));     
        tableauconsultinfmedph.addMouseListener(new TableauConsultationsInfosMedPH(infosmedph,consultationPH,this,sih,infosmedph.getjTable3()));
        tableauconsultinfmedide.addMouseListener(new TableauConsultationsInfosMedIDE(infosmedide,consultationide,this,sih,infosmedide.getjTable3()));
        tableauacteinfirmierinfmedph.addMouseListener(new TableauActesInfirmiersInfosMedPH(infosmedph,acteinfirmierPH,this,sih,infosmedph.getjTable2()));
        tableauacteinfirmierinfmedide.addMouseListener(new TableauActesInfirmiersInfosMedIDE(infosmedide,acteinfirmieride,this,sih,infosmedide.getjTable2()));
        tableauprescriinfmedide.addMouseListener(new TableauPrescriptionsInfosMedIDE(infosmedide,prescriptionide,this,sih,infosmedide.getjTable1()));
        tableauprescriinfmedph.addMouseListener(new TableauPrescriptionsInfosMedPH(infosmedph,prescriptionph,this,sih,infosmedph.getjTable1()));
        tableauprestations.addMouseListener(new TableauPrestations(prestations,prestafaite,this,sih,prestations.getjTable1()));


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

            }
        });

    }

    public void panelVisibleFalse() {
        connexion.setVisible(false);
        creationdpi.setVisible(false);
        consultdpis.setVisible(false);
        acteinfirmierPH.setVisible(false);
        consultdpiphide.setVisible(false);
        ajouterai.setVisible(false);
        ajouterconsult.setVisible(false);
        consultationPH.setVisible(false);
        dpis.setVisible(false);
        infosmedph.setVisible(false);
        modifdpi.setVisible(false);
        dpiide.setVisible(false);
        prestations.setVisible(false);
        ajouterpresta.setVisible(false);
        prestafaite.setVisible(false);
        transfert.setVisible(false);
        ajouterprescri.setVisible(false);
        dpiph.setVisible(false);
        infosmedide.setVisible(false);
        prescriptionph.setVisible(false);
        prescriptionide.setVisible(false);
        consultationide.setVisible(false);
        acteinfirmieride.setVisible(false);

    }

    public void totaliteFalse() {
        barreduhaut.setVisible(false);
        connexion.setVisible(false);
        this.panelVisibleFalse();
    }










    

}
