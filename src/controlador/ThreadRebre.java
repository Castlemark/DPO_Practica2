package controlador;

import Model.Partida;
import Model.Serp;
import Model.Partida;
import Model.Serp;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;

/**
 * Created by Grup 6 on 13/04/2017.
 */
public class ThreadRebre extends Thread {
        private DataInputStream diStream;
        private ObjectInputStream diStreamO;
        private Partida partida;

    public ThreadRebre(DataInputStream diStream, ObjectInputStream diStreamO, Partida partida) {

        this.diStream = diStream;
        this.diStreamO = diStreamO;
        this.partida = partida;
    }

    @Override
    public void run(){
        while(true){
            Serp serp = null;
            try {
                serp = (Serp) diStreamO.readObject();


            } catch (EOFException e ){
                break;

            } catch (IOException e) {
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}