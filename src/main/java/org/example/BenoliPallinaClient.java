package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BenoliPallinaClient extends JFrame {
    private Socket connessione;
    private DataOutputStream out;
    private DataInputStream in;

    public BenoliPallinaClient() {
        super("mario benoli");
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connetti();
        this.setVisible(true);
    }

    private void connetti() {
        try{
            connessione=new Socket("localhost",6789);
            out=new DataOutputStream(connessione.getOutputStream());
            in=new DataInputStream(connessione.getInputStream());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"errore",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        //inizio l'animazione
        Container contenitore = this.getContentPane();
        PannelloClient pan = new PannelloClient(this,contenitore.getSize());
        contenitore.add(pan);
    }

    public DataOutputStream getOutput() {
        return out;
    }

    public DataInputStream getInput() {
        return in;
    }
}
