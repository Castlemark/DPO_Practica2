package controlador;

import Vista.*;
import model.Client;
import model.Usuari;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.CaretListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.KeyEvent;
/**
 * Main del controlador del Client del Troner
 * Created by Grup 6 on 15/03/2017.
 */
public class Main {
    public static void main (String[] args){
/*
        try{
            Scanner sc = new Scanner(System.in);
            Socket sServer = new Socket("localhost", 10000);
            DataOutputStream doStream = new DataOutputStream(sServer.getOutputStream());
            DataInputStream diStream = new DataInputStream(sServer.getInputStream());
            doStream.writeUTF(u.getLogin());
            System.out.println("L'usuari "+u.getLogin()+" està conectat!");
            ThreadEnviar threadEnviar = new ThreadEnviar(sc, doStream);
            ThreadRebre threadRebre = new ThreadRebre(diStream);

            threadEnviar.start();
            threadRebre.start();

            threadEnviar.join();
            threadRebre.join();

            sServer.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*VistaServidor vista = new VistaServidor();
                vista.setVisible(true);*/

                //Creem el model
                /*Client model = new Client();

                //Creem la vista
                Registre vistaRegistre = new Registre();

                // crea el controlador i estableix la relacio C->V i C->M
                Controlador controlador = new Controlador(vistaRegistre, model);
                // establim la relacio V--->C
                vistaRegistre.registraControlador(controlador);
                // fem la vista visible
                vistaRegistre.setVisible(true);*/

                VistaJoc vista = new VistaJoc(10, 10, 20, 20);
                vista.setVisible(true);

            }
        });
    }
}
