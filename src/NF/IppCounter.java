package NF;

import java.util.Calendar;



public class IppCounter {

    private static int month = 0;
    private static int ippCounter = 0;


    /**Méthode qui permet de remettre à zero l'ipp chaque mois
     * @return un Ipp de type String
     */

    public static String getNextIpp() {
        Calendar date = Calendar.getInstance();
        if (month != date.get(Calendar.MONTH)) {
            ippCounter = 0;
            month = date.get(Calendar.MONTH);
        }
        // incrémente le chiffre à la création de chaque nombre de patient
        ippCounter += 1;

        // ajoute des zéros pour le format
        String counter = null;
        if (ippCounter < 10) {
            counter = "0000" + ippCounter;
        }
        if (ippCounter >= 10 && ippCounter < 100) {
            counter = "000" + ippCounter;
        }
        if (ippCounter >= 100 && ippCounter < 1000) {
            counter = "00" + ippCounter;
        }
        if (ippCounter >= 1000 && ippCounter < 10000) {
            counter = "0" + ippCounter;
        }
        return counter;
    }
}
