/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

public enum Service {
    MEDECINE("Médecine"),
    CHIRURGIE("Chirurgie"),
    GYNECOLOGIE("Gynécologie"),
    OBSTETRIQUE("Obstétrique");

    private String name = "";

    //Constructeur
    Service(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    }

