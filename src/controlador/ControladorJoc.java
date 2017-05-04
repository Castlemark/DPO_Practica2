package controlador;

import Vista.VistaJoc;
import model.Client;
import model.Serp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Propietario on 03/05/2017.
 */
public class ControladorJoc implements ActionListener, KeyListener {
    private VistaJoc vistaJoc;
    private Client model;
    private char c;


    public ControladorJoc(VistaJoc vistaJoc, Client model){
        this.vistaJoc = vistaJoc;
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {

        model.getPartida().getSerp().mouSerp();
        if(model.getPartida().comprovaCollisio()){
           System.out.println("Has perdut!");
            model.getPartida().setViu(false);
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
        model.getPartida().getSerp().canviaDireccio(c);
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
}
