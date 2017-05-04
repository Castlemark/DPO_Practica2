/*
 * Created by JFormDesigner on Wed May 03 09:29:54 CEST 2017
 */

package Vista;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tatiana CÃ¡ceres
 */
public class Proba3 extends JPanel {
    public Proba3() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tatiana CÃ¡ceres
        label5 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label6 = new JLabel();
        label3 = new JLabel();
        label7 = new JLabel();
        label4 = new JLabel();
        label8 = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label5 ----
        label5.setText(" ");
        add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label1 ----
        label1.setText("You lost");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Akrobat ExtraBold", Font.PLAIN, 26));
        add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label2 ----
        label2.setText("Posicio:");
        label2.setFont(new Font("Akrobat", Font.PLAIN, 20));
        add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label6 ----
        label6.setText("posicio");
        add(label6, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label3 ----
        label3.setText("Puntuacio partida:");
        label3.setFont(new Font("Akrobat", Font.PLAIN, 20));
        add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label7 ----
        label7.setText("punt part");
        add(label7, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 44, 58), 0, 0));

        //---- label4 ----
        label4.setText("Puntuacio total:");
        label4.setFont(new Font("Akrobat", Font.PLAIN, 20));
        add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 58), 0, 0));

        //---- label8 ----
        label8.setText("punt tot");
        add(label8, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 58), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Tatiana CÃ¡ceres
    private JLabel label5;
    private JLabel label1;
    private JLabel label2;
    private JLabel label6;
    private JLabel label3;
    private JLabel label7;
    private JLabel label4;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
