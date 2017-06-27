package controlador;

import Client_Servidor.Network;
import Vista.*;
import Model.Client;

import javax.swing.*;

/**
 * Main del controlador del Client del Troner
 * Created by Grup 6 on 15/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Client model = new Client();
                Network network = new Network(model);
                VistaClient vista = new VistaClient();

                VistaJoc vistaJoc = new VistaJoc();

                Controlador  controlador= new Controlador(vista,model,network);
                ControladorJoc cj = new ControladorJoc(vistaJoc, model, network);
                vista.registerController(controlador);
                vistaJoc.registraControlador(cj);


                vista.setVisible(true);

                /*JFrame frame = new JFrame("LSTroner");
                frame.add(vistaJoc);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);*/






/*
                // crea el controlador i estableix la relacio C->V i C->M
                ControladorJoc cj = new ControladorJoc(vistaJoc.getPanel1(), Model);
                // establim la relacio V--->C
                vistaJoc.registraControlador(cj);
                // fem la vista visible
                frame.setVisible(true);
        //        vistaJoc.iniciaJoc();*/
            }
        });
    }
}