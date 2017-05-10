package controlador;

import Vista.Configuracio;
import Vista.VistaClient;
import model.Client;
import model.Usuari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador del client
 * Created by Grup 6 on 24/04/2017.
 */
public class Controlador implements ActionListener {
    private Vista.Registre vistaRegistre;
    private Client model;

    private  VistaClient vista;

    public Controlador(Vista.Registre vistaRegistre, Client model){
        this.vistaRegistre = vistaRegistre;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ENVIAR":
                Usuari usuariAux = new Usuari();
                if(usuariAux.comprovaDades(vistaRegistre.getLogin(), vistaRegistre.getMail(), vistaRegistre.getPassword(), vistaRegistre.getConfirmacio())){
                    model.setUsuari(usuariAux = new Usuari(vistaRegistre.getLogin(), vistaRegistre.getMail(), vistaRegistre.getPassword()));
                    System.out.println("OK");
                }else{
                    System.out.println("Error de dades");
                }
                break;
            case "INICI":

                if (model.connectar(vista.getIp(),vista.getPort())) {
                    System.out.println("connectat");



                }
                break;
        }
    }
}
