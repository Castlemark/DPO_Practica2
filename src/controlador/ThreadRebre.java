package controlador;

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


    public ThreadRebre(ObjectInputStream diStreamO, Client model, VistaClient vista) {

        this.diStreamO = diStreamO;
        this.model = model;
        this.vista = vista;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Serp serp;
                System.out.println("dale");

                opcio = (String) diStreamO.readObject();

                switch (opcio) {
                    case "COMENÇA":

                        //començarPartida
                        vista.iniciaPartida();

                        break;
                    case "MOU":
                        //rebreSerp
                        serp = (Serp) diStreamO.readObject();
                        break;
                }

            }
        }catch(IOException e){
                e.printStackTrace();
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }

    }
}
