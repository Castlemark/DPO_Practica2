package model;

/**
 * Classe partida del model del Client.
 *
 * Gestiona les serps de la partida i comprova que no hi hagi colisions.
 *
 * Created by Grup 6 on 06/04/2017.
 */
public class Partida {
    private Serp [] serps;

    /**
     * Getter de serps
     * @return Objecte serp
     */
    public Serp[] getSerps() {
        return serps;
    }

    /**
     * Setter de serps
     * @param serps
     */
    public void setSerps(Serp[] serps) {
        this.serps = serps;
    }

    /**
     * Comprova si hi ha colisions entre serps
     * @return true si hi ha colisió
     */
    public boolean comprovaColisio (){
        return true;
    }
}
