/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.listener;

import main.java.bd.ConnexionBD;
import main.java.interfaces.*;
import main.java.interfaces.secretaire.ConsulterDPISecretaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenerConnexion implements ActionListener {

    private State state;
    private Connexion c;
    private JPanel jp;
    private Fenetre jframe;
    private BarreDuHaut bh;

    private ConsulterDPIPHetIDE cdpiphetide;
    private ConsulterDPISecretaire as;
    private Prestations p;

    public ListenerConnexion(BarreDuHaut bh, Connexion c, ConsulterDPISecretaire as, ConsulterDPIPHetIDE cdpiphetide, Prestations p, Fenetre jframe) {
        this.bh = bh;
        this.c = c;
        this.jframe = jframe;
        this.jp = jp;
        this.cdpiphetide = cdpiphetide;
        this.as = as;
        this.p = p;

    }

    public String getBDHService() {
        return bh.getService().getText();
    }

    public void connexion() throws SQLException {
        if(connexionSecretaire()
        || ConnexionIde()
        || ConnexionPH()
        || ConnexionMedicoTechniques()) {
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jframe.setLayout(new BorderLayout());
            jframe.PanelVisibleFalse();
        }

        switch(state){
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
            return true;
        }
        return false;
    }

    public boolean ConnexionIde() throws SQLException {
        if (Connexion("Select * from ide WHERE idIDE ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", cdpiphetide)) {
            cdpiphetide.setVisible(true);
            this.state = State.IDE;
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
        if (Connexion("Select * from medicoTechniques WHERE idMT ='" + c.getjTextField1().getText() + "'and motDePasse='" + c.getjPasswordField1().getText() + "'", p)) {
            p.setVisible(true);
            this.state = State.IDE;
            return true;
        }
        return false;
    }

    private void fillBh(ResultSet rs) throws SQLException {
        bh.getId().setText(rs.getString(1));
        bh.getMdp().setText(rs.getString(2));
        bh.getNom().setText(rs.getString(3));
        bh.getPrenom().setText(rs.getString(4));
        bh.getService().setText(rs.getString(5)); // attention medico praticien bug nullpointer surement
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
        }
    }
}
