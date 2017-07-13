package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Classe del panell de ranquing
 * Created by Grup 6 on 04/05/2017.
 */
public class Ranquing extends  JPanel {
    private JButton jbConfig;
    private JButton jbTancar;
    private JLabel jl2X;
    private JLabel jl4X;
    private JLabel jlCamp;
    private JList jlist2X;
    private JList jlist4X;
    private JList jlistCamp;
    private JButton jb2X;
    private JButton jb4X;
    private JButton jbCamp;

    /**
     * Constructor de la classe
     */
    public Ranquing (){

        initComponents();
    }

    /**
     * Mètode que inicialitza els elements
     */
    private void initComponents() {
        jbConfig = new JButton();
        jbTancar = new JButton();
        jl2X = new JLabel();
        jl4X = new JLabel();
        jlCamp = new JLabel();
        jlist2X = new JList();
        jlist4X = new JList();
        jlistCamp = new JList();
        jb2X = new JButton();
        jb4X = new JButton();
        jbCamp = new JButton();



        setLayout(new GridBagLayout());
        ((GridBagLayout)

                getLayout()).columnWidths = new int[] {
                67, 96, 101, 95, 59, 0
        }

        ;
        ((GridBagLayout)

                getLayout()).rowHeights = new int[] {
                0, 0, 93, 0, 0, 0
        };
        ((GridBagLayout)

                getLayout()).columnWeights = new double[] {
                0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4
        };
        ((GridBagLayout)

                getLayout()).rowWeights = new double[] {
                0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4
        };

        //---- Botó enrere ----
        jbConfig.setText("Img enrere");

        add(jbConfig, new GridBagConstraints(0, 0,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- Botó tancar ----
        jbTancar.setText("Tancar");

        add(jbTancar, new GridBagConstraints(4, 0,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,0), 0,0));

        //---- text rànquing 2x ----
        jl2X.setText("Ranquing 2X");
        jl2X.setHorizontalAlignment(SwingConstants.CENTER);

        add(jl2X, new GridBagConstraints(1, 1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- text ranquing 4x ----
        jl4X.setText("Raquing 4X");
        jl4X.setHorizontalAlignment(SwingConstants.CENTER);

        add(jl4X, new GridBagConstraints(2, 1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- text ranquing campionat ----
        jlCamp.setText("Ranquing Campionat");
        jlCamp.setHorizontalAlignment(SwingConstants.CENTER);

        add(jlCamp, new GridBagConstraints(3, 1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        add(jlist2X, new GridBagConstraints(1, 2,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        add(jlist4X, new GridBagConstraints(2, 2,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        add(jlistCamp, new GridBagConstraints(3, 2,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- boto 2x ----
        jb2X.setText("2X");

        add(jb2X, new GridBagConstraints(1, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- boto 4x ----
        jb4X.setText("4X");

        add(jb4X, new GridBagConstraints(2, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- boto campionat ----
        jbCamp.setText("Campionat");
        add(jbCamp, new GridBagConstraints(3, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));
    }

    public void registerController(ActionListener c){
        jb2X.addActionListener(c);
        jb4X.addActionListener(c);
        jbCamp.addActionListener(c);

        jb2X.setActionCommand("JOC2");
        jb4X.setActionCommand("JOC4");
        jbCamp.setActionCommand("CAMPEONAT");
    }
}
