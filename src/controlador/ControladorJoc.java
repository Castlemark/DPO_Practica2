package controlador;

import Client_Servidor.Network;
import Model.Client;
import Model.Partida;
import Vista.VistaClient;
import Vista.VistaJoc;
import Model.Serp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Propietario on 03/05/2017.
 */
public class ControladorJoc implements ActionListener {
    private VistaJoc vistaJoc;
    private Client model;
    private char c;
    private int contador;
    private Network network;
    private int fi;
    private VistaClient vista;

    public ControladorJoc(VistaClient vista, VistaJoc vistaJoc, Client model, Network network){
        this.vistaJoc = vistaJoc;
        this.vista = vista;
        this.model = model;
        contador = 4;
        this.network = network;
        fi = 5;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            switch (e.getActionCommand()){
                case "ABANDONA":
                    model.abandonaPartida();
                    fi = 5;
                    contador = 4;
                    vista.reinicia();
                    vista.changePanel("RANQUING");
                    network.avisaServer("ABANDONA");
                    break;
                case "TIMER":
                    if(vistaJoc.isCont()){
                        contador--;
                        //      System.out.println(contador);

                        if(contador <= 0){
                            vistaJoc.setCont(false);
                        }
                    }else{

                   for(int i = 0; i< model.getPartida().getSerps().size(); i++) {
                       if(model.getPartida().getSerps().get(i).isViu() && !model.getEliminats()[i]){
                           model.getPartida().getSerps().get(i).mouSerp();
                       }
                   }
                   if(model.getPartida().getSerps().get(model.getPartida().getSerp()).isViu() && !model.getEliminats()[model.getPartida().getSerp()]){
                       if(model.getPartida().comprovaCollisio()){
                           System.out.println("Has perdut!");
                           model.getPartida().getSerps().get(model.getPartida().getSerp()).setViu(false);
                           try{
                               network.avisaServer("MORT");
                           }catch(IOException ex){
                               ex.printStackTrace();
                           }
                   }


                     /*  for(int i = 0; i < model.getPartida().getSerps().size(); i++){
                           System.out.println("Serp " + i);
                           for(int z = 0; z < model.getPartida().getSerps().get(i).getPosicions().size(); z++){
                               System.out.println("(" + model.getPartida().getSerps().get(i).getPosicions().get(z).getX() + ", " + model.getPartida().getSerps().get(i).getPosicions().get(z).getY() + ")");
                           }
                       }*/
                        }
                    }
                    vistaJoc.repaint();
                    break;
                case "FI":
                    if(fi <= 0){
                        vistaJoc.reinicia();
                        model.getPartida().reinicia();
                        fi = 5;
                    }else{
                        fi--;
                    }
                    if(vistaJoc.isAbandona()){
                        vistaJoc.reinicia();
                        vistaJoc.sortir();
                        vistaJoc.setAbandona(false);
                        System.out.println("Joc reiniciat");
                    }
                    contador = 4;
                    vistaJoc.repaint();
                    System.out.println("Repaint amb cont " + vistaJoc.isCont());
                    break;
            }

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public Client getModel() {
        return model;
    }

    public void setModel(Client model) {
        this.model = model;
    }

/*    public Serp getSerp(){
        return model.getPartida().getSerp();
    }*/

    public int getContador() {
        return contador;
    }

    public ArrayList<Serp> getSerps(){
        return model.getPartida().getSerps();
    }

    public void iniciaPartida (Partida partida){
        //avisem a la vista que comencem la partida
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void moureSerp(int d){
        System.out.println("teclaaa");

        if(vistaJoc.isCont() == false && !vistaJoc.isFi()) {
            try{
                model.getPartida().getSerps().get(model.getPartida().getSerp()).canviaDireccio(d, model.getPartida().getSerps().get(model.getPartida().getSerp()).getCap());
                network.avisaServer("MOVIMENT");
                network.getDoStreamO().writeObject(d);
                network.getDoStreamO().writeObject(model.getPartida().getSerps().get(model.getPartida().getSerp()).getUltim());
                System.out.println("agafa serp");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void reinicia(){
        fi = 5;
        contador = 4;
    }
}
