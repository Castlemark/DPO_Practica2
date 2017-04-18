package controlador;

import model.Usuari;

/**
 * Main del controlador del Client del Troner
 * Created by Grup 6 on 15/03/2017.
 */
public class Main {
    public static void main (String[] args){
        Usuari u = new Usuari();
        u.registreUsuari();
    }
}
