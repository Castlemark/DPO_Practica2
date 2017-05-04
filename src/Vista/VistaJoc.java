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

    public VistaJoc(){
        this.setSize(350, 350);
        t = new Timer(10, null);
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

    public void registraControlador (ControladorJoc cj){
        this.cj = cj;
        t.addActionListener(cj);
        addKeyListener(cj);
    }
}
