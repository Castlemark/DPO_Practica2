package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 19/04/2017.
 */
public class VistaClient extends JPanel {
    private JButton jbRegistrar;
    private JButton jbConfiguracio;
    private JButton jbJugar2x;
    private JButton jbJugar4x;
    private JButton jbCampionat;
    private JButton jbIniciar;
    private JButton jbRanquing;
    private JPanel jpClient;

    /**
     * Constructor de la vista del menú del client. Inicialitza els elements a mostrar
     */
    public VistaClient (){
        //this.setTitle("Client Troner");
        this.setSize (350, 350);
        //this.setResizable(true);

        jpClient = new JPanel();
        jpClient.setLayout(new GridLayout(7,1));

        jbRegistrar = new JButton("Registrar usuaris");
        jbIniciar = new JButton("Iniciar/Tancar");
        jbConfiguracio = new JButton("Configurar el sistema");
        jbRanquing = new JButton("Visualitzar ranquing de jugadors");
        jbJugar2x = new JButton("Jugar 2x");
        jbJugar4x = new JButton("Jugar 4x");
        jbCampionat = new JButton("Jugar campionat");

        jpClient.add(jbConfiguracio);
        jpClient.add(jbRegistrar);
        jpClient.add(jbConfiguracio);
        jpClient.add(jbIniciar);
        jpClient.add(jbJugar2x);
        jpClient.add(jbJugar4x);
        jpClient.add(jbCampionat);
        jpClient.add(jbRanquing);

        //getContentPane().add(jpClient, BorderLayout.CENTER);

       // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
