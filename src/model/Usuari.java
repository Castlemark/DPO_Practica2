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
        if(nomUsuari.isEmpty()){
            return false;
        }
        if(correu.isEmpty()){
            return false;
        }else{
            int j = 0;
            for (int i = 0; i < correu.length(); i++){
                switch(correu.charAt(i)){
                    case ' ':
                        return false;
                    case '@':
                        j = i;
                        if(i == 0 && j != 0) return false;
                    case '.':
                        if(!(j < i && j != 0 && correu.length() > j)) return false;
                }
            }
        }
        if(contrasenya.isEmpty()) return false;
        if(confirmacioContra.isEmpty()) return false;
        if(contrasenya.equals(confirmacioContra)) return true;
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
