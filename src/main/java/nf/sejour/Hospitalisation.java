package nf.sejour;

import bd.ConnexionBD;
import nf.patient.Patient;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Hospitalisation {
    private String dateEntree;
    private String dateSortie;


    public Hospitalisation(String dateEntree, String dateSortie) {
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }

    public static boolean AjouterPatientHospitalisation(Patient p) throws SQLException {
        boolean j = false;
        ConnexionBD conn = ConnexionBD.getInstance();
        String sql = " INSERT INTO hospitalisation (IPP) VALUES(?) ";
        PreparedStatement statement = conn.getConnexion().prepareStatement(sql);
        statement.setObject(1, p.getIpp().getIpp(), Types.INTEGER);
        statement.executeUpdate();
        j = true;
        return j;
    }

}