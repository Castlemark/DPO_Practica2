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
                        Posicio cap = (Posicio)diStreamO.readObject();
                        model.getPartida().mouSerp(dir, cap, jug);
                        System.out.println("serp rebuda");

                        break;

                    case "JUGADOR":
                        String[] j = (String[])diStreamO.readObject();
                        vista.insereixJugador(j);
                        int k = (int)diStreamO.readObject();
                        System.out.println(k);
                        model.getPartida().setSerp(k);
                        vista.insereixRondes(model.getPartida().getRondes());
                        break;
                    case "MORT":
                        model.getPartida().getSerps().get((int) diStreamO.readObject()).setViu(false);
                        break;

                    case "PUNTS":
                        vista.aturaPartida();
                        vista.setPos((String) diStreamO.readObject());
                        vista.setPunts((int) diStreamO.readObject());
                        int guanyador = (int) diStreamO.readObject();
                        if(guanyador > -1){
                            model.getPartida().setRondes(guanyador);
                        }
                        vista.insereixRondes(model.getPartida().getRondes());
                        break;
                    case "ELIMINAT":
                        cj.setEliminats((boolean[]) diStreamO.readObject());
                        System.out.println("Estas eliminat");
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
