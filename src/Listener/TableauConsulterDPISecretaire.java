/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import NF.Sih;
import interfaces.ConsulterDPISecretaire;
import interfaces.DPISecretaire;
import interfaces.Fenetre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 *
 * @author Manon
 */
public class TableauConsulterDPISecretaire implements MouseListener {

    ConsulterDPISecretaire cdpis;
    DPISecretaire dpis;
    Fenetre fen;
    Sih sih;
    JTable table;

    public TableauConsulterDPISecretaire(ConsulterDPISecretaire cdpis, DPISecretaire dpis, Fenetre fen, Sih sih, JTable table) {
        this.cdpis = cdpis;
        this.dpis = dpis;
        this.fen = fen;
        this.sih = sih;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int NumLigne;
        NumLigne = table.getSelectedRow();

        fen.PanelVisibleFalse();
        fen.add(dpis);
        dpis.setVisible(true);
        fen.revalidate();
        fen.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {

        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
