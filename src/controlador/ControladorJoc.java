package controlador;

import Client_Servidor.Network;
import Model.Client;
import Model.Partida;
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
    private boolean[] eliminats = new boolean[4];



    public ControladorJoc(VistaJoc vistaJoc, Client model, Network network){
        this.vistaJoc = vistaJoc;
        this.model = model;
        contador = 4;
        this.network = network;
        fi = 5;
        for(int i = 0; i < eliminats.length; i++){
            eliminats[i] = false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

       // if(!(e.getActionCommand().equals("TIMER"))){System.out.println(e.getActionCommand());}

        switch (e.getActionCommand()){
           case "ABANDONA":
               model.abandonaPartida();
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
                       if(model.getPartida().getSerps().get(i).isViu() && !eliminats[i]){
                           model.getPartida().getSerps().get(i).mouSerp();
                       }
                   }
                   if(model.getPartida().getSerps().get(model.getPartida().getSerp()).isViu() && !eliminats[model.getPartida().getSerp()]){
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
                vistaJoc.repaint();
                if(fi <= 0){
                    vistaJoc.reinicia();
                    model.getPartida().reinicia();
                    fi = 5;
                }else{
                    fi--;
                }
                contador = 4;
                break;
       }


    }
/*
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("teclaaa");

    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("teclaaa");

    }*/

  //  @Override
 /*   public void keyTyped(KeyEvent e) {

        System.out.println("teclaaa");

        c = e.getKeyChar();
       if(vistaJoc.isCont() == false){
           model.getPartida().getSerp().canviaDireccio(c);
           try{
              network.getDoStreamO().writeObject(model.getPartida().getSerp());
           } catch (IOException ex) {
               ex.printStackTrace();
           }

       }*/
      /*
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                dir = 3;
                break;
            case KeyEvent.VK_S:
                dir = 4;
                System.out.println("avall");
                break;
            case KeyEvent.VK_A:
                dir = 2;
                break;
            case KeyEvent.VK_D:
                dir = 1;
                break;
        }


    }*/

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

    public void elimina(int e){
        eliminats[e] = true;
        int num = 0;
        for(int i = 0; i < eliminats.length; i++){
            if(eliminats[i]){
                num++;
            }
        }
        if(num == 3){
            for(int i = 0; i < eliminats.length; i++){
                eliminats[i] = false;
            }
        }
    }

    public void setEliminats(boolean[] eliminats) {
        this.eliminats = eliminats;
    }
}
