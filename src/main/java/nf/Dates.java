/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

public class Dates {
    private String jour;
    private String mois;
    private String annee;

    /**
     * Constructeur de la classe
     *
     * @param jour  le jour de la date
     * @param mois  le mois de la date
     * @param annee l'année de la date
     */
    public Dates(String jour, String mois, String annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    /**
     * Méthode qui retourne le jour de la date
     *
     * @return le jour
     */
    public String getJour() {
        return jour;
    }

    /**
     * Méthode qui retourne le mois de la date
     *
     * @return le mois
     */
    public String getMois() {
        return mois;
    }

    /**
     * Méthode qui retourne l'année de la date
     *
     * @return l'annee
     */
    public String getAnnee() {
        return annee;
    }

}