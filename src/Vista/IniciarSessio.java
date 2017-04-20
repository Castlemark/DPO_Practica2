package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 20/04/2017.
 */
public class IniciarSessio extends JFrame {
    private JPanel jpIniciar;
    private JPanel jpAtras;
    private JButton jbAtras;
    private JLabel jlTitle;
    private JLabel jlID;
    private JPanel jpID;
    private JTextField jtID;
    private JTextField jtPassword;
    private JLabel jlPassword;
    private JPanel jpPassword;
    private JButton jbIniciar;

    public IniciarSessio () {
       /* this.setTitle ("Configuració");
        this.setSize (350,350);
        this.setResizable(true);

        jpConfiguracio = new JPanel();
        jpAtras = new JPanel(new BorderLayout());
        jpPort = new JPanel(new BorderLayout());
        jpIP = new JPanel(new BorderLayout());

        jbAtras = new JButton("<-");
        jlTitle = new JLabel("            Configuració");
        jlPort = new JLabel("Port         ");
        jtPort = new JTextField();
        jlIP = new JLabel("IP Servidor      ");
        jtIP = new JTextField();
        jbIniciar = new JButton("Iniciar");


        jpConfiguracio.setLayout(new GridLayout(4,1));
        jpAtras.add (jbAtras, BorderLayout.LINE_START);
        jpAtras.add (jlTitle, BorderLayout.CENTER);
        jpIP.add(jlIP, BorderLayout.LINE_START);
        jpIP.add(jtIP, BorderLayout.CENTER);
        jpPort.add (jlPort, BorderLayout.LINE_START);
        jpPort.add (jtPort, BorderLayout.CENTER);

        jpConfiguracio.add(jpAtras, BorderLayout.CENTER);
        jpConfiguracio.add(jpIP);
        jpConfiguracio.add(jpPort);
        jpConfiguracio.add(jbIniciar, BorderLayout.LINE_END);

        this.getContentPane().add(jpConfiguracio,BorderLayout.PAGE_START);*/
    }
}
