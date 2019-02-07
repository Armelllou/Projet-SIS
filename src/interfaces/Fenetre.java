/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listener.BoutonCreeDP;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Manon
 */
public class Fenetre extends JFrame {

    // Déclaration de tous les JPanel
    Connexion connexion = new Connexion();
    AccueilSecretaire accueilsecretaire = new AccueilSecretaire();
    CreationDPI creationdpi = new CreationDPI();
    ConsulterDPI consultdpi = new ConsulterDPI();

    
    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barreduhaut = new BarreDuHaut();
    
    
    // Déclarations Boutons, JTextField etc
    private JButton valider = connexion.getjButton1();
    private JButton creerDPI = accueilsecretaire.getjButton1();
    private JButton consulterDPI = accueilsecretaire.getjButton2();
    
    
    
    
    public Fenetre(){
        //state = State.NONCO;
        add(connexion);
        this.setSize(1700,830);
        
        creerDPI.addActionListener(new BoutonCreeDP(accueilsecretaire, creationdpi, this));

        
        
        
        
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
    
    public void PanelVisibleFalse(){
        connexion.setVisible(false);
        accueilsecretaire.setVisible(false);
        creationdpi.setVisible(false);
        consultdpi.setVisible(false);
        
    }
    
    public void TotaliteFalse(){
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
