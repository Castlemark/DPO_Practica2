package Vista;

import javax.swing.*;
import java.awt.*;

/**
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

    public Ranquing (){
        initComponents();
    }
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

        //======== this ========

        // JFormDesigner evaluation mark

        this.setBorder (new javax.swing.border.CompoundBorder (
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0,0,0),
                        "JFormDesigner Evaluation",javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialog",java.awt.Font.BOLD,12),
                        java.awt.Color.red),

                this.getBorder()));

        this.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                                           public void propertyChange (java.beans.PropertyChangeEvent e){
                                               if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                                           }
                                       }

        );


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

        //---- button1 ----
        jbConfig.setText("text");

        add(jbConfig, new GridBagConstraints(0, 0,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- button2 ----
        jbTancar.setText("Tancar");

        add(jbTancar, new GridBagConstraints(4, 0,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,0), 0,0));

        //---- label1 ----
        jl2X.setText("Ranquing 2X");
        jl2X.setHorizontalAlignment(SwingConstants.CENTER);

        add(jl2X, new GridBagConstraints(1, 1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- label2 ----
        jl4X.setText("Raquing 4X");
        jl4X.setHorizontalAlignment(SwingConstants.CENTER);

        add(jl4X, new GridBagConstraints(2, 1,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- label3 ----
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

        //---- button3 ----
        jb2X.setText("2X");

        add(jb2X, new GridBagConstraints(1, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- button4 ----
        jb4X.setText("4X");

        add(jb4X, new GridBagConstraints(2, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));

        //---- button5 ----
        jbCamp.setText("Campionat");

        add(jbCamp, new GridBagConstraints(3, 3,1,1,0.0,0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0,20,17), 0,0));
    }
}
