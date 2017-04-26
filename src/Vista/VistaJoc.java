package Vista;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Propietario on 26/04/2017.
 */
public class VistaJoc extends JFrame {
    int x1;
    int y1;
    int x2;
    int y2;
    int midx;
    int midy;

    public VistaJoc(int x1, int y1, int x2, int y2){
        this.setSize(350, 350);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        midx = (x1+x2)/2;
        midy = (y1+y2)/2;
    }

    public void animateLine(Graphics g){
        g.drawLine(x1,y1,midx,midy);
        g.drawLine(x2,y2,midx,midy);
    }

    public void paintComponent(Graphics g){
        final Graphics2D g2d = (Graphics2D)g;
        animateLine(g2d);
    }
    }

