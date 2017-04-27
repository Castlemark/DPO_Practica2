package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 24/04/2017.
 */
public class TancarSessio extends JPanel {
    private JPanel jpTancar;
    private JPanel jpButtons;
    private JLabel jlPregunta;
    private JButton jbSi;
    private JButton jbNo;

    public TancarSessio () {

        this.setSize (350,200);

        jpTancar = new JPanel();
        jpButtons = new JPanel (new BorderLayout());

        jlPregunta = new JLabel("                 Estàs segur de que vols tancar sessió?");
        jbSi = new JButton ("Sí");
        jbNo = new JButton("No");

        jpTancar.setLayout(new GridLayout(2,1));
        jpButtons.add(jbSi, BorderLayout.LINE_START);
        jpButtons.add(jbNo, BorderLayout.LINE_END);

        jpTancar.add(jlPregunta, BorderLayout.CENTER);
        jpTancar.add(jpButtons, BorderLayout.CENTER);

        this.add(jpTancar, BorderLayout.CENTER);
    }
}
