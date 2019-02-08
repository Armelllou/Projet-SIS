/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Calendar;

class Ipp {

    private String ipp;

    //constructeur d'un IPP
    public Ipp() {
        Calendar date = Calendar.getInstance();

        // récupère la date et enlève 2000 pour avoir uniquement les deux derniers chiffres de la date
        int YY = (date.get(Calendar.YEAR)) - 2000;
        int day = date.get(Calendar.DAY_OF_MONTH);
        String MM = null;
        if (date.get(Calendar.MONTH) < 10) {
            MM = "0" + (date.get(Calendar.MONTH) + 1);
        }
        String XXXXX = IppCounter.getNextIpp();

        //création d'un string ipp
        ipp = String.valueOf(YY) + MM + XXXXX;
        System.out.println(ipp);
    }

    public String getIpp() {
        return ipp;
    }
}

