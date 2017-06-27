package controlador;

import Model.*;
import Model.Partida;
import Model.Serp;

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
    private DataInputStream diStream;
    private ObjectInputStream diStreamO;
    private Partida partida;
    private Client model;
    private ControladorJoc cj;

    public ThreadRebre(DataInputStream diStream, ObjectInputStream diStreamO, Partida partida) {

        this.diStream = diStream;
        this.diStreamO = diStreamO;
        this.partida = partida;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int opcio;
                Serp serp;

                opcio = diStream.readInt();

                switch (opcio) {
                    case 1:
                        //començarPartida
                        ArrayList<Serp> serps;
                        serps = (ArrayList<Serp>) diStreamO.readObject();
                        model.setPartida(partida = new Partida(serps));

                        break;
                    case 2:
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
