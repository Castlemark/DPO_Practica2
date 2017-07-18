package controlador;

import Model.Inicia;
import Model.Partida;
import Vista.Configuracio;
import Client_Servidor.Network;
import Vista.VistaClient;
import Model.Client;
import Model.Usuari;
//import Vista.VistaClientProva;

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

    /**
     * Constructor del client
     * @param vistaClient
     * @param model
     * @param network
     */
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
                            JOptionPane.showMessageDialog(null, "No s'ha pogut completar el registre\nJa existeix aquest usuari");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Registre completat amb exit");
                        }

                        System.out.println("OK");
                    } else {
                        JOptionPane.showMessageDialog(null, "No s'ha pogut completar el registre\nHi ha un error en les dades");
                    }
                    break;

                case "INICIAR"://Connectar-se amb el servidor

                    System.out.println("connectant");
                    network.connect(vista.getPort(), vista.getIp());
                    vista.changePanel("IDENTIFICACIO");


                    break;

                case "INICIARSESSIO"://Iniciar sessió

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

                case  "JOC2"://Joc de 2 jugadors

                    network.avisaServer("JOC2");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(2));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case  "JOC4"://Joc de 4 jugadors

                    network.avisaServer("JOC4");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(4));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case "CAMPEONAT"://Mode campionat

                    network.avisaServer("CAMPEONAT");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(4));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case "GUARDAR"://Guardarles tecles

                    //passar vista.teclaup etc al server
                    break;

                case "CONTROLS"://Anar a la finestra de canviar els controls

                    vista.changePanel("CONTROLS");
                    break;

                case "TANCAR"://Tancar sessió i desconnectar-se del server
                    network.tancarSessio();
                    network.avisaServer("TANCARSESSIO");//No se si es necessari
                    vista.changePanel("CONFIGURACIO");
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

