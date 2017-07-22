package Model;

/**
 * Created by Propietario on 24/04/2017.
 */
public class Client {
    private Usuari usuari;
    private Partida partida;
    private int punts;
    private boolean[] eliminats = new boolean[4];



    public Client (){
        for(int i = 0; i < eliminats.length; i++){
            eliminats[i] = false;
        }
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
        int s = partida.getSerps().size();
        this.partida = new Partida(s);
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

    public void elimina(int e){
        eliminats[e] = true;
        int num = 0;
        for(int i = 0; i < eliminats.length; i++){
            if(eliminats[i]){
                num++;
            }
        }
        if(num == 3){
            for(int i = 0; i < eliminats.length; i++){
                eliminats[i] = false;
            }
        }
    }

    public void setEliminats(boolean[] eliminats) {

        this.eliminats = eliminats;
    }

    public boolean[] getEliminats() {
        return eliminats;
    }

    public boolean comprovaControls (int[] controls) {
        boolean ok = true;
        for (int i = 0; i < controls.length && ok; i++){
           for (int j = i + 1; j < controls.length && ok; j++){
                if (controls[i] == controls [j]) {
                    ok = false;
               }
           }

        }
        return ok;
    }
}
