package model;

import java.io.Serializable;

/**
 * Classe Serp del model del client
 *
 * És la classe de les serps, guarda la seva posició...
 * Created by Grup 6 on 06/04/2017.
 */
public class Serp implements Serializable{
    private Posicio [] posicions;

    /**
     * Getter de la posició
     * @return posicio
     */
    public Posicio[] getPosicions() {
        return posicions;
    }

    /**
     * Setter de posicions
     * @param posicions
     */
    public void setPosicions(Posicio[] posicions) {
        this.posicions = posicions;
    }
}
