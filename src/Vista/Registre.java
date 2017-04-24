package Vista;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by sullivan on 20/04/2017.
 */
public class Registre extends JFrame {
    private JPanel jpRegistre;
    private JPanel jpAtras;
    private JPanel jpLogin;
    private JPanel jpMail;
    private JPanel jpPassword;
    private JPanel jpConfirmacio;
    private JPanel jpEnviar;
    private JButton jbAtras;
    private JLabel jlTitle;
    private JLabel jlLogin;
    private JLabel jlPassword;
    private JLabel jlConfirmacio;
    private JLabel jlMail;
    private JTextField jtLogin;
    private JPasswordField jPassword;
    private JPasswordField jConfirmacio;
    private JTextField jtMail;
    private JButton jbEnviar;


    public Registre () {

        this.setTitle("Registrar usuaris");
        this.setSize (350, 350);
        this.setResizable(true);

        jpRegistre = new JPanel();
        jpAtras = new JPanel(new BorderLayout());
        jpLogin = new JPanel(new BorderLayout());
        jpPassword = new JPanel(new BorderLayout());
        jpConfirmacio = new JPanel(new BorderLayout());
        jpMail = new JPanel(new BorderLayout());
        jpEnviar = new JPanel(new BorderLayout());


        jbAtras = new JButton("<-");
        jPassword = new JPasswordField();
        jConfirmacio = new JPasswordField();
        jlTitle = new JLabel("          Registrar usuari");
        jtMail = new JTextField();
        jbEnviar = new JButton("Enviar");
        jlLogin = new JLabel("Login               ");
        jlMail = new JLabel("Mail                  ");
        jlPassword = new JLabel("Password      ");
        jlConfirmacio = new JLabel("Confirmació contrasenya  ");
        jtLogin = new JTextField();

        jpRegistre.setLayout(new GridLayout(6,1));
        jpAtras.add(jbAtras, BorderLayout.LINE_START);
        jpAtras.add(jlTitle, BorderLayout.CENTER);
        jpEnviar.add(jbEnviar, BorderLayout.LINE_END);
        jpLogin.add(jlLogin, BorderLayout.LINE_START);
        jpLogin.add(jtLogin, BorderLayout.CENTER);
        jpPassword.add(jlPassword, BorderLayout.LINE_START);
        jpPassword.add(jPassword, BorderLayout.CENTER);
        jpConfirmacio.add(jlConfirmacio, BorderLayout.LINE_START);
        jpConfirmacio.add(jConfirmacio, BorderLayout.CENTER);
        jpMail.add(jlMail, BorderLayout.LINE_START);
        jpMail.add(jtMail, BorderLayout.CENTER);

        jpRegistre.add(jpAtras, BorderLayout.CENTER);
        jpRegistre.add(jpLogin);
        jpRegistre.add(jpMail);
        jpRegistre.add(jpPassword);
        jpRegistre.add(jpConfirmacio);

        jpRegistre.add(jpEnviar);

        this.getContentPane().add(jpRegistre, BorderLayout.PAGE_START);
    }

    public java.lang.String getLogin(){
        return jtLogin.getText();
    }
    public java.lang.String getMail(){
        return jtMail.getText();
    }
    public java.lang.String getPassword(){
        return jPassword.getText();
    }
    public java.lang.String getConfirmacio(){
        return jConfirmacio.getText();
    }

    public void registraControlador( controlador.Controlador controlador){
        jbEnviar.setActionCommand("ENVIAR");
        jbEnviar.addActionListener(controlador);
    }
}
