/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import listener.commun.BoutonDeconnexion;
import listener.technicien.BoutonValiderModificationPersonnel;
import listener.commun.affichageResultats;
import listener.commun.BoutonAnnulerResultats;
import listener.secretairemedical.BoutonValiderModificationDPI;
import listener.technicien.TableauPhP1;
import listener.commun.TableauResultatParPatient;
import listener.commun.BoutonRecherchePatientPhEtIde;
import listener.commun.ListenerConnexion;
import listener.commun.BoutonRetourdetailsRversR;
import listener.commun.BoutonAccederAuxResultats;
import listener.medicotech.BoutonValiderDemandePrestation;
import listener.technicien.BoutonValiderPersonnel;
import listener.commun.BoutonRetourVersConsulterDPIPHetIDE;
import listener.medicotech.BoutonValiderResultats;
import listener.secretairemedical.BoutonValiderDMA;
import listener.medicotech.TableauPrestations;
import listener.medicotech.BoutonRetourDetailsPrestation;
import listener.ph.BoutonResultatsPh;
import listener.ide.BoutonResultatsIde;
import listener.ide.BoutonValiderActe;
import listener.technicien.tableauSMP;
import listener.technicien.TableauMTP;
import listener.technicien.TableauIdeP;
import listener.technicien.BouttonAnnulerModifPersonnel;
import listener.ide.TableauConsulterIDE;
import listener.ph.TableauConsulterDPIPH;
import listener.medicotech.BoutonEnvoyerResultats;

