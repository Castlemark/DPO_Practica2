package controlador;

import model.Partida;
import model.Serp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Propietario on 10/05/2017.
 */
public class Network extends Thread{
    private DataOutputStream doStream;
    private ObjectOutputStream doStreamO; // = new ObjectOutputStream(sClient.getOutputStream());
    private Scanner sc;
    private Serp serp;
    private DataInputStream diStream;
    private ObjectInputStream diStreamO;
    private Partida partida;

    public void connect(int port){
        port = 11111;


        try{
            Scanner sc = new Scanner(System.in);
            Socket sServer = new Socket("localhost", port);
            doStream = new DataOutputStream(sServer.getOutputStream());
            diStream = new DataInputStream(sServer.getInputStream());
            doStream.writeUTF(u.getLogin());
            System.out.println("L'usuari "+u.getLogin()+" està conectat!");
      //      ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
      //      ThreadRebre threadRebre = new ThreadRebre(diStream);

         /*   threadEnviar.start();
            threadRebre.start();*/

            threadEnviar.join();
            threadRebre.join();

            sServer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
