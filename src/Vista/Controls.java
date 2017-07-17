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
    private JTextField jtfUp;
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
    private int teclaUp;
    private int teclaDown;
    private int teclaLeft;
    private int teclaRight;





    /**
     * Create the frame.
     */
    public Controls() {



        jlEspai = new JLabel();
        jlControls = new JLabel();
        jlUp = new JLabel(KeyEvent.getKeyText(teclaUp));
        jtfUp = new JTextField();
        jlDown = new JLabel(KeyEvent.getKeyText(teclaDown));
        jlEspai2 = new JLabel();
        jtfRight = new JTextField();
        jlRight = new JLabel(KeyEvent.getKeyText(teclaRight));
        jlEspai3 = new JLabel();
        jtfLeft = new JTextField();
        jlLeft = new JLabel(KeyEvent.getKeyText(teclaLeft));
        jlEspai4 = new JLabel();
        jtfDown = new JTextField();
        jbGuardar = new JButton();
        jlEspai5 = new JLabel();

        //======== this ========


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
        jlUp.setIcon(new ImageIcon("imatges\\arriba.png"));
        add(jlUp, new GridBagConstraints(3, 3, 1, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfUp, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- label3 ----
        jlDown.setIcon(new ImageIcon("imatges\\abajo.png"));
        add(jlDown, new GridBagConstraints(3, 6, 1, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai2 ----
        jlEspai2.setText(" ");
        add(jlEspai2, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfDown, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlRight ----
        jlRight.setIcon(new ImageIcon("imatges\\derecha.png"));
        add(jlRight, new GridBagConstraints(3, 9, 1, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai3 ----
        jlEspai3.setText(" ");
        add(jlEspai3, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfRight, new GridBagConstraints(4, 11, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlLeft ----
        jlLeft.setIcon(new ImageIcon("imatges\\izq.png"));
        add(jlLeft, new GridBagConstraints(3, 13, 1, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));

        //---- jlEspai4 ----
        jlEspai4.setText(" ");
        add(jlEspai4, new GridBagConstraints(4, 14, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 25, 25), 0, 0));
        add(jtfLeft, new GridBagConstraints(4, 15, 1, 1, 0.0, 0.0,
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

        //Events

        jtfLeft.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {



                teclaLeft = e.getKeyCode();
                jtfLeft.setText("");
                jlLeft.setText( e.getKeyText(e.getKeyCode()));

            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jtfRight.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {


                teclaRight = e.getKeyCode();
                jtfRight.setText("");
                jlRight.setText( e.getKeyText(e.getKeyCode()));

            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jtfDown.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {


                teclaDown = e.getKeyCode();
                jtfDown.setText("");
                jlDown.setText( e.getKeyText(e.getKeyCode()));

            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jtfUp.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {



                teclaUp = e.getKeyCode();
                jtfUp.setText("");
                jlUp.setText( e.getKeyText(e.getKeyCode()));

            }

            public void keyReleased(KeyEvent e) {
            }
        });

    }

    public void registerController( Controlador c){
        jbGuardar.setActionCommand("GUARDAR");
        jbGuardar.addActionListener(c);

    }

    public void actualitzaControls(int up, int down, int left, int right){
        teclaUp=up;
        teclaDown=down;
        teclaLeft=left;
        teclaRight=right;

    }
}