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
    public static void main(String[] args) {
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
                /*VistaClient vista3 = new VistaClient();
                vista3.setVisible(true);*/

                //Creem el model
                Client model = new Client();

                //Creem la vista
                Joc vistaJoc = new Joc();

                JFrame frame = new JFrame("LSTroner");
                frame.add(vistaJoc);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);

                // crea el controlador i estableix la relacio C->V i C->M
                ControladorJoc cj = new ControladorJoc(vistaJoc.getPanel1(), model);
                // establim la relacio V--->C
                vistaJoc.registraControlador(cj);
                // fem la vista visible
                frame.setVisible(true);
        //        vistaJoc.iniciaJoc();
            }
        });
    }
}