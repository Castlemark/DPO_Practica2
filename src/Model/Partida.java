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
    private ArrayList<Model.Serp> serps = new ArrayList<>();
    private int serp;

    private boolean viu;

    public Partida(int s){
        viu = true;
        for(int i = 0; i < s; i++){
            serps.add(new Serp(i));
        }
    }



    public boolean comprovaCollisio(){

        Model.Posicio cap = serps.get(serp).getCap();
        //Comprova que no surti dels limits de la partida
        if(cap.getX() > 350 || cap.getX() < 0 || cap.getY() > 350 || cap.getY() < 0){
            return true;
        }
        //Comprova que no xoqui amb ella mateixa
        ArrayList<Posicio> posicions = serps.get(serp).getPosicions();
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

        //Comprova que no xoqui amb altres serps
        for(int i = 0; i < serps.size(); i++){
            ArrayList<Posicio> pos = serps.get(i).getPosicions();
            Posicio c = serps.get(i).getCap();
            if(i != serp){
                //OLLA MAXIMA
            }
        }

        return false;
    }

    /**
     * Getter de serps
     * @return Objecte serp
     */
  /*  public Serp getSerp() {
        return serps.get(serp);
    }/*

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

    public ArrayList<Serp> getSerps() {
        return serps;
    }

    public void setSerp(int serp) {
        this.serp = serp;
    }

    public int getSerp() {
        return serp;
    }
}
