/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf.personnel;


import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import nf.personnel.Infirmier;


/**
 *
 * @author stifinekawtar
 */
public class ajouterPersonnel {
    @Test
     public void testAjoutPerso(Personnel p){
         Personnel inf1= new Infirmier("Stifine","Kawtar",12345,12345,"Anapathologie");
     }
}
