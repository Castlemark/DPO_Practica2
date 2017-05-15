package Vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 19/04/2017.
 */
public class VistaClient extends JFrame {

    /*private JButton jbRegistrar;
    private JButton jbConfiguracio;
    private JButton jbJugar2x;
    private JButton jbJugar4x;
    private JButton jbCampionat;
    private JButton jbIniciar;
    private JButton jbRanquing;
    private JPanel jpClient;*/
    private Configuracio iniciar;
    private  CardLayout layout;


    private Configuracio configuracio;
    private  FiPartida fiPartida;
    private Inici inici;
    private IniciarSessio iniciarSessio;
   // private  Joc joc;
    private Ranquing ranquing;
    private Registre registre;
    private TancarSessio tancarSessio;
  //  private VistaJoc vistaJoc;
    private Identificacio identificacio;

    /**
     * Constructor de la vista del menú del client. Inicialitza els elements a mostrar
     */
    public VistaClient (){
        iniciar = new Configuracio();
        this.setTitle("LS Troner");
        this.setSize (1200, 800);
        this.add(iniciar);

        layout = new CardLayout();
        this.getContentPane().setLayout(layout);

        //inicialitzar panels
        configuracio = new Configuracio();
        fiPartida = new FiPartida(true);// de moment
        inici = new Inici();
        iniciarSessio = new IniciarSessio();
    //    joc =new Joc();
        ranquing = new Ranquing();
        registre = new Registre();
        tancarSessio = new TancarSessio();
        identificacio = new Identificacio();


        this.getContentPane().add("FIPARTIDA" , fiPartida);
        this.getContentPane().add("INICI", inici);
        this.getContentPane().add("IDENTIFICACIO", identificacio);





        //this.setResizable(true);

       /* jpClient = new JPanel();
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
        this.add(jpClient);
*/
        //getContentPane().add(jpClient, BorderLayout.CENTER);

       // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void registerController(Controlador c) {

        configuracio.registerController(c);

    }
    public void changePanel(String which){
        layout.show(this.getContentPane(), which);
    }

    public String getPort(){return configuracio.getPort();}
    public String getIp(){return configuracio.getIp();}
}
