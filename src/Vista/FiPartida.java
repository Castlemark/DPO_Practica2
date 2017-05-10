package Vista;

import javax.swing.*;
import java.awt.*;


/**
 * Created by sullivan on 08/05/2017.
 */
public class FiPartida extends JPanel {

    private JLabel jlTitle;
    private JLabel jlPosicio;
    private JLabel label6;
    private JLabel jlPuntuacio;
    private JLabel label7;
    private JLabel jlPunts;
    private JLabel label8;
    private String missatge;
    private int posicio = 0;
    private int puntuacio = 0;
    private int puntsTotals = 0;

    public FiPartida(boolean resultat) {

        if (resultat) {
            missatge = "TU GUANYES!";
        } else {
            missatge = "TU PERDS!";
        }

        initComponents();
    }

    private void initComponents() {

        jlTitle = new JLabel();
        jlPosicio = new JLabel();
        label6 = new JLabel();
        jlPuntuacio = new JLabel();
        label7 = new JLabel();
        jlPunts = new JLabel();
        label8 = new JLabel();

        //======== this ========

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {181, 183, 245, 245, 196, 198, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {147, 0, 0, 0, 0, 131, 76, 160, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};


        jlTitle.setText(missatge);
        jlTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        jlTitle.setFont(new Font("Akrobat ExtraBold", Font.PLAIN, 48));
        jlTitle.setForeground(new Color(255, 137, 142));
        add(jlTitle, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        jlPosicio.setText("Posicio:");
        jlPosicio.setFont(new Font("Akrobat", Font.PLAIN, 24));
        add(jlPosicio, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        label6.setFont(new Font("Akrobat", Font.PLAIN, 20));
        label6.setText("posicio");
        label6.setHorizontalAlignment(SwingConstants.LEFT);
        add(label6, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        jlPuntuacio.setText("Puntuacio partida:");
        jlPuntuacio.setFont(new Font("Akrobat", Font.PLAIN, 24));
        add(jlPuntuacio, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        label7.setText("puntuacio");
        label7.setFont(new Font("Akrobat", Font.PLAIN, 20));
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        jlPunts.setText("Puntuacio total:");
        jlPunts.setFont(new Font("Akrobat", Font.PLAIN, 24));
        add(jlPunts, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));


        label8.setText("puntsTotals");
        label8.setFont(new Font("Akrobat", Font.PLAIN, 20));
        label8.setHorizontalAlignment(SwingConstants.LEFT);
        add(label8, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 41, 60), 0, 0));

    }

}
