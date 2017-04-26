package controlador;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.util.Scanner;

/**
 * Created by Grup 6 on 13/04/2017.
 */
public class ThreadEnviar extends Thread {
    private DataOutputStream doStream;
    private Scanner sc;

    public ThreadEnviar(Scanner sc, DataOutputStream doStream){
        this.doStream = doStream;
        this.sc = sc;
    }
    @Override
    public void run(){
        try{
            while (true){
                String message = sc.nextLine();
                doStream.writeUTF(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
