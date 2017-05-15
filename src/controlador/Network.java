package controlador;

import model.Client;
import model.Partida;
import model.Serp;
import model.Usuari;

import java.io.*;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

/**
 * Created by Propietario on 10/05/2017.
 */
public class Network extends Thread{
    private Client model;

    private DataOutputStream doStream;
    private ObjectOutputStream doStreamO; // = new ObjectOutputStream(sClient.getOutputStream());
    private DataInputStream diStream;
    private ObjectInputStream diStreamO;

    private Partida partida;
    private Scanner sc;
    private Serp serp;

    private boolean running;



    public Network(Client model){
        this.model = model;
        running = true;

    }

    public void connect(int port){
        port = 11111;


        try{
            sc = new Scanner(System.in);
            Socket sServer = new Socket("localhost", port);

            doStream = new DataOutputStream(sServer.getOutputStream());
            diStream = new DataInputStream(sServer.getInputStream());

            System.out.println("esta conectat");
      //      ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
      //      ThreadRebre threadRebre = new ThreadRebre(diStream);

         /*   threadEnviar.start();
            threadRebre.start();*/

            //sServer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (running){


        }
    }

    public void registraUsuari(Usuari usuari) throws IOException{

        doStreamO.writeObject(usuari);

    }

    public DataOutputStream getDoStream() {
        return doStream;
    }

    public ObjectOutputStream getDoStreamO() {
        return doStreamO;
    }
}
