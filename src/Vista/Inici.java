package Vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sullivan on 04/05/2017.
 */
public class Inici extends JPanel {
    private JLabel jlEspai;
    private JLabel jlTitle;
    private Configuracio jpConfi;

    public Inici () {
        initComponents();
    }

    private void initComponents() {
        jlEspai = new JLabel();
        jlTitle = new JLabel();
        jpConfi = new Configuracio ();

        //======== this ========

        setLayout(new GridBagLayout());

        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label2 ----
        jlEspai.setText(" ");
        add(jlEspai, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 53, 73), 0, 0));

        //---- label1 ----
        jlTitle.setText("LSTRONER WELCOME!");
        jlTitle.setFont(new Font("Akrobat ExtraBold", Font.PLAIN, 26));
        add(jlTitle, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 53, 73), 0, 0));

        //======== panel1 ========

        add(jpConfi, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 53, 73), 0, 0));
    }

    public void registerController(Controlador c){

       // registerController();
    }


}
