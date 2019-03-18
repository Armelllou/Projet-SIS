package java.nf.patient;

import nf.patient.Adresse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Tests unitaires

public class AdresseTest {

    @Before
    public void init() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void codePostalTest() {
        Adresse adresse = new Adresse("test1", "test2", "test3");
        assertEquals("test1", adresse.getAdresse());
        //assertEquals("test2", adresse.getAdresse());

    }

}