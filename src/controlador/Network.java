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
    private ControladorJoc controlador;

    private DataOutputStream doStream;
    private ObjectOutputStream doStreamO; // = new ObjectOutputStream(sClient.getOutputStream());
    private DataInputStream diStream;
    private ObjectInputStream diStreamO;

    private Partida partida;
    private Scanner sc;
    private Serp serp;



    public Network(ControladorJoc controlador){
        this.controlador = controlador;

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

    public DataOutputStream getDoStream() {
        return doStream;
    }

    public ObjectOutputStream getDoStreamO() {
        return doStreamO;
    }
}
