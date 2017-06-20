package controlador;

import Model.Inicia;
import Vista.Configuracio;
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

    private VistaClient vista;

    public Controlador(VistaClient vistaClient, Client model) {
        this.vista = vistaClient;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            switch (e.getActionCommand()) {

                case "ENVIAR":

                    Usuari usuariAux = new Usuari();

                    if (usuariAux.comprovaDades(vista.getRegistre().getLogin(), vista.getRegistre().getMail(),vista.getRegistre().getPassword(),vista.getRegistre().getConfirmacio())) {
                        model.setUsuari(usuariAux = new Usuari(vista.getRegistre().getLogin(), vista.getRegistre().getMail(),vista.getRegistre().getPassword()));

                        model.getNetwork().avisaServer("REGISTRAR");
                        if (!model.getNetwork().registraUsuari(usuariAux)){
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
                        model.getNetwork().connect(1111);
                        vista.changePanel("IDENTIFICACIO");


                    }
                    break;

                case "INICIARSESSIO":

                    Inicia iniciaAux = new Inicia(vista.getIniciarSessio().getID(), vista.getIniciarSessio().getPassword());

                    model.getNetwork().avisaServer("INICIARSESSIO");
                    if (model.getNetwork().iniciaSessio(iniciaAux)){
                        vista.changePanel("RANQUING");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "L'usuari no existeix");
                    }

            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.getMessage();
        }

    }
}

