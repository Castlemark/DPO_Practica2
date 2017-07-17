package Model;

/**
 * Created by Propietario on 24/04/2017.
 */
public class Client {
    private Usuari usuari;
    private Partida partida;
    private int punts;

  //  private Network network;

    public Client (){

     //   network = new Network(this);
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
        partida.getSerps().get(partida.getSerp()).setViu(false);
        System.out.println("Has abandonat!");

    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public int getPunts() {
        return punts;
    }

    public void sumaPunts(int p){
        punts =+ p;
    }

    /*  public Network getNetwork() {
        return network;
    }*/
}
