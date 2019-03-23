package nf.personnel;

import org.junit.Test;
import org.junit.Before;
import static bd.MethodeBD.executeQuery;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

public class personnelTest {

    @Before
    public void init() {
        System.out.println("before");
    }

        @Test
    public void testAjoutPerso()throws SQLException{
        Infirmier inf1= new Infirmier("StifineTest","Kawtar",2,2,"Anapathologie");

            ResultSet rs = executeQuery("SELECT * FROM ide WHERE idIDE=2");
            assertNotNull(rs);
            while(rs.next()) {
                inf1.AjouterSurBdIDE(inf1);
                assertEquals("StifineTest", rs.getString("Nom"));
            }

    }

    @Test
    public void testAjoutPH() throws SQLException {
        Medecin med1= new Medecin("StifineTest","Kawtar",1,1,"Anapathologie");
            ResultSet rs = executeQuery("SELECT * FROM praticienhospitaliers WHERE idPh ='" + 1 + "'");
            assertNotNull(rs);
            while(rs.next()) {
                med1.AjouterSurBdMedecin(med1);
                assertEquals("StifineTest", rs.getString("Nom"));
            }

    }


    @Test
    public void testAjoutMT() throws SQLException {
        MedicoTechnique med1= new MedicoTechnique("StifineTest","Kawtar",3,3);
        ResultSet rs = executeQuery("SELECT * FROM medicotechniques WHERE idMT ='" + 3 + "'");
        assertNotNull(rs);
        while(rs.next()) {
            med1.AjouterSurBdMedicoTechnique(med1);
            assertEquals("StifineTest", rs.getString("Nom"));
        }

    }

    @Test
    public void testAjoutTechnicien() throws SQLException {
        Technicien med1= new Technicien("StifineTest","Kawtar",4,4);
        ResultSet rs = executeQuery("SELECT * FROM technicien WHERE idTECH ='" + 4 + "'");
        assertNotNull(rs);
        while(rs.next()) {
            med1.AjouterSurBdTechnicien(med1);
            assertEquals("StifineTest", rs.getString("Nom"));
        }

    }

    @Test
    public void testAjoutSecretaire() throws SQLException {
        SecretaireMedical med1= new SecretaireMedical("StifineTest","Kawtar",5,5,"null");
        ResultSet rs = executeQuery("SELECT * FROM secretaireadministrative WHERE idSA ='" + 5 + "'");
        assertNotNull(rs);
        while(rs.next()) {
            med1.AjouterSurBdSecretaireMedical(med1);
            assertEquals("StifineTest", rs.getString("Nom"));
        }

    }




}
