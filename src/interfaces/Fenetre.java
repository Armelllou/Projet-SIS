/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Manon
 */
public class Fenetre extends JFrame {

    // Déclaration de tous les JPanel
    Connexion c = new Connexion();
    AccueilSecretaire as = new AccueilSecretaire();
    
    // Attributs de la JFrame
    Fenetre frame = this;
    BarreDuHaut barre = new BarreDuHaut();
    
    
    // Déclarations Boutons, JTextField etc
    private JButton valider = c.getjButton1();
    
    
    
    public Fenetre(){
        //state = State.NONCO;
        add(c);
        
    }
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);

            }
        });
    }
    
}
