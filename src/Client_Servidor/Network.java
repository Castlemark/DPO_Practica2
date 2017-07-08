package Client_Servidor;

import Model.*;
import Model.Client;
import Model.Partida;
import Model.Serp;
import Model.Usuari;
import Vista.VistaClient;
import Vista.VistaJoc;
import controlador.ThreadRebre;

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

    private ThreadRebre tr;

    private Partida partida;
    private VistaClient vista;
    private Scanner sc;
    private Serp serp;

    private boolean running;

    

    public Network(Client model, VistaClient vista){
        this.model = model;
        this.vista = vista;
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

    public ObjectOutputStream getDoStreamO() {
        return doStreamO;
    }

    public ObjectInputStream getDiStreamO() {
        return diStreamO;
    }

    public void iniciaRebre(){
        tr = new ThreadRebre(/*diStreamO, */model, vista, this);
        tr.start();
    }

    public String getMessage() throws IOException, ClassNotFoundException{
       return (String) diStreamO.readObject();
    }
}
