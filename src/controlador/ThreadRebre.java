package controlador;

import Client_Servidor.Network;
import Model.*;
import Model.Partida;
import Model.Serp;
import Vista.VistaClient;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by    Grup 6 on 13/04/2017.
 */
public class ThreadRebre extends Thread {
    private ObjectInputStream diStreamO;
    private Partida partida;
    private Client model;
    private ControladorJoc cj;
    String opcio = "";
    private VistaClient vista;
    private Network network;


    public ThreadRebre(ObjectInputStream diStreamO, Client model, VistaClient vista, Network network) {

        this.diStreamO = diStreamO;
        this.model = model;
        this.vista = vista;
        this.network = network;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("dale");

                opcio = (String) diStreamO.readObject();

                switch (opcio) {
                    case "COMENÇA":
                        System.out.println("comença partida");
                        //començarPartida
                        vista.iniciaPartida();

                        break;
                    case "MOU":
                        //rebreSerp
                        int jug = (int)diStreamO.readObject();
                        int dir = (int) diStreamO.readObject();
                        model.getPartida().mouSerp(dir, jug);
                        System.out.println("serp rebuda");

                        break;

                    case "JUGADOR":
                        String[] j = (String[])diStreamO.readObject();
                        vista.insereixJugador(j);
                        model.getPartida().setSerp((int)diStreamO.readObject());
                        break;
                    case "MORT":
                        vista.aturaPartida();
                        break;
                }

            }
        }catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }

    }
}
