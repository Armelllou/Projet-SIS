/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listener.BoutonCreeDP;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Manon
 */
public class Fenetre extends JFrame {

   
    
    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barre = new BarreDuHaut();
    
    
     // Déclaration de tous les JPanel
    Connexion c = new Connexion();
    AccueilSecretaire as = new AccueilSecretaire();
    CreationDPI cdpi = new CreationDPI();
    
    // Déclarations Boutons, JTextField etc
    private JButton valider = c.getjButton1();
    private JButton creerDP = as.getjButton1();
    private JButton consulterDP = as.getjButton2();
    
    
    
    
    public Fenetre(){
        //state = State.NONCO;
        add(c);
        this.setSize(1700,830);
        
        
         BoutonCreeDP.addActionListener(new BoutonCreeDP(as,cdpi, this));
    }
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);

            }
        });
    }
    
    public void toutFalse(){
        c.setVisible(false);
        as.setVisible(false);
        cdpi.setVisible(false);
        
    }
    
    public void setState(State state) {
        //this.state = state;
    }
    
    public State getStates() {
        //return state;
        return null;
    }

    
}
