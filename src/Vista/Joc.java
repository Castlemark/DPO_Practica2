/*
 * Created by JFormDesigner on Mon May 08 17:24:59 CEST 2017
 */

package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.jgoodies.forms.factories.*;
import controlador.ControladorJoc;
import controlador.Move;

/**
 * @author unknown
 */
public class Joc extends JPanel {
    public Joc() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Pau Nonell
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel1 = new VistaJoc();
        button1 = new JButton();

        //======== this ========


        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {13, 79, 75, 76, 70, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {13, 26, 190, 31, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("");
        add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("");
        add(label2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("");
        add(label3, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("");
        add(label4, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 255, 255));
            panel1.setBorder(LineBorder.createBlackLineBorder());
            panel1.setLayout(new BorderLayout());
        }
        add(panel1, new GridBagConstraints(1, 2, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- button1 ----
        button1.setText("Abandonar");
        add(button1, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents





    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Pau Nonell
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private VistaJoc panel1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void registraControlador (ControladorJoc cj){
        panel1.registraControlador(cj);
        button1.addActionListener(cj);
        button1.setActionCommand("ABANDONA");

        panel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
        panel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
        panel1.getActionMap().put("down", new Move(2));
    }

    public VistaJoc getPanel1() {
        return panel1;
    }

    public void iniciaJoc(){
        panel1.iniciar();
    }

    public void insereixJugador(String[] logins){
        switch (logins.length){
            case 2:
                label1.setText(logins[0]);
                label4.setText(logins[1]);
                break;
            case 3:
                label1.setText(logins[0]);
                label2.setText(logins[1]);
                label3.setText(logins[2]);
                break;
            case 4:
                label1.setText(logins[0]);
                label2.setText(logins[1]);
                label3.setText(logins[2]);
                label4.setText(logins[3]);
                break;

        }
    }

}
