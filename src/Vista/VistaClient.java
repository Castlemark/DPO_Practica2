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
    private Inici inici;
    private IniciarSessio iniciarSessio;
    private  Joc joc;
    private Ranquing ranquing;
    private Registre registre;
    private VistaJoc vistaJoc;
    private Identificacio identificacio;

    /**
     * Constructor de la vista del menú del client. Inicialitza els elements a mostrar
     */
    public VistaClient (){

        this.setTitle("LS Troner");
        this.setSize (1200, 700);

        layout = new CardLayout();
        this.getContentPane().setLayout(layout);

        //inicialitzar panels
        //controls = new Controls();
        configuracio = new Configuracio();
        inici = new Inici();
        iniciarSessio = new IniciarSessio();
        joc = new Joc();
        ranquing = new Ranquing();
        registre = new Registre();
        identificacio = new Identificacio();
        controls = new Controls();


        this.getContentPane().add("INICI", configuracio);
        this.getContentPane().add("IDENTIFICACIO", identificacio);
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

    public int[] getControls(){ return  controls.getControls();}

    public void  actualitzaControls(int[] control){
        controls.actualitzaControls(control);
    }

    public void iniciaPartida(){
        joc.iniciaJoc();
    }

    public VistaJoc getJoc() {
        return joc.getPanel1();
    }

    public Ranquing getRanquing(){return ranquing;}

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

    public void reinicia(){
        joc.reinicia();
    }

    public void actualitzaTecles(int[] tecla) {joc.actualitzaTecles(tecla);}

}
