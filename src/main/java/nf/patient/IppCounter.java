package nf.patient;

import bd.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;

public class IppCounter {

    private static int month = 0;
    private static int ippCounter = 0;

    /**
     * Méthode qui permet de remettre à zero l'ipp chaque mois
     *
     * @return un Ipp de type String
     */
    public static String getNextIpp() throws SQLException {
        Calendar date = Calendar.getInstance();
        if (month != date.get(Calendar.MONTH)) {
            ippCounter = 0;
            month = date.get(Calendar.MONTH);
        }

        // incrémente le chiffre à la création de chaque nombre de patient

        // if (ippCounter !=0){
        ConnexionBD conn = ConnexionBD.getInstance();
        String Sql1 = "Select max(IPP) from patient";
        PreparedStatement ps = conn.getConnexion().prepareStatement(Sql1);
        ResultSet resultSet = ps.executeQuery();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {

                }
                String columnValue = resultSet.getString(i);
                String columnInteressant = columnValue.substring(5);
                //System.out.print(columnInteressant);
                int ipp = Integer.parseInt(columnInteressant);
                ippCounter = ipp;
            }//}

        }
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
