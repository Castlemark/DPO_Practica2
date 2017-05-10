/*
 * Created by JFormDesigner on Mon May 08 17:15:52 CEST 2017
 */

package Vista;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tatiana Cáceres
 */
public class Identificacio extends JPanel {

    private JLabel jlRegistre;
    private JLabel jlIniciar;
    private Registre jpRegistre;
    private IniciarSessio jpIniciar;
    private JLabel jlEspai;
    private JLabel jlEspai2;


    public Identificacio(){

        initComponents();
    }

    private void initComponents() {

        jlEspai = new JLabel();
        jlRegistre = new JLabel();
        jlIniciar = new JLabel();
        jpRegistre = new Registre();
        jpIniciar = new IniciarSessio ();
        jlEspai2 = new JLabel();

        //======== this ========


        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //---- label3 ----
        jlEspai.setText(" ");
        add(jlEspai, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        jlEspai2.setText(" ");
        add(jlEspai2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label1 ----
        jlRegistre.setText("Registra't");
        jlRegistre.setFont(new Font("Akrobat Bold", Font.PLAIN, 24));
        add(jlRegistre, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label2 ----
        jlIniciar.setText("Inicia Sessi\u00f3");
        jlIniciar.setFont(new Font("Akrobat Bold", Font.PLAIN, 24));
        add(jlIniciar, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //======== panel1 ========

        add(jpRegistre, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //======== panel2 ========

        add(jpIniciar, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}