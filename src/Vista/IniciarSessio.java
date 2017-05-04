package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 20/04/2017.
 */
public class IniciarSessio extends JPanel {
    private JPanel jpIniciar;
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
       // this.setTitle ("Iniciar Sessió");
        this.setSize (350,350);
      //  this.setResizable(true);

        jpIniciar = new JPanel();
        jpAtras = new JPanel(new BorderLayout());
        jpID = new JPanel(new BorderLayout());
        jpPassword = new JPanel(new BorderLayout());

        jlTitle = new JLabel("            Iniciar Sessió");
        jlID = new JLabel("ID         ");
        jtID = new JTextField();
        jlPassword = new JLabel("Password      ");
        jtPassword = new JTextField();
        jbIniciar = new JButton("Iniciar");


        jpIniciar.setLayout(new GridLayout(4,1));
        jpID.add(jlID, BorderLayout.LINE_START);
        jpID.add(jtID, BorderLayout.CENTER);
        jpPassword.add (jlPassword, BorderLayout.LINE_START);
        jpPassword.add (jtPassword, BorderLayout.CENTER);

        jpIniciar.add(jlTitle, BorderLayout.CENTER);
        jpIniciar.add(jpID);
        jpIniciar.add(jpPassword);
        jpIniciar.add(jbIniciar, BorderLayout.LINE_END);

        this.add(jpIniciar,BorderLayout.PAGE_START);
    }
}
