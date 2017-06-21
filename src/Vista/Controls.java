package Vista;


import controlador.Controlador;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.KeyEvent;




/**
 * Created by sullivan on 10/05/2017.
 */
/*public class Controls extends JPanel {
    public KeyEvent key;

    public Controls() throws IOException {
        int numero = 0;
        System.out.println("tecla:");
        Scanner SC = new Scanner(System.in);
        char code;
        code = SC.next(".").charAt(0);
        char c = (char) System.in.read();
        key = new KeyEvent();

        numero = key.getKeyCode();
        System.out.println(numero);


    }



}*/

import java.awt.event.*;
import javax.swing.*;

public class Controls extends JPanel {

    private JPanel contentPane;
    private JLabel jlEspai;
    private JLabel jlControls;
    private JLabel jlUp;
    private JTextField jtUp;
    private JLabel jlDown;
    private JLabel jlEspai2;
    private JTextField jtfRight;
    private JLabel jlRight;
    private JLabel jlEspai3;
    private JTextField jtfLeft;
    private JLabel jlLeft;
    private JLabel jlEspai4;
    private JTextField jtfDown;
    private JButton jbGuardar;
    private JLabel jlEspai5;




    /**
     * Create the frame.
     */
    public Controls() {

        jlEspai = new JLabel();
        jlControls = new JLabel();
        jlUp = new JLabel();
        jtUp = new JTextField();
        jlDown = new JLabel();
        jlEspai2 = new JLabel();
        jtfRight = new JTextField();
        jlRight = new JLabel();
        jlEspai3 = new JLabel();
        jtfLeft = new JTextField();
        jlLeft = new JLabel();
        jlEspai4 = new JLabel();
        jtfDown = new JTextField();
        jbGuardar = new JButton();
        jlEspai5 = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 136, 0, 0, 214, 0, 131, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label6 ----
        jlEspai.setText(" ");
        add(jlEspai, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label1 ----
        jlControls.setText("Controls");
        jlControls.setFont(new Font("Akrobat", Font.BOLD, 20));
        add(jlControls, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label2 ----
        jlUp.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\arriba.png"));
        add(jlUp, new GridBagConstraints(3, 3, 1, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtUp, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label3 ----
        jlDown.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\abajo.png"));
        add(jlDown, new GridBagConstraints(3, 6, 1, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai2 ----
        jlEspai2.setText(" ");
        add(jlEspai2, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfRight, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlRight ----
        jlRight.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\derecha.png"));
        add(jlRight, new GridBagConstraints(3, 9, 1, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai3 ----
        jlEspai3.setText(" ");
        add(jlEspai3, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfLeft, new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlLeft ----
        jlLeft.setIcon(new ImageIcon("C:\\Users\\sullivan\\Documents\\DPO\\Troner\\izq.png"));
        add(jlLeft, new GridBagConstraints(3, 13, 1, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai4 ----
        jlEspai4.setText(" ");
        add(jlEspai4, new GridBagConstraints(4, 14, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfDown, new GridBagConstraints(4, 15, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jbGuardar ----
        jbGuardar.setText("Guardar");
        add(jbGuardar, new GridBagConstraints(6, 16, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai5 ----
        jlEspai5.setText(" ");
        add(jlEspai5, new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));


        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setFocusable(true);

        //Eventos

        jtfLeft.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                //Aqui no funcionara
            }

            public void keyPressed(KeyEvent e) {

                int tecla = 0;

                tecla = e.getKeyCode();
                System.out.print(tecla);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(contentPane, "Has pulsado Enter");
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

            public void keyReleased(KeyEvent e) {
                //Aqui tambien puedes insertar el codigo
            }
        });

    }

    public void regiterController( Controlador c){
        jbGuardar.setActionCommand("GUARDAR");
        jbGuardar.addActionListener(c);

    }
}