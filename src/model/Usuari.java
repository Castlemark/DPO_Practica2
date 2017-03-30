package model;

/**
 * Created by Propietario on 30/03/2017.
 */
public class Usuari {
    private String login;
    private String mail;
    private String password;

    private boolean comprovaDades(String nomUsuari, String correu, String contrasenya, String confirmacioContra){
        return true;
    }

    private boolean registreUsuari(String nomUsuari, String correu, String contrasenya){
        return true;
    }

    private boolean iniciarSessio(String nomUsuariCorreu, String contrasenya){
        return true;
    }

    private boolean tancarSessio(){
        return true;
    }
}
