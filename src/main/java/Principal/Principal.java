package Principal;

import Model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String args[]) {
        try {
            
            String address = JOptionPane.showInputDialog(null, "Digite o endereço: ");
            int port = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da porta: "));
            
            Socket servidor = new Socket(address, port);
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
            
            Cliente in = new Cliente(servidor);
            in.start();
            
            String mensagem = "";
            while (!mensagem.equals("fim")) {
                mensagem = JOptionPane.showInputDialog("Digite a mensagem ou fim para sair: ");
                out.println("Cliente: " + mensagem);
            }
        } catch (IOException io) {
            System.err.println("Problemas de IO.");
        }
    }
}
