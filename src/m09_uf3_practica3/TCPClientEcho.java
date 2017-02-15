package m09_uf3_practica3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPClientEcho {

    static String HOST = "localhost";
    static int PORT = 45832;
    
    public TCPClientEcho(String host, int port) throws IOException{
        Socket connectionSocket = new Socket(host, port);
        
        DataOutputStream envioServer = new DataOutputStream(connectionSocket.getOutputStream());
        BufferedReader bufferEntradaCliente = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
                        
        envioServer.writeBytes("Hola  \n");        
        
        String msg = bufferEntradaCliente.readLine();
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
        
        envioServer.close();
        bufferEntradaCliente.close();
        connectionSocket.close();
    }
    
    public static void main(String[] args) throws IOException {
        new TCPClientEcho(HOST, PORT);
        
    }

}
