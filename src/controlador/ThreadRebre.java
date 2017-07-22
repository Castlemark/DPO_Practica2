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
 * Created by Grup 6 on 03/05/2017 ThreadRebre.
 * Classe que hereda de Thread i es comunica amb el servidor per passar els paràmetres del joc
 */
public class ThreadRebre extends Thread {
    private ObjectInputStream diStreamO;
    private Partida partida;
    private Client model;
    private ControladorJoc cj;
    private String opcio = "";
    private VistaClient vista;
    private Network network;

    /**
     * Constructor
     * @param diStreamO ObjectInputStream
     * @param model     Model
     * @param vista     Vista
     * @param network   Network
     * @param cj        Controlador del joc
     */
    public ThreadRebre(ObjectInputStream diStreamO, Client model, VistaClient vista, Network network, ControladorJoc cj) {

        this.diStreamO = diStreamO;
        this.model = model;
        this.vista = vista;
        this.network = network;
        this.cj = cj;
    }

    /**
     * Mètode run encarregat d'executar el Thread
     */
    @Override
    public void run() {

        try {
            while (true) {

                opcio = (String) diStreamO.readObject();

                switch (opcio) {
                    case "COMENÇA":
                        for(int i = 0; i < 4; i++){
                            System.out.println(model.getEliminats()[i]);
                        }
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

                    case "JUGADOR":     //afegir jugador
                        String[] j = (String[])diStreamO.readObject();
                        vista.insereixJugador(j);
                        int k = (int)diStreamO.readObject();
                        System.out.println(k);
                        model.getPartida().setSerp(k);
                        vista.insereixRondes(model.getPartida().getRondes());
                        break;

                    case "MORT":        //mort
                        model.getPartida().getSerps().get((int) diStreamO.readObject()).setViu(false);
                        break;

                    case "PUNTS":       //rebre punts
                        System.out.println("Rep punts");
                        vista.setPos((String) diStreamO.readObject());
                        vista.setPunts((int) diStreamO.readObject());
                        vista.getJoc().setTotal((int) diStreamO.readObject());
                        int guanyador = (int) diStreamO.readObject();
                        vista.aturaPartida();
                        if(guanyador > -1){
                            model.getPartida().setRondes(guanyador);
                        }
                     //   model.elimina(eliminat);              BORRAR!
                        vista.insereixRondes(model.getPartida().getRondes());
                        break;
                    case "ELIMINAT":
                        /*int num=0;                        //BORRAR!
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
                    case "ABANDONAT": //En prèmer el botó abandona
                        cj.reinicia();
                        model.abandonaPartida();
                        vista.reinicia();
                        break;

                    case "RANQUING":        //Mostrar el rànquing rebut del servidor
                        vista.getRanquing().setRanquing((String) diStreamO.readObject());
                        System.out.println("ranquing rebut");
                        break;

                    case "ENVIACONTROLS":       //Establir els controls rebuts del servidor
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
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }
    }
}
