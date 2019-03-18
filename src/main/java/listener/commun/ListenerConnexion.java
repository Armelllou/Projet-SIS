/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener.commun;

import bd.ConnexionBD;
import bd.MethodeBD;
import interfaces.*;
import interfaces.ConsulterDPISecretaire;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenerConnexion implements ActionListener, KeyListener {

    private static State state;
    private Connexion c;
    private JPanel jp;
    private Fenetre jframe;
    private static BarreDuHaut bh;
    private ListePersonnel pl;

    private ConsulterDPIPHetIDE cdpiphetide;
    private ConsulterDPISecretaire as;
    private Prestations p;
    private static String service;

    public ListenerConnexion(BarreDuHaut bh, Connexion c, ConsulterDPISecretaire as, ConsulterDPIPHetIDE cdpiphetide, Prestations p, Fenetre jframe, ListePersonnel pl) {
        this.bh = bh;
        this.c = c;
        this.jframe = jframe;
        this.jp = jp;
        this.cdpiphetide = cdpiphetide;
        this.as = as;
        this.p = p;
        this.pl = pl;

    }

    public static String getBDHService() {
        return service;
    }

    public void connexion() throws SQLException {
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setLayout(new BorderLayout());
        jframe.panelVisibleFalse();
        if (connexionSecretaire()
                || ConnexionIde()
                || ConnexionPH()
                || ConnexionTechnicien()
                || ConnexionMedicoTechniques()) {

        }
        else{
            JOptionPane.showMessageDialog(null, "Identifiant ou mdp incorrect");

               RafraichitLesPanels rf = new RafraichitLesPanels(jframe,c);
        }

        switch (state) {
            case NONCO:

                return;
            case PH:
        }
    }

    private boolean Connexion(String query, JPanel jPanel) throws SQLException {
        PreparedStatement ps = ConnexionBD.getInstance().getConnexion().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            jframe.add(jPanel, BorderLayout.CENTER);
            jframe.add(bh, BorderLayout.NORTH);
            fillBh(rs);
            jframe.revalidate();
            jframe.repaint();
            return true;
        }
        return false;
    }

    public boolean ConnexionPH() throws SQLException {
        if (Connexion("Select * from praticienhospitaliers WHERE idPh ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", cdpiphetide)) {
            cdpiphetide.setVisible(true);
            this.state = State.PH;
            cdpiphetide.getjTable1().setFont(new Font("Calibri", 0, 18));
            cdpiphetide.getjTable1().setModel(MethodeBD.listePatientJTableServicePH(service)); // rempli la JTable avec les patients de la BD

            int nombre = MethodeBD.compterTableauPrestationParService(service);
            String notification = cdpiphetide.getNotification().getText();
            int notif = Integer.parseInt(notification);
            int increment = nombre;
            String notificationFinale = Integer.toString(increment);
            cdpiphetide.getNotification().setText(notificationFinale);
            return true;
        }

        return false;
    }

    public boolean ConnexionIde() throws SQLException {
        if (Connexion("Select * from ide WHERE idIDE ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", cdpiphetide)) {
            cdpiphetide.setVisible(true);
            this.state = State.IDE;
            cdpiphetide.getjTable1().setFont(new Font("Calibri", 0, 18));
            cdpiphetide.getjTable1().setModel(MethodeBD.listePatientJTableServiceIde(service)); // rempli la JTable avec les patients de la BD
            int nombre = MethodeBD.compterTableauPrestationParService(service);
            String notification = cdpiphetide.getNotification().getText();
            int notif = Integer.parseInt(notification);
            int increment = nombre;
            String notificationFinale = Integer.toString(increment);
            cdpiphetide.getNotification().setText(notificationFinale);
            return true;

        }
        return false;
    }

    public boolean connexionSecretaire() throws SQLException {
        if (Connexion("Select * from secretaireadministrative WHERE idSA ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", as)) {
            as.setVisible(true);
            this.state = State.IDE;
            return true;
        }
        return false;
    }

    public boolean ConnexionMedicoTechniques() throws SQLException {
        if (Connexion("Select * from medicotechniques WHERE idMT ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", p)) {
            p.setVisible(true);
            this.state = State.SM;
            return true;
        }
        return false;
    }

    public boolean ConnexionTechnicien() throws SQLException {
        if (Connexion("Select * from technicien WHERE idTech ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", pl)) {
            pl.setVisible(true);
            this.state = State.TECH;
            return true;
        }
        return false;
    }

    private void fillBh(ResultSet rs) throws SQLException {
        bh.getId().setText(rs.getString(1));
        bh.getMdp().setText(rs.getString(2));
        bh.getNom().setText(rs.getString(3));
        bh.getPrenom().setText(rs.getString(4));
        bh.getService().setText(rs.getString(5));
        service = rs.getString(5);

        bh.setVisible(true);
        bh.getId().setVisible(false);
        bh.getMdp().setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            connexion();
        } catch (SQLException ex) {
            Logger.getLogger(ListenerConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static State getState() {
        return state;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                connexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(ConnexionEntrerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
           }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
