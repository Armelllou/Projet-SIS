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
class Chambre {
     int[] num;

    public Chambre(int num[]) {
        
         if(num.length==3&&num[0]>=0&&num[0]<=9&&num[1]>=0&&num[1]<=9&&num[2]>=0&&num[2]<=9){
             this.num=num;
         }
         else System.out.println("Le numéro de chambre est inconnu");
   
       }
        
}
