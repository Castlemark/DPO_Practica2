/*
 * Created by JFormDesigner on Thu May 11 09:00:17 CEST 2017
 */

package Vista;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tatiana CÃ¡ceres
 */
public class Prova5 extends JPanel {
    public Prova5() {
        initComponents();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tatiana CÃ¡ceres
        label6 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        label7 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        label8 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        label9 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();
        label10 = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 136, 0, 0, 214, 0, 131, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label6 ----
        label6.setText(" ");
        add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label1 ----
        label1.setText("Controls");
        label1.setFont(new Font("Akrobat", Font.BOLD, 20));
        add(label1, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label2 ----
        label2.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\arriba.png"));
        add(label2, new GridBagConstraints(3, 3, 1, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));
        add(textField1, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label3 ----
        label3.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\abajo.png"));
        add(label3, new GridBagConstraints(3, 6, 1, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label7 ----
        label7.setText(" ");
        add(label7, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));
        add(textField2, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label4 ----
        label4.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\derecha.png"));
        add(label4, new GridBagConstraints(3, 9, 1, 4, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label8 ----
        label8.setText(" ");
        add(label8, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));
        add(textField3, new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label5 ----
        label5.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\izq.png"));
        add(label5, new GridBagConstraints(3, 13, 1, 4, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label9 ----
        label9.setText(" ");
        add(label9, new GridBagConstraints(4, 14, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));
        add(textField4, new GridBagConstraints(4, 15, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- button1 ----
        button1.setText("Guardar");
        add(button1, new GridBagConstraints(6, 16, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));

        //---- label10 ----
        label10.setText(" ");
        add(label10, new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 25, 25), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    private JLabel label6;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label7;
    private JTextField textField2;
    private JLabel label4;
    private JLabel label8;
    private JTextField textField3;
    private JLabel label5;
    private JLabel label9;
    private JTextField textField4;
    private JButton button1;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
