package model;

/**
 * Created by Propietario on 24/04/2017.
 */
public class Client {
    private Usuari usuari;
    private Partida partida;



    public Client (){
        partida = new Partida();
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
}
