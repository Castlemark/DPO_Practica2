package controlador;

import Model.Inicia;
import Model.Partida;
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
                            vista.changePanel("RANQUING");
                            network.iniciaRebre();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No s'ha pogut completar el registre\nHi ha un error en les dades");
                    }
                    break;

                case "INICIAR":

                    System.out.println("connectant");

                    if (network.connect(vista.getPort(), vista.getIp())){
                        vista.changePanel("IDENTIFICACIO");
                    }else {
                        JOptionPane.showMessageDialog(null, "No s'ha pogut conectar al servidor");
                    }
                    break;

                case "INICIARSESSIO":

                    Inicia iniciaAux = new Inicia(vista.getIniciarSessio().getID(), vista.getIniciarSessio().getPassword());

                    network.avisaServer("INICIARSESSIO");
                   if (network.iniciaSessio(iniciaAux)){

                       vista.changePanel("RANQUING");
                       network.iniciaRebre();
                       network.avisaServer("ENVIACONTROLS");
                       network.rebreControls();

                   }
                   else {
                        JOptionPane.showMessageDialog(null, "Error al iniciar sessió");
                   }


                   break;

                case  "JOC2":

                    network.avisaServer("JOC2");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(2));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case  "JOC4":

                    network.avisaServer("JOC4");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(4));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case "CAMPEONAT":

                    network.avisaServer("CAMPEONAT");
                    vista.changePanel("JOC");
                    model.setPartida(new Partida(4));
                    //Escolta la resposta del servidor per saber si ha de canviar a la finestra de joc
                    break;

                case "GUARDAR":

                    network.avisaServer("CONTROLS");
                    network.passaControls(vista.getControls());
                    break;

                case "CONTROLS":

                    vista.changePanel("CONTROLS");
                    break;

                case "TANCAR":
                    network.tancarSessio();
                    network.avisaServer("TANCARSESSIO");
                    vista.changePanel("INICI");
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

