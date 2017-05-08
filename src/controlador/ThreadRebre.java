package controlador;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by Grup 6 on 13/04/2017.
 */
public class ThreadRebre extends Thread {
    private DataInputStream diStream;
    public ThreadRebre(DataInputStream diStream) {
        this.diStream = diStream;
    }
    @Override
    public void run(){
        while(true){
            String missatge = null;
            try {
                missatge = diStream.readUTF();
                System.out.println(missatge);
            } catch (EOFException e ){
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}