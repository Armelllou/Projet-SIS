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
public class DateH extends Date {
    
    private int heure;
    private int minutes;
    
    /**
     * Constructeur de la classe 
     * 
     * @param jour jour de la date
     * @param mois mois de la date
     * @param annee année de la date
     * @param heure heure de la date
     * @param minutes minutes de la date
     */
    public DateH(int jour, int mois, int annee,int heure,int minutes) {
       super(jour,mois,annee);
       this.heure=heure;
       this.minutes=minutes;
    }
    
    
    /**Méthode qui retourne la date sous forme de chaîne de caractère
     * 
     * @return la date sous chaîne de caractère 
     */
    public String toString() {
        return this.heure+":"+this.minutes+" "+this.getJour() + "/" + this.getMois() + "/" + this.getAnnee();
        }
    
    
     /**Méthode qui verifie que l'objet est égale à cette instance
     * 
     * @param o un objet 
     * @return un boolean en fonction de l'égalité 
     */
    public boolean equals(Object o) {
        if (o instanceof DateH) {
            DateH d = (DateH)o;
            return (getAnnee() == d.getAnnee()) && (getMois() == d.getMois()) && (getJour() == d.getJour()) &&(minutes==d.minutes)&&(heure==d.heure);
            }
        else
            return false;
        }
    
    /** Méthode qui retourne la différence entre 2 dates
     * 
     * @param o un Objet de type date 
     * @return la différence entre les 2 dates
     */
    public int compareTo(Object o) {
        DateH d = (DateH)o;
        if (this.getAnnee() != d.getAnnee()){
            
            return this.getAnnee() - d.getAnnee();}
        // ici on a forcement annee == d.annee :
        if (getMois() != d.getMois())
            return getMois()  - d.getMois();
        // ici on a forcement annee == d.annee et mois == d.mois :
        if (getJour() != d.getJour())
           return getJour() - d.getJour();
        if (heure != d.getHeure())
            return heure -d.getHeure();
        return minutes-d.getMinutes();
    }
    
    /**Méthode qui retourne la date de manière à l'inscrire grâce a InscriptionXML et pouvoir la relire avec LectureXML
     * 
     * @return une chaîne de caractère pour l'écriture XML 
     */
    public String toStringS() {
        return this.heure+":"+this.minutes+";"+this.getAnnee() + "-" + this.getMois() + "-" + this.getJour();
        }

    /**Méthode qui retourne l'heure
     * @return l'heure
     */
    public int getHeure() {
        return heure;
    }

    /**Méthode qui retourne les minutes
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }
    public boolean dateCorrect(){
        
        if(super.dateCorrect() && this.heure>=0 && this.minutes<60 && this.heure>=0 && this.heure<24){
            return true;
        }
        else
            return false;
    }
    
    
}
