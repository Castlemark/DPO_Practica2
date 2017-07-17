package Vista;

import controlador.Controlador;
import controlador.ControladorJoc;

import javax.swing.*;
import java.awt.*;

/**
 *
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
    private  CardLayout layout;

    private Controls controls;
    private Configuracio configuracio;
    private  FiPartida fiPartida;
    private Inici inici;
    private IniciarSessio iniciarSessio;
   private  Joc joc;
    private Ranquing ranquing;
    private Registre registre;
    private TancarSessio tancarSessio;
    private VistaJoc vistaJoc;
    private Identificacio identificacio;

    /**
     * Constructor de la vista del menú del client. Inicialitza els elements a mostrar
     */
    public VistaClient (){

        this.setTitle("LS Troner");
        this.setSize (1200, 800);

        layout = new CardLayout();
        this.getContentPane().setLayout(layout);

        //inicialitzar panels
        configuracio = new Configuracio();
        fiPartida = new FiPartida(true);// de moment
        inici = new Inici();
        iniciarSessio = new IniciarSessio();
        joc = new Joc();
        ranquing = new Ranquing();
        registre = new Registre();
        tancarSessio = new TancarSessio();
        identificacio = new Identificacio();
        controls = new Controls();


        this.getContentPane().add("INICI", configuracio);
        this.getContentPane().add("IDENTIFICACIO", identificacio);
        this.getContentPane().add("FIPARTIDA" , fiPartida);
        this.getContentPane().add("RANQUING", ranquing);
        this.getContentPane().add("JOC", joc);
        this.getContentPane().add("CONTROLS",controls);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void registerController(Controlador c, ControladorJoc cj) {

        identificacio.registerController(c);
        configuracio.registerController(c);
        ranquing.registerController(c);
        joc.registraControlador(cj);
        controls.registerController(c);


    }
    public void changePanel(String which){
        layout.show(this.getContentPane(), which);
    }

    public int getPort(){return configuracio.getPort();}
    public String getIp(){return configuracio.getIp();}

    public Registre getRegistre(){
        return identificacio.getRegistre();
    }

    public IniciarSessio getIniciarSessio(){
        return identificacio.getIniciarSessio();
    }

    public void iniciaPartida(){
        joc.iniciaJoc();
    }

    public VistaJoc getJoc() {
        return joc.getPanel1();
    }

    public void insereixJugador(String[] logins){
        joc.insereixJugador(logins);
    }
    public void insereixRondes(int[] rondes){
        joc.setRondes(rondes);
    }

    public void aturaPartida(){
        joc.aturar();
    }

    public void setPunts(int p){
        joc.getPanel1().setPunts(p);
    }
    public void setPos(String pos){
        joc.getPanel1().setPosicio(pos);
    }
}
