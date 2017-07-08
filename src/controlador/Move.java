package controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Propietario on 05/07/2017.
 */
public class Move extends AbstractAction{
    private ControladorJoc cj;
    private int i;

    public Move(int i, ControladorJoc cj){
        this.i = i;
        this.cj = cj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        cj.moureSerp(i);
    }

}
