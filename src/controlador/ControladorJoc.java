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


    public ControladorJoc(VistaJoc vistaJoc, Client model, Network network){
        this.vistaJoc = vistaJoc;
        this.model = model;
        contador = 4;
        this.network = network;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(!(e.getActionCommand().equals("TIMER"))){System.out.println(e.getActionCommand());}

        switch (e.getActionCommand()){
           case "AVANÇA":
             //  model.getPartida().getSerp().mouSerp();
               if(model.getPartida().comprovaCollisio()){
                   System.out.println("Has perdut!");
                   model.getPartida().setViu(false);
                   vistaJoc.aturar();
                   try{
                       network.avisaServer("MORT");
                   }catch(IOException ex){
                       ex.printStackTrace();
                   }
               }

               break;
           case "CONTA":
               System.out.println(contador);
       //        contador--;
               if(contador == 0){
                   vistaJoc.setCont(false);
               }
               break;
           case "ABANDONA":
               model.abandonaPartida();
               break;
           case "TIMER":
               if(vistaJoc.isCont()){
                   contador--;
                   System.out.println(contador);

                   if(contador <= 0){
                       vistaJoc.setCont(false);
                   }
               }else{

                   for(int i = 0; i< model.getPartida().getSerps().size(); i++) {
                        model.getPartida().getSerps().get(i).mouSerp();
                   }
                   if(model.getPartida().comprovaCollisio()){
                       System.out.println("Has perdut!");
                       model.getPartida().setViu(false);
                       network.partidaPerduda();
                   }
               }
               break;
           case "down":

       }

        vistaJoc.repaint();

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

        if(vistaJoc.isCont() == false) {
            model.getPartida().getSerps().get(model.getPartida().getSerp()).canviaDireccio(d);
            try{
                network.avisaServer("MOVIMENT");
                network.getDoStreamO().writeObject(d);
                System.out.println("agafa serp");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }


}
