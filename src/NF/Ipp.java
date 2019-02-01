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
   String MM="null";
   int XXXXX;
   int i ;
  
   String ipp;
   
   Date d = new Date();

     Calendar date = Calendar.getInstance();
   
    public Ipp() {     
YY =(date.get(Calendar.YEAR))-2000;

MMint=date.get(Calendar.MONTH);
if(MMint==1){
    MM="01";
}
if(MMint==2){
    MM="02";
}
if(MMint==3){
    MM="03";
}
if(MMint==4){
    MM="04";
}
if(MMint==5){
    MM="05";
}
if(MMint==6){
    MM="06";
}
if(MMint==7){
    MM="07";
}
if(MMint==8){
    MM="08";
}
if(MMint==9){
    MM="09";
}
       
for (i=0; i<=99999;i++){
    
 XXXXX=i;
}
  

        System.out.println(YY+MM+XXXXX);
       }
}
