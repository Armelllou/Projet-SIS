/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Date;

/**
 *
 * @author annel
 */
public class Dates {
    /**Méthode qui retourne le jour de la date
     * 
     * @return le jour
     */
    public int getJour() {
        return jour;
    }

    /**Méthode qui retourne le mois de la date
     * @return le mois
     */
    public int getMois() {
        return mois;
    }

    /**Méthode qui retourne l'année de la date
     * @return l'annee
     */
    public int getAnnee() {
        return annee;
    }
    private int jour;
    private int mois;
    private int annee;
    
    /**
     * Constructeur de la classe
     * @param jour le jour de la date
     * @param mois le mois de la date
     * @param annee l'année de la date
     */
    public Dates(int jour, int mois, int annee) {
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    
    /**Méthode qui retourne la date sous forme de chaîne de caractère
     * 
     * @return la date sous chaîne de caractère 
     */
    public String toString() {
        return this.jour + "/" + this.mois + "/" + this.annee;
        }
    /**Méthode qui verifie que l'objet est égale à cette instance
     * 
     * @param o un objet 
     * @return un boolean en fonction de l'égalité 
     */
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date)o;
            return (annee == d.getYear()) && (mois == d.getMonth()) && (jour == d.getDay());
            }
        else
            return false;
        }
    
    // precondition : 'o' est une instance de 'Date' :
    
    /** Méthode qui retourne la différence entre 2 dates
     * 
     * @param o un Objet de type date 
     * @return la différence entre les 2 dates
     */
    public int compareTo(Object o) {
        Date d = (Date)o;
        if (this.annee != d.getYear())
            return this.annee - d.getYear();
        // ici on a forcement annee == d.annee :
        if (this.mois != d.getMonth())
            return this.mois  - d.getMonth();
        // ici on a forcement annee == d.annee et mois == d.mois :
       
           return this.jour - d.getDay();
        
    }
    
    /**Méthode qui retourne la date de manière à l'inscrire grâce a InscriptionXML et pouvoir la relire avec LectureXML
     * 
     * @return une chaîne de caractère pour l'écriture XML 
     */
    public String toStringS() {
        return this.annee + "-" + this.mois + "-" + this.jour;
        }
    
    
    /**Méthode qui vérifie que la date est correct
     * 
     * @return un boolean en fonction de si la date est correct
     */
    public boolean dateCorrect(){
        boolean rep=false;
        if((annee%4==0&&annee%100!=0)||annee%400==0){
            if(mois==1||mois==3||mois==5||mois==7||mois==8||mois==10||mois==12){
                if(jour>0&&jour<32){
                    rep=true;
                }
            }
            else if (mois==2){
                if(jour>0&&jour<30)
                  rep=true;
            }
            else{
                if(jour>0&&jour<31){
                   rep=true;
                }
            }
        }
        else{
            if(mois==1||mois==3||mois==5||mois==7||mois==8||mois==10||mois==12){
                if(jour>0&&jour<32){
                   rep=true;
                }
            }
            else if (mois==2){
                if(jour>0&&jour<29)
                    rep=true;
            }
            else{
                if(jour>0&&jour<31){
                    rep=true;
                }
            }
            
        }
        
        return rep;
    }
    
    }


