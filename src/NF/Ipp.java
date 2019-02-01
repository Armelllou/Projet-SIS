/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Calendar;
import java.util.Date;

/**
 * @author annel
 */
class Ipp {

    int YY;
    int MMint;
    String MM = "null";
    private static int XXXXXint;
    String XXXXX = "null";
    int i;
   
  int day;
    
   String ipp;
   
    Calendar date = Calendar.getInstance();

//constructeur d'un IPP
    public Ipp() {
// récupère la date et enlève 2000 pour avoir uniquement les deux derniers chiffres de la date
        YY = (date.get(Calendar.YEAR)) - 2000;

// récupère le mois et le transforme en string en lui ajoutant 0 pour faire format MM
        MMint = date.get(Calendar.MONTH);
        MMint +=1;
        if (MMint < 10) {
            MM = "0";
            MM += (String.valueOf(MMint));
        }   
       
      day = date.get(Calendar.DAY_OF_MONTH);
      
       
      i=XXXXXint;
      i=i+1;
      
       if (day==1 && i>=0 ){
            i=(i+1);
       }
       
        if (day==1 && i!=0 ){
           i=0;
       }
        
         if (day!=1 ){
           i=i+1;
       }
       
// incrémente le chiffre à la création de chaque nombre de patient (ne change pas encore pour chaque mois) 

// rajoute des zéros pour le format
            if (XXXXXint < 10) {
                XXXXX = "0000";
                XXXXX += String.valueOf(XXXXXint);
            }
            if (XXXXXint >= 10 && XXXXXint < 100) {
                XXXXX = "000";
                XXXXX += String.valueOf(XXXXXint);
            }
            if (XXXXXint >= 100 && XXXXXint < 1000) {
                XXXXX = "00";
                XXXXX += String.valueOf(XXXXXint);
            }
            if (XXXXXint >= 1000 && XXXXXint < 10000) {
                XXXXX = "0";
                XXXXX += String.valueOf(XXXXXint);
            }
            
            
//création d'un string ipp
            ipp = String.valueOf(YY);
            ipp += MM;
            ipp += XXXXX; 
            
        System.out.println(ipp);
        System.out.println(i);
            System.out.println(day);
        }
    
 
    
    }

