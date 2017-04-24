package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 24/04/2017.
 */
public class TancarSessio extends JFrame{
    private JPanel jpTancar;
    private JPanel jpAtras;
    private JPanel jpButtons;
    private JButton jbAtras;
    private JLabel jlTitle;
    private JLabel jlPregunta;
    private JButton jbSi;
    private JButton jbNo;

    public TancarSessio () {
        this.setTitle ("Tancar Sessió");
        this.setSize (350,350);
        this.setResizable(true);

        jpTancar = new JPanel();
        jpAtras = new JPanel(new BorderLayout());
        jpButtons = new JPanel (new BorderLayout());

        jbAtras = new JButton ("<- ");
        jlTitle = new JLabel("Ta")

    }
}
