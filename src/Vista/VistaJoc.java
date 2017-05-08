package Vista;

import controlador.Controlador;
import controlador.ControladorJoc;
import model.Posicio;

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

    public VistaJoc(){
        this.setSize(350, 350);
        t = new Timer(10, null);
        inici = new Timer(1000, null);
        cont = true;
    }

    public void iniciar(){
        cont = true;
        while (cont){
            inici.start();
        }
        inici.stop();
        t.start();
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
            g2d.drawString(cj.getContador()+"", 150, 150);
            inici.start();
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
        inici.addActionListener(cj);
        inici.setActionCommand("CONTA");
        t.addActionListener(cj);
        t.setActionCommand("AVANÇA");
        addKeyListener(cj);
    }

    public void setCont(boolean cont) {
        this.cont = cont;
    }

    public boolean isCont() {
        return cont;
    }
}
