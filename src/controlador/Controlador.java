package controlador;

import Model.Inicia;
import Vista.Configuracio;
import Client_Servidor.Network;
import Vista.VistaClient;
import Model.Client;
import Model.Usuari;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controlador del client
 * Created by Grup 6 on 24/04/2017.
 */
public class Controlador implements ActionListener {
    private Client model;
    private Network network;

    private VistaClient vista;

    public Controlador(VistaClient vistaClient, Client model, Network network) {
        this.vista = vistaClient;
        this.model = model;
        this.network = network;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {


            switch (e.getActionCommand()) {


                case "REGISTRE":

                    Usuari usuariAux = new Usuari();

                    if (usuariAux.comprovaDades(vista.getRegistre().getLogin(), vista.getRegistre().getMail(),vista.getRegistre().getPassword(),vista.getRegistre().getConfirmacio())) {
                        model.setUsuari(usuariAux = new Usuari(vista.getRegistre().getLogin(), vista.getRegistre().getMail(),vista.getRegistre().getPassword()));

                        network.avisaServer("REGISTRAR");
                        if (!network.registraUsuari(usuariAux)){
                            JOptionPane.showMessageDialog(null, "No s'ha pogust completar el registre\nJa existeix aquest usuari");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Registre completat amb exit");
                        }

                        System.out.println("OK");
                    } else {
                        JOptionPane.showMessageDialog(null, "No s'ha pogut completar el registre\nHi ha un error en les dades");
                    }
                    break;

                case "INICIAR":
                    if (model.connectar(vista.getIp(), vista.getPort())) {
                        System.out.println("connectant");
                        network.connect(1111);
                        vista.changePanel("IDENTIFICACIO");


                    }
                    break;

                case "INICIARSESSIO":

                    Inicia iniciaAux = new Inicia(vista.getIniciarSessio().getID(), vista.getIniciarSessio().getPassword());

                    network.avisaServer("INICIARSESSIO");
                    if (network.iniciaSessio(iniciaAux)){
                        vista.changePanel("RANQUING");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error al iniciar sessió");
                    }
                    network.iniciaRebre();
                    break;

                case  "JOC2":

                    network.avisaServer("JOC2");
                    vista.changePanel("JOC");
                    System.out.println("ok");

                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case  "JOC4":

                    network.avisaServer("JOC4");
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case "CAMPEONAT":

                    network.avisaServer("CAMPEONAT");
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.getMessage();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }

    }
}

