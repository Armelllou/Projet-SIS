/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author annel
 */
public class Localisation {
    Lit lit;
    Chambre chambre;
    Service serviceGeographique;
    Service serviceResponsbale;

    public Localisation(Lit lit, Chambre chambre, Service serviceGeographique, Service serviceResponsbale) {
        this.lit = lit;
        this.chambre = chambre;
        this.serviceGeographique = serviceGeographique;
        this.serviceResponsbale = serviceResponsbale;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Service getServiceGeographique() {
        return serviceGeographique;
    }

    public void setServiceGeographique(Service serviceGeographique) {
        this.serviceGeographique = serviceGeographique;
    }

    public Service getServiceResponsbale() {
        return serviceResponsbale;
    }

    public void setServiceResponsbale(Service serviceResponsbale) {
        this.serviceResponsbale = serviceResponsbale;
    }
    
    
    
    
    
}
