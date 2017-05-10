package model;

import controlador.ThreadEnviar;
import controlador.ThreadRebre;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by Propietario on 24/04/2017.
 */
public class Client {
    private Usuari usuari;
    private Partida partida;

    public Client (){
        partida = new Partida();
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public boolean conectar(String ip, int port){
        /*try{

            Socket sServer = new Socket(ip , port);
            DataOutputStream doStream = new DataOutputStream(sServer.getOutputStream());
            DataInputStream diStream = new DataInputStream(sServer.getInputStream());
            doStream.writeUTF(u.getLogin());
            System.out.println("L'usuari "+u.getLogin()+" està conectat!");
            ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
            ThreadRebre threadRebre = new ThreadRebre(diStream);

            threadEnviar.start();
            threadRebre.start();

            threadEnviar.join();
            threadRebre.join();

            sServer.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        return true;

    }
}
