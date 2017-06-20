package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe partida del Model del Client.
 *
 * Gestiona les serps de la partida i comprova que no hi hagi colisions.
 *
 * Created by Grup 6 on 06/04/2017.
 */
public class Partida implements Serializable{
    private Model.Serp serp;
    private ArrayList<Model.Serp> serps;

    private boolean viu;

    public Partida(ArrayList<Serp> serps){
        viu = true;
        serp = new Model.Serp();
        this.serps = serps;
    }



    public boolean comprovaCollisio(){

        Model.Posicio cap = serp.getCap();
        ArrayList<Posicio> posicions = serp.getPosicions();

        if(cap.getX() > 350 || cap.getX() < 0 || cap.getY() > 350 || cap.getY() < 0){
            return true;
        }
        for(int i = 0; i < posicions.size() - 1; i++){
            if(posicions.get(i).getX() > posicions.get(i+1).getX() && cap.getX() <= posicions.get(i).getX() && cap.getX() >= posicions.get(i + 1).getX() && cap.getY() == posicions.get(i).getY()){
                return true;
            }
            if(posicions.get(i).getX() < posicions.get(i+1).getX() && cap.getX() >= posicions.get(i).getX() && cap.getX() <= posicions.get(i + 1).getX() && cap.getY() == posicions.get(i).getY()){
                return true;
            }
            if(posicions.get(i).getY() > posicions.get(i+1).getY() && cap.getY() <= posicions.get(i).getY() && cap.getY() >= posicions.get(i + 1).getY() && cap.getX() == posicions.get(i).getX()){
                return true;
            }
            if(posicions.get(i).getY() < posicions.get(i+1).getY() && cap.getY() >= posicions.get(i).getY() && cap.getY() <= posicions.get(i + 1).getY() && cap.getX() == posicions.get(i).getX()){
                return true;
            }
        }
        return false;
    }

    /**
     * Getter de serps
     * @return Objecte serp
     */
    public Serp getSerp() {
        return serp;
    }

    /**
     * Setter de serps
     * @param serps
     */
    public void setSerp(Serp serps) {
        this.serp = serp;
    }

    /**
     * Comprova si hi ha colisions entre serps
     * @return true si hi ha colisió
     */
    /*public boolean comprovaColisio (){
        return true;
    }*/

    public boolean isViu() {
        return viu;
    }

    public void setViu(boolean viu) {
        this.viu = viu;
    }
}
