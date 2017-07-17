package Vista;

import Model.Serp;
import controlador.Controlador;
import controlador.ControladorJoc;
import Model.Posicio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Propietario on 26/04/2017.
 */

public class VistaJoc extends JPanel {
    private ControladorJoc cj;
    private Timer t;
    private Timer inici;
    private boolean cont;
    private int temps;
    private boolean fi;
    private int punts;
    private String posicio;
    private int total;



    public VistaJoc(){
        this.setSize(350, 350);
        t = new Timer(1000, null);
        cont = true;
        fi = false;
        temps = 3;
    }

    public void iniciar(){
        cj.setContador(3);
        t.start();
        cont = true;
    }

    public void aturar(){
        System.out.println("aturar");
        fi = true;
        t.setActionCommand("FI");
        t.setDelay(1000);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics g) {

        ArrayList<Serp> serps = cj.getSerps();
        ArrayList<ArrayList<Posicio>> posicions = new ArrayList<>();
        ArrayList<Posicio> caps = new ArrayList<>();
        for(int i = 0; i < serps.size(); i++){
            posicions.add(serps.get(i).getPosicions());
            caps.add(serps.get(i).getCap());
        }

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (cont){
            if(cj.getContador() == 4){
                g2d.drawString("Esperant als altres jugadors...", 70, 150);
            }else {
                g2d.drawString(cj.getContador()+"", 150, 150);
            }
        }else{
            for (int j = 0; j < serps.size(); j++) {
                ArrayList<Posicio> serp = posicions.get(j);
                Posicio cap = caps.get(j);
                switch (j) {
                    case 0:
                        g2d.setPaint(Color.RED);
                        break;
                    case 1:
                        g2d.setPaint(Color.BLUE);
                        break;
                    case 2:
                        g2d.setPaint(Color.GREEN);
                        break;
                    case 3:
                        g2d.setPaint(Color.YELLOW);
                        break;
                }
                g2d.drawLine(serp.get(serp.size() - 1).getX(), serp.get(serp.size() - 1).getY(), cap.getX(), cap.getY());

                for (int i = 0; i < serp.size() - 1; i++) {

                    g2d.drawLine(serp.get(i).getX(), serp.get(i).getY(), serp.get(i + 1).getX(), serp.get(i + 1).getY());
                }
            }
            if(fi){
                g2d.setPaint(Color.BLACK);
                g2d.drawString("Has quedat " + posicio, 70, 50);
                g2d.drawString("Has guanyat/perdut " + punts, 70, 100);
                g2d.drawString("En total tens " + total, 70, 150);

            }

        }

    }

    public void registraControlador (ControladorJoc cj){
        this.cj = cj;
        t.addActionListener(cj);
        t.setActionCommand("TIMER");
      //  addKeyListener(cj);
    }

    public void setCont(boolean cont) {
        if(cont){
           t.setDelay(1000);
        }else {
            t.setDelay(50);
        }
        this.cont = cont;
    }

    public boolean isCont() {
        return cont;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }
    public void reinicia(){
        t.setActionCommand("TIMER");
        cont = true;
        fi = false;
    }

    public boolean isFi() {
        return fi;
    }
}
