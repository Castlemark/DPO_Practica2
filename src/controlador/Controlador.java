package controlador;

import Vista.Configuracio;
import Vista.VistaClient;
import model.Client;
import model.Usuari;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controlador del client
 * Created by Grup 6 on 24/04/2017.
 */
public class Controlador implements ActionListener {
    private Vista.Registre vistaRegistre;
    private Client model;

    private VistaClient vista;

    public Controlador(VistaClient vistaClient, Client model) {
        this.vista = vistaClient;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*if (e.getSource() instanceof JButton) {
            System.out.println(e.getActionCommand() + " - boto");
            if (e.getActionCommand().equals("INICI")) {
                System.out.println("clic");
                if (model.connectar(vista.getIp(), vista.getPort())) {
                    System.out.println("connectant");
                    vista.changePanel("IDENTIFICACIO");

                }
            }
        }*/

        try {

            switch (e.getActionCommand()) {


                case "ENVIAR":

                    Usuari usuariAux = new Usuari();

                    if (usuariAux.comprovaDades(vistaRegistre.getLogin(), vistaRegistre.getMail(), vistaRegistre.getPassword(), vistaRegistre.getConfirmacio())) {
                        model.setUsuari(usuariAux = new Usuari(vistaRegistre.getLogin(), vistaRegistre.getMail(), vistaRegistre.getPassword()));

                        model.getNetwork().registraUsuari(usuariAux);

                        System.out.println("OK");
                    } else {
                        System.out.println("Error de dades");
                    }
                    break;


                case "INICI":
                    System.out.println("clic");
                    if (model.connectar(vista.getIp(), vista.getPort())) {
                        System.out.println("connectant");
                        vista.changePanel("IDENTIFICACIO");


                    }
                    break;
            }
        } catch (IOException ioe) {
            ioe.getMessage();
        }

    }
}