import listener.technicien.BoutonSupprimerPersonnel;
import listener.technicien.BoutonAnnulerPersonnel;
import listener.ph.BoutonAjouterPrestation;
import listener.technicien.BoutonAjouterDuPersonnel;
import listener.secretairemedical.BoutonModifierDPI;
import listener.ide.BoutonAjouterActeInfirmier;
import listener.ph.BoutonAjouterConsultation;
import listener.ph.BoutonAjouterPrescription;
import listener.ph.BoutonValiderTransfert;
import listener.secretairemedical.BoutonCreerDPI;
import listener.ph.BoutonValiderPrescription;
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

    //Déclaration de tous les JPanel
    Connexion connexion = new Connexion();
    CreationDPI creationdpi = new CreationDPI();
    ConsulterDPISecretaire consultdpis = new ConsulterDPISecretaire();
    ActeInfirmier acteinfirmier = new ActeInfirmier();
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
    ConsultationIDE consultationide = new ConsultationIDE();
    PrescriptionIDE prescriptionide = new PrescriptionIDE();
    PrescriptionPH prescriptionph = new PrescriptionPH();
    ListePersonnel pl = new ListePersonnel();
    CreationPersonnel cp = new CreationPersonnel();
    ModifierPersonnel mp = new ModifierPersonnel();
    DetailsPrestation dp = new DetailsPrestation();
    Resultat r = new Resultat();
    DetailsResultats dr = new DetailsResultats();
    ResultatParPatient rp = new ResultatParPatient();
    ResultatsConsulter rc = new ResultatsConsulter();
    ActeInfirmieride  aiide = new ActeInfirmieride();

    // Attributs de la JFrame
    BarreDuHaut barreduhaut = new BarreDuHaut();
    Fenetre frame = this;
    



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
    private JButton retourActeInfVersInfosMedPH = acteinfirmier.getjButton4();
    private JButton accueilActeInfirmierPH = acteinfirmier.getjButton3();
    private JButton annulerAjouterAI = ajouterai.getjButton1();
    private JButton annulerAjouterConsult = ajouterconsult.getjButton1();
    private JButton annulerAjouterPresta = ajouterpresta.getBoutonAnnuler();
    private JButton accueilconsultPH = consultationPH.getjButton3();
    private JButton retourConsultPHVersInfosMedPH = consultationPH.getjButton4();
    private JButton ConnexionEntrerListener = connexion.getjButton1();
    private JButton annulerAjouterPrescri = ajouterpresta.getBoutonAnnuler();
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
    private JButton retourinfosmedPHversDPIPH = infosmedph.getRetour();
    private JButton accueilinfmedphversconsultdpiphide = infosmedph.getjButton1();
    private JButton ajouterconsultation = infosmedph.getjButton4();
    private JButton ajouterprescription = infosmedph.getjButton6();
    private JButton ajouterprescription2 = ajouterprescri.getjButton1();
    
    
    private JButton retourActeInfIDEVersInfosMedIDE = aiide.getjButton4();
 
    private JButton ajouterprestation = infosmedph.getjButton5();
    private JButton annulermodifDPI = modifdpi.getjButton2();
    private JButton accueilprescriIDE = prescriptionide.getjButton3();
    private JButton retourPrescriIDEVersInfMedIDE = prescriptionide.getjButton4();
    private JButton accueilprescriPH = prescriptionph.getjButton3();
    private JButton retourPrescriPHVersInfMedPH = prescriptionph.getjButton4();
    private JButton retourDetailsPrestation = dp.getBoutonRetour();
    private JButton annulertransfert = transfert.getBoutonAnnuler();
    private JButton validermodifdpi = modifdpi.getjButton1();
    private JButton validerActe = ajouterai.getjButton2();
    private JButton validerPrescription = ajouterprescri.getjButton2();
    private JButton validerConsultation = ajouterconsult.getjButton2();
    private JButton ajouterprescriptiondansconsult = ajouterconsult.getjButton4();

    private JButton ajouterPersonnel = pl.getAjouterPersonnel();
    private JButton validerajoutpersonnel = cp.getBouttonValider();
    private JButton annulerajouterpersonnel = cp.getBouttonAnnuler();
    private JButton annulermodificationpersonnel = mp.getBouttonAnnuler();
    private JButton validerrmodificationpersonnel = mp.getBouttonValider();
    private JButton supprimerPersonnel = mp.getBouttonSupprimer();
    private JButton validerPrestation = ajouterpresta.getBouttonValider();
    private JButton envoyerResultats = dp.getEnvoyerResultat();
    private JButton annulerEnvoyerResultats = prestafaite.getBoutonAnnuler();
    private JButton validerEnvoyerResultats = prestafaite.getBoutonValider();
    private JButton accesResultats = consultdpiphide.getResultatsNonLus();
    private JButton retrouresultats = r.getFlecheRetour();
    private JButton retourR = dr.getBoutonAnnuler();
    private JButton resultatParPatientIDE = infosmedide.getResultats();
    private JButton resultatParPatientPH = infosmedph.getResultats();
    private JButton frelcheretourResultatsParPatient = rp.getFlecheRetour();
    private JButton retour = rc.getBoutonRetour();
    private JButton validerTransfert = transfert.getBouttonvalider();

    //Déclarations Tableaux
    private JTable tableauconsultdpis = consultdpis.getjTable1();
    private JTable tableauconsultdpiphide = consultdpiphide.getjTable1();
    private JTable tableauconsultinfmedph = infosmedph.getjTable3();
    private JTable tableauconsultinfmedide = infosmedide.getjTable3();
    private JTable tableauacteinfirmierinfmedph = infosmedph.getjTable2();
    private JTable tableauacteinfirmierinfmedide = infosmedide.getjTable2();
    private JTable tableauprescriinfmedide = infosmedide.getjTable1();
    private JTable tableauprescriinfmedph = infosmedph.getjTable1();
    private JTable tableauprestations = prestations.getTablePrestation();
    private JTable tableauPH = pl.getTablePH();
    private JTable tableauIDE = pl.getTableIDE();
    private JTable tableauMT = pl.getTableMT();
    private JTable tableauSA = pl.getTableSecretaire();
    private JTable resultats = r.getTablePrestation();
    private JTable tableresultatsparpatient = rp.getTablePrestation();

    public Fenetre() {
        //state = State.NONCO;
        add(connexion);
        this.setSize(1700, 830);

        //Connexion
        ListenerConnexion l = new ListenerConnexion(barreduhaut, connexion, consultdpis, consultdpiphide, prestations, this, pl);
        connexion.getjPasswordField1().addKeyListener(l);
        valider.addActionListener(l);
        //boutons
        creerDPI.addActionListener(new BoutonCreerDPI(consultdpis, creationdpi, this));
        validerDMA.addActionListener(new BoutonValiderDMA(consultdpis, this, creationdpi));
        getRecherchePatient2.addActionListener(new BoutonRecherchePatientPhEtIde(this, consultdpiphide));
        recherchePatient.addActionListener(new BoutonRecherchePatient(this, consultdpis));
        deconnexion.addActionListener(new BoutonDeconnexion(connexion, this, barreduhaut));
        annulercreationDPI.addActionListener(new BoutonRetourDPISVersConsulterDPISecretaire(this, consultdpis, dpis));
        retourDPIVersConsulterDPISecretaire.addActionListener(new BoutonRetourDPISVersConsulterDPISecretaire(this, consultdpis, dpis));
        modificationdpi.addActionListener(new BoutonModifierDPI(this, dpis, modifdpi));
        retourActeInfVersInfosMedPH.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        accueilActeInfirmierPH.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        annulerAjouterAI.addActionListener( new BoutonRetourIDEVersInfosMedIDE(this, infosmedide));
        annulerAjouterConsult.addActionListener(new BoutonDPIPHVersInfosMedPH(dpiph, infosmedph, this));
        annulerAjouterPresta.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        retourConsultPHVersInfosMedPH.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        retourActeInfIDEVersInfosMedIDE.addActionListener(new BoutonRetourIDEVersInfosMedIDE(this, infosmedide));
  
        annulerAjouterPrescri.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        retourConsultIDEVersInfosMedIDE.addActionListener(new BoutonRetourIDEVersInfosMedIDE(this, infosmedide));
        accueilconsultationide.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        accueilconsultationph.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        retourDPIIDEVersConsultDPIPHetIDE.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        dpiideversinfosmedide.addActionListener(new BoutonDPIIDEVersInfosMedIDE(dpiide, infosmedide, this));
        retourDPIPHVersConsultDPIPHetIDE.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide, dpiph,dpiide, barreduhaut));
        dpiphversinfosmedph.addActionListener(new BoutonDPIPHVersInfosMedPH(dpiph, infosmedph, this));
        dpiphverstransfert.addActionListener(new BoutonDPIPHVersTransfert(dpiph, transfert, this));
        retourinfosmedIDEVersDPIIDE.addActionListener(new BoutonRetourInfosMedIDEVersDPIIDE(dpiide, infosmedide, this));
        accueilinfosmedIDE.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        ajouteracteinf.addActionListener(new BoutonAjouterActeInfirmier(this, ajouterai, infosmedide,  barreduhaut));
        retourinfosmedPHversDPIPH.addActionListener(new BoutonRetourPHVersDPIPH(dpiph,this));
        accueilinfmedphversconsultdpiphide.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        ajouterconsultation.addActionListener(new BoutonAjouterConsultation(this, ajouterconsult, infosmedph, barreduhaut));
        ajouterprescription.addActionListener(new BoutonAjouterPrescription(this, ajouterprescri, infosmedph,  barreduhaut));
        ajouterprescription2.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        ajouterprestation.addActionListener(new BoutonAjouterPrestation(this, ajouterpresta, infosmedph, barreduhaut));
        annulermodifDPI.addActionListener(new BoutonRetourDPISVersConsulterDPISecretaire(this, consultdpis, dpis));
        accueilprescriIDE.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        retourPrescriIDEVersInfMedIDE.addActionListener(new BoutonRetourIDEVersInfosMedIDE(this, infosmedide));
        accueilprescriPH.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        retourPrescriPHVersInfMedPH.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        retourDetailsPrestation.addActionListener(new BoutonRetourDetailsPrestation(dp, prestations, this));
        annulertransfert.addActionListener(new BoutonRetourPHVersDPIPH(dpiph, this));
        validermodifdpi.addActionListener(new BoutonValiderModificationDPI(this, dpis, modifdpi));
        validerActe.addActionListener(new BoutonValiderActe(barreduhaut, infosmedide, this, ajouterai));
        validerPrescription.addActionListener(new BoutonValiderPrescription(ajouterprescri, infosmedph, this, barreduhaut));
        validerConsultation.addActionListener(new BoutonValiderConsultation(ajouterconsult, infosmedph, this, barreduhaut));
        ajouterprescriptiondansconsult.addActionListener(new BoutonAjouterPrescriptionDansConsult(this, ajouterprescri, infosmedph,  barreduhaut));
        ajouterPersonnel.addActionListener(new BoutonAjouterDuPersonnel(this, pl, cp, barreduhaut));
        validerajoutpersonnel.addActionListener(new BoutonValiderPersonnel(this, pl, cp));
        annulerajouterpersonnel.addActionListener(new BoutonAnnulerPersonnel(this, pl, cp));
        annulermodificationpersonnel.addActionListener(new BouttonAnnulerModifPersonnel(this, pl, mp));
        validerrmodificationpersonnel.addActionListener(new BoutonValiderModificationPersonnel(this, pl, mp));
        supprimerPersonnel.addActionListener(new BoutonSupprimerPersonnel(pl, mp, this));
        validerPrestation.addActionListener(new BoutonValiderDemandePrestation(ajouterpresta, infosmedph, barreduhaut, this, prestations));
        envoyerResultats.addActionListener(new BoutonEnvoyerResultats(prestafaite, dp, this));
        annulerEnvoyerResultats.addActionListener(new BoutonAnnulerResultats(prestafaite, dp, this));
        validerEnvoyerResultats.addActionListener(new BoutonValiderResultats(prestafaite, dp, this, barreduhaut, prestations, consultdpiphide, r));
        accesResultats.addActionListener(new BoutonAccederAuxResultats(r, consultdpiphide, barreduhaut, this));
        retrouresultats.addActionListener(new BoutonRetourVersConsulterDPIPHetIDE(this, consultdpiphide,dpiph, dpiide, barreduhaut));
        retourR.addActionListener(new BoutonRetourdetailsRversR(r, dr, this, barreduhaut));

     
        resultatParPatientIDE.addActionListener(new BoutonResultatsIde(rp, this, barreduhaut, infosmedide, infosmedph, l));
        resultatParPatientPH.addActionListener(new BoutonResultatsPh(rp, this, barreduhaut, infosmedide, infosmedph, l));
        frelcheretourResultatsParPatient.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        retour.addActionListener(new BoutonRetourPHVersInfosMedicalesPH(this, infosmedph,l));
        validerTransfert.addActionListener(new BoutonValiderTransfert(transfert, this, dpiph, consultdpiphide, barreduhaut));

