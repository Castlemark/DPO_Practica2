package Model;

import controlador.Network;

/**
 * Created by Propietario on 24/04/2017.
 */
public class Client {
    private Usuari usuari;
    private Partida partida;

    private Network network;



    public Client (){
        partida = null;

        network = new Network(this);
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public void abandonaPartida(){
        partida.setViu(false);
        System.out.println("Has abandonat!");

    }

    public boolean connectar(String ip,String host){
        return true;
    }

    public Network getNetwork() {
        return network;
    }
}
