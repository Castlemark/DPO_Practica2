package Client_Servidor;

import Model.*;
import Model.Client;
import Model.Partida;
import Model.Serp;
import Model.Usuari;
import Vista.VistaClient;
import Vista.VistaJoc;
import controlador.Controlador;
import controlador.ControladorJoc;
import controlador.ThreadRebre;

import java.io.*;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

/**
 * Created by Propietario on 10/05/2017.
 */
public class Network extends Thread{
    private Client model;

    private Socket sServer;
    private ObjectOutputStream doStreamO;
    private ObjectInputStream diStreamO;

    private ThreadRebre tr;

    private Partida partida;
    private VistaClient vista;
    private Scanner sc;
    private Serp serp;

    private ControladorJoc cj;

    private boolean running;

    

    public Network(Client model, VistaClient vista){
        this.model = model;
        this.vista = vista;
        running = true;

    }

    public boolean connect(int port, String IP){
        port = 11111;


        try{
            sc = new Scanner(System.in);

            sServer = new Socket(IP, port);

            doStreamO = new ObjectOutputStream(sServer.getOutputStream());
            diStreamO = new ObjectInputStream(sServer.getInputStream());

            System.out.println("esta conectat");
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void run(){
        while (running){


        }
    }

    public boolean registraUsuari(Usuari usuari) throws IOException, ClassNotFoundException{

        doStreamO.writeObject(usuari);
        return  (Boolean) diStreamO.readObject();    }

    public boolean iniciaSessio(Inicia inicia) throws IOException, ClassNotFoundException{

        doStreamO.writeObject(inicia);
        return  (Boolean) diStreamO.readObject();
    }

    public void passaControls(int[] controls){

        try {
            doStreamO.writeObject(controls[0]);
            doStreamO.writeObject(controls[1]);
            doStreamO.writeObject(controls[2]);
            doStreamO.writeObject(controls[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] rebreControls(){

        int[] controls = new int[4];
        try {
            controls[0]= (Integer) diStreamO.readObject();
            controls[1]= (Integer) diStreamO.readObject();
            controls[2]= (Integer) diStreamO.readObject();
            controls[3]= (Integer) diStreamO.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return controls;
    }

    public void avisaServer(String which) throws IOException{
        System.out.println("avisa " + which);
        doStreamO.writeObject(which);
    }

    public ObjectOutputStream getDoStreamO() {
        return doStreamO;
    }

    public ObjectInputStream getDiStreamO() {
        return diStreamO;
    }

    public void iniciaRebre(){
        tr = new ThreadRebre(diStreamO, model, vista, this, cj);
        tr.start();
    }

    public void partidaPerduda(){
        try {
            doStreamO.writeObject("MORT");
           // vista.changePanel("RANQUING");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getMessage() throws IOException, ClassNotFoundException{

        return (String) diStreamO.readObject();
    }

    public void tancarSessio(){

    }

    public ThreadRebre getTreadRebre(){
        return tr;
    }

    public void setControlador(ControladorJoc cj){
        this.cj = cj;
    }

}
