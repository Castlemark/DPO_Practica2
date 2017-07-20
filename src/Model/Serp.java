package Model;

import javafx.geometry.Pos;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Serp del Model del client
 *
 * És la classe de les serps, guarda la seva posició...
 * Created by Grup 6 on 06/04/2017.
 */
public class Serp implements Serializable{
    private ArrayList<Posicio> posicions;
    private Posicio cap;
    private int dir = 1;
    private boolean viu;

    public Serp(int i){
        viu = true;
        posicions = new ArrayList<>();
        switch (i){
            case 0:
                cap = new Posicio(10, 10);
               posicions.add(new Posicio(10, 10));
               dir = 1;
               break;
            case 1:
                cap = new Posicio(300, 10);
                posicions.add(new Posicio(300, 10));
                dir = 3;
                break;
            case 2:
                cap = new Posicio(340, 340);
                posicions.add(new Posicio(340, 340));
                dir = 2;
                break;
            case 3:
                cap = new Posicio(10, 340);
                posicions.add(new Posicio(10, 340));
                dir = 4;
                break;
        }

    }
    public void mouSerp(){cap.mouCap(dir);}

    public void canviaDireccio (int d, Posicio c){
        this.cap = c;
        if(d == 2 && dir != 3 && dir != 4){
            dir = 3;
            posicions.add(new Posicio(cap.getX(), cap.getY()));
        }
        if(d == 3 && dir != 2 && dir != 1){
            dir = 2;
            posicions.add(new Posicio(cap.getX(), cap.getY()));
        }
        if(d == 4 && dir != 1 && dir != 2){
            dir = 1;
            posicions.add(new Posicio(cap.getX(), cap.getY()));
        }
        if(d == 1 && dir != 4 && dir != 3){
            dir = 4;
            posicions.add(new Posicio(cap.getX(), cap.getY()));
        }
    }
    /**
     * Getter de la posició
     * @return posicio
     */
    public ArrayList<Posicio> getPosicions() {
        return posicions;
    }

    /**
     * Setter de posicions
     * @param posicions
     */
    public void setPosicions(ArrayList posicions) {
        this.posicions = posicions;
    }

    public void setCap(Posicio cap) {
        this.cap = cap;
    }

    public Posicio getCap() {
        return cap;
    }

    public boolean isViu() {
        return viu;
    }

    public void setViu(boolean viu) {
        this.viu = viu;
    }

    public Posicio getUltim(){
        return posicions.get(posicions.size() - 1);
    }
}

