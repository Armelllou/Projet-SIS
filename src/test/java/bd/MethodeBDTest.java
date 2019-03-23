package bd;

import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import static bd.MethodeBD.*;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;


public class MethodeBDTest {

    @Test
    public void supprimerIide() throws SQLException {
        SupprimerSurBdIDE(2);
        ResultSet rs = executeQuery("SELECT * FROM ide WHERE idIDE=2");
        assertNotNull(rs);
        while (rs.next()) {
            assertTrue(rs.getString("Nom").isEmpty());
        }

    }
    @Test
    public void supprimerIPH() throws SQLException {
        SupprimerSurBdPH(1);
        ResultSet rs = executeQuery("SELECT * FROM praticienhospitaliers WHERE idPh ='" + 1 + "'");
        assertNotNull(rs);
        while (rs.next()) {
            assertTrue(rs.getString("Nom").isEmpty());
        }

    }

    @Test
    public void supprimerMT() throws SQLException {
        SupprimerSurBdMedichoTech(3);
        ResultSet rs = executeQuery("SELECT * FROM medicotechniques WHERE idMT ='" + 3 + "'");
        assertNotNull(rs);
        while (rs.next()) {
            assertTrue(rs.getString("Nom").isEmpty());
        }

    }

    @Test
    public void supprimertechnicien() throws SQLException {
        SupprimerSurBdTechnicien(4);
        ResultSet rs = executeQuery("SELECT * FROM technicien WHERE idTECH ='" + 4 + "'");
        assertNotNull(rs);
        while (rs.next()) {
            assertTrue(rs.getString("Nom").isEmpty());
        }

    }

    @Test
    public void supprimerSecretaire() throws SQLException {
        SupprimerSurBdSecretaire(5);
        ResultSet rs = executeQuery("SELECT * FROM secretaireadministrative WHERE idSA ='" + 5 + "'");
        assertNotNull(rs);
        while (rs.next()) {
            assertTrue(rs.getString("Nom").isEmpty());
        }

    }


}
