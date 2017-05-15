package controlador;

import Vista.VistaJoc;
import model.Client;
import model.Serp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Propietario on 03/05/2017.
 */
public class ControladorJoc implements ActionListener, KeyListener {
    private VistaJoc vistaJoc;
    private Client model;
    private char c;
    private int contador;
    private Network network;


    public ControladorJoc(VistaJoc vistaJoc, Client model){
        this.vistaJoc = vistaJoc;
        this.model = model;
        contador = 3;
        this.network = new Network(this);
        network.connect(11111);
    }

    public void actionPerformed(ActionEvent e) {
       switch (e.getActionCommand()){
           case "AVANÇA":
               model.getPartida().getSerp().mouSerp();
               if(model.getPartida().comprovaCollisio()){
                   System.out.println("Has perdut!");
                   model.getPartida().setViu(false);
               }
               break;
           case "CONTA":
               contador--;
               if(contador == 0){
                   vistaJoc.setCont(false);
               }
               break;
           case "ABANDONA":
               model.abandonaPartida();
       }


        vistaJoc.repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        c = e.getKeyChar();
       if(vistaJoc.isCont() == false){
           model.getPartida().getSerp().canviaDireccio(c);
           try{
               network.getDoStreamO().writeObject(model.getPartida().getSerp());
           } catch (IOException ex) {
               ex.printStackTrace();
           }

       }
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
        }*/


    }

    public Client getModel() {
        return model;
    }

    public void setModel(Client model) {
        this.model = model;
    }

    public Serp getSerp(){
        return model.getPartida().getSerp();
    }

    public int getContador() {
        return contador;
    }
}
