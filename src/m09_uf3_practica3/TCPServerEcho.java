package m09_uf3_practica3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServerEcho {

    static int PORT = 45832;

    public TCPServerEcho(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket accept = serverSocket.accept();

            DataOutputStream envioServer = new DataOutputStream(accept.getOutputStream());
            BufferedReader bufferEntradaServidor = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            String msg = bufferEntradaServidor.readLine();
            System.out.println(msg);

            envioServer.writeBytes(msg + " cliente \n");
            JOptionPane.showMessageDialog(null, msg);

            envioServer.close();
            bufferEntradaServidor.close();
            //serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new TCPServerEcho(PORT);
    }

}
