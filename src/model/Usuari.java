package model;

/**
 * Created by Propietario on 30/03/2017.
 */
public class Usuari {
    private String login;
    private String mail;
    private String password;

    public Usuari (){

    }
    public Usuari(String login, String mail, String password){

    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

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
