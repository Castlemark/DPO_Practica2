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

    public ThreadRebre(ObjectInputStream diStreamO, Client model, VistaClient vista, Network network, ControladorJoc cj) {

        this.diStreamO = diStreamO;
        this.model = model;
        this.vista = vista;
        this.network = network;
        this.cj = cj;
    }

    @Override
    public void run() {

        try {
            while (true) {

                opcio = (String) diStreamO.readObject();

                switch (opcio) {
                    case "COMENÇA":
                        System.out.println("Comença partida amb la serp " + model.getPartida().getSerp());
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
                        System.out.println("Rep punts");
                        vista.aturaPartida();
                        vista.setPos((String) diStreamO.readObject());
                        vista.setPunts((int) diStreamO.readObject());
                        vista.getJoc().setTotal((int) diStreamO.readObject());
                        int guanyador = (int) diStreamO.readObject();
                        if(guanyador > -1){
                            model.getPartida().setRondes(guanyador);
                        }
                     //   model.elimina(eliminat);
                        vista.insereixRondes(model.getPartida().getRondes());
                        break;
                    case "ELIMINAT":
                        /*int num=0;
                        for(int i = 0; i < eliminats.length; i++){
                            if(eliminats[i]){
                                num++;
                            }
                        }
                        System.out.println(" Hi han eliminats" + num);*/
                        int n = (int) diStreamO.readObject();
                        for (int i= 0; i < n; i++){
                            int eliminat = (int) diStreamO.readObject();
                            model.elimina(eliminat);
                        }
                        System.out.println("Estas eliminat");
                        break;
                    case "ABANDONAT":
                        cj.reinicia();
                        model.abandonaPartida();
                        vista.reinicia();
                        break;

                    case "RANQUING":
                        vista.getRanquing().setRanquing((String) diStreamO.readObject());
                        System.out.println("ranquing rebut");
                        break;

                    case "ENVIACONTROLS":
                        int[] controls = new int[4];
                        controls[0] = (int) diStreamO.readObject();
                        controls[1] = (int) diStreamO.readObject();
                        controls[2] = (int) diStreamO.readObject();
                        controls[3] = (int) diStreamO.readObject();
                        System.out.println(controls[0]);
                        vista.actualitzaControls(controls);
                        vista.actualitzaTecles(controls);
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
