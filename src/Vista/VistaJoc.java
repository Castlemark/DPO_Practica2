package Vista;

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



    public VistaJoc(){
        this.setSize(350, 350);
        t = new Timer(1000, null);
        cont = true;
        temps = 3;
    }

    public void iniciar(){
        cj.setContador(3);
        t.start();
        cont = true;
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics g) {

        ArrayList<Posicio> serp = cj.getSerp().getPosicions();
        Posicio cap = cj.getSerp().getCap();

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (cont){
            if(cj.getContador() == 4){
                g2d.drawString("Esperant als altres jugadors...", 70, 150);

            }else {
                g2d.drawString(cj.getContador()+"", 150, 150);
            }
        }else{
            g2d.setPaint(Color.RED);
            g2d.drawLine(serp.get(serp.size()-1).getX(), serp.get(serp.size()-1).getY(), cap.getX(), cap.getY());

            for(int i = 0; i < serp.size() -1; i++){

                g2d.drawLine(serp.get(i).getX(), serp.get(i).getY(), serp.get(i + 1).getX(), serp.get(i + 1).getY());
            }
            if(cj.getModel().getPartida().isViu()) {
                t.start();
            }else {
                t.stop();
            }
        }

    }

    public void registraControlador (ControladorJoc cj){
        this.cj = cj;
        t.addActionListener(cj);
        t.setActionCommand("TIMER");
        addKeyListener(cj);
    }

    public void setCont(boolean cont) {
        if(cont){
           t.setDelay(1000);
        }else {
            t.setDelay(10);
        }
        this.cont = cont;
    }

    public boolean isCont() {
        return cont;
    }
}
