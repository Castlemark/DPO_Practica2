package Client_Servidor;

import Model.*;
import Model.Client;
import Model.Partida;
import Model.Serp;
import Model.Usuari;

import java.io.*;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

/**
 * Created by Propietario on 10/05/2017.
 */
public class Network extends Thread{
    private Client model;

    private ObjectOutputStream doStreamO;
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

            doStreamO = new ObjectOutputStream(sServer.getOutputStream());
            diStreamO = new ObjectInputStream(sServer.getInputStream());

      //      ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
      //      ThreadRebre threadRebre = new ThreadRebre(diStream);

         /*   threadEnviar.start();
            threadRebre.start();*/

            //sServer.close();

            System.out.println("esta conectat");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (running){


        }
    }

    public boolean registraUsuari(Usuari usuari) throws IOException, ClassNotFoundException{

        doStreamO.writeObject(usuari);
        return  (Boolean) diStreamO.readObject();    }

    public boolean iniciaSessio(Inicia inicia) throws IOException, ClassNotFoundException{

        doStreamO.writeObject(inicia);
        return  (Boolean) diStreamO.readObject();
    }

    public void avisaServer(String which) throws IOException{
        System.out.println("avisa");
        doStreamO.writeObject(which);
    }

    public ObjectOutputStream getDoStream() {
        return doStreamO;
    }

    public ObjectOutputStream getDoStreamO() {
        return doStreamO;
    }
}