// tableau
        tableauconsultdpis.addMouseListener(new TableauConsulterDPISecretaire(consultdpis, dpis, this, consultdpis.getjTable1()));
        tableauconsultdpiphide.addMouseListener(new TableauConsulterDPIPH(dpiph, dpiide, consultdpiphide, this, consultdpiphide.getjTable1(), l));
        tableauconsultinfmedph.addMouseListener(new TableauConsultationsInfosMedPH(infosmedph, consultationPH, this,  infosmedph.getjTable3()));
        tableauconsultinfmedide.addMouseListener(new TableauConsultationsInfosMedIDE(infosmedide, consultationide, this,  infosmedide.getjTable3()));
        tableauacteinfirmierinfmedph.addMouseListener(new TableauActesInfirmiersInfosMedPH(infosmedph, acteinfirmier, this,  infosmedph.getjTable2()));
        tableauacteinfirmierinfmedide.addMouseListener(new TableauActesInfirmiersInfosMedIDE(infosmedide, aiide, this, barreduhaut, infosmedide.getjTable2()));
        tableauprescriinfmedide.addMouseListener(new TableauPrescriptionsInfosMedIDE(infosmedide, prescriptionide, this,  infosmedide.getjTable1()));
        tableauprescriinfmedph.addMouseListener(new TableauPrescriptionsInfosMedPH(infosmedph, prescriptionph, this,  infosmedph.getjTable1()));
        tableauprestations.addMouseListener(new TableauPrestations(prestations, dp, this, prestations.getTablePrestation()));
        tableauconsultdpiphide.addMouseListener(new TableauConsulterIDE(dpiide, consultdpiphide, this, consultdpiphide.getjTable1(), l));
        tableauIDE.addMouseListener(new TableauIdeP(this, pl, mp, tableauIDE));
        tableauPH.addMouseListener(new TableauPhP1(this, pl, mp, tableauPH));
        tableauMT.addMouseListener(new TableauMTP(this, pl, mp, tableauMT));
        tableauSA.addMouseListener(new tableauSMP(this, pl, mp, tableauSA));
        resultats.addMouseListener(new affichageResultats(dr, r, this, resultats, barreduhaut));
        tableresultatsparpatient.addMouseListener(new TableauResultatParPatient(this, rc, rp, tableresultatsparpatient));
        
        
        
        
        

        //Confirmation pour quitter l'application 
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
        consultdpis.setVisible(false);
        consultdpiphide.setVisible(false);
        prestations.setVisible(false);
        acteinfirmier.setVisible(false);
        creationdpi.setVisible(false);
        ajouterai.setVisible(false);
        ajouterconsult.setVisible(false);
        consultationPH.setVisible(false);
        dpis.setVisible(false);
        infosmedph.setVisible(false);
        modifdpi.setVisible(false);
        dpiide.setVisible(false);
        ajouterpresta.setVisible(false);
        prestafaite.setVisible(false);
        transfert.setVisible(false);
        ajouterprescri.setVisible(false);
        dpiph.setVisible(false);
        infosmedide.setVisible(false);
        prescriptionph.setVisible(false);
        prescriptionide.setVisible(false);
        consultationide.setVisible(false);
        
        pl.setVisible(false);
        cp.setVisible(false);
        mp.setVisible(false);
        dp.setVisible(false);
        r.setVisible(false);
        dr.setVisible(false);
        rp.setVisible(false);
        rc.setVisible(false);
        aiide.setVisible(false);

    }

    public void totaliteFalse() {
        barreduhaut.setVisible(false);
        connexion.setVisible(false);
        this.panelVisibleFalse();
    }

    public void toutFalseSaufConnexion() {
        consultdpis.setVisible(false);
        consultdpiphide.setVisible(false);
        prestations.setVisible(false);
        acteinfirmier.setVisible(false);
        creationdpi.setVisible(false);
        ajouterai.setVisible(false);
        ajouterconsult.setVisible(false);
        consultationPH.setVisible(false);
        dpis.setVisible(false);
        infosmedph.setVisible(false);
        modifdpi.setVisible(false);
        dpiide.setVisible(false);
        ajouterpresta.setVisible(false);
        prestafaite.setVisible(false);
        transfert.setVisible(false);
        ajouterprescri.setVisible(false);
        dpiph.setVisible(false);
        infosmedide.setVisible(false);
        prescriptionph.setVisible(false);
        prescriptionide.setVisible(false);
        consultationide.setVisible(false);
        pl.setVisible(false);
        cp.setVisible(false);
        mp.setVisible(false);
        dp.setVisible(false);
        aiide.setVisible(false);
    }

}
