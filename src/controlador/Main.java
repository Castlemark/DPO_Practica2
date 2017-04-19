package controlador;

import model.Usuari;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Main del controlador del Client del Troner
 * Created by Grup 6 on 15/03/2017.
 */
public class Main {
    public static void main (String[] args){
        Usuari u = new Usuari();
        u.registreUsuari();
        try{
            Scanner sc = new Scanner(System.in);
            Socket sServer = new Socket("localhost", 10000);
            DataOutputStream doStream = new DataOutputStream(sServer.getOutputStream());
            DataInputStream diStream = new DataInputStream(sServer.getInputStream());
            doStream.writeUTF(u.getLogin());
            System.out.println("El usuari "+u.getLogin()+" està conectat!");
            ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
            ThreadRebre threadRebre = new ThreadRebre(diStream);

            threadEnviar.start();
            threadRebre.start();

            threadEnviar.join();
            threadRebre.join();

            sServer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
