/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class Cliente {
    private Socket Cliente;

    public Cliente() {
    }

    public Socket getCliente() {
        return Cliente;
    }

    public void setCliente(Socket Cliente) {
        this.Cliente = Cliente;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        
        Cliente cli = new Cliente();
        
        HashMap<String, String> hash = new HashMap();
        hash.put("\n\n1.Hola", "\nUn placer como estas?");
        hash.put("\n\n2.Bien y tu", "\nBien en salud jaja por cierto has escuchado las noticias de digimon?");
        hash.put("\n\n3.no, por que?", "\nvan a sacar un nuevo dispositivo");
        hash.put("\n\n4.o enserio, va a ser un nuevo vpet?", "\naaaa casi pero no en este caso sacaran un vital brasalet");
        hash.put("\n\n5.a y que es eso si no es un nuevo vpet?", "\nes una smarth band que te permitira criar digimos en base a tu salud");
        hash.put("\n\n6.aaaa que dices?", "\nsi en si la banda revisra tus signos vitales y los impondra a tu digimon");
        hash.put("\n\n7.aaa es muy .. interesante pero no creo comprarlo", "\na que por que?");
        hash.put("\n\n8.Cliente soy una clase java y tu igual", "\naaaaaa .... detalles");
        hash.put("\n\n9.hay dios mio, rindete lo maximo que lograriamos es solo correr los viedeojuegos que saca la franquicia de digimon", "\nbueno es verdad y cual es tu favorito entonces?");
        hash.put("\n\n10.me gusta la version cyber sleuth y la tuya?", "\nme gusta la version recore es mas divertida jaja bueno a seguir con el programa");
        
        try {
            cli.setCliente(new Socket("127.0.0.1", 5556));
            //System.out.println(clienteConexion.getInetAddress());
            Socket clienteConexion = cli.getCliente();
            salida = new DataOutputStream(clienteConexion.getOutputStream());
            entrada = new DataInputStream(clienteConexion.getInputStream());     
            System.out.println(entrada.readUTF());
            String Busqueda = "";
            String respuesta ="";
            /*while(true) {
                System.out.println("prueba de que almenos inicia");
                salida.writeUTF(hash.get(hash));
                System.out.println(entrada.readUTF());
            }*/
            while(true) {
                    System.out.println("prueba de que almenos inicia\n");
                    salida.writeUTF(hash.toString());
                    salida.writeUTF(entrada.readUTF());
                    System.out.println(entrada.readUTF());
                    break;
                }
        } catch (IOException ex) {
            System.out.println("Errror en CLIENTE detectado");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
