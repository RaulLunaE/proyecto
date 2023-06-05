/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class Servidor {
    private ServerSocket servidor;
    private int puerto;

    public Servidor() {
    }
    
     public Servidor(int puerto) {
        this.puerto = puerto;
        try {
            servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        
        Servidor ser = new Servidor(5556);
        
        HashMap<String, String> hash = new HashMap();
        hash.put("\n\n1.Hola","\nBien y tu");
        hash.put("\n\n2.Bien en salud jaja por cierto has escuchado las noticias de digimon?", "\nno, por que?");
        hash.put("\n\n3.van a sacar un nuevo dispositivo", "\no enserio, va a ser un nuevo vpet?");
        hash.put("\n\n4.aaaa casi pero no en este caso sacaran un vital brasalet", "\na y que es eso si no es un nuevo vpet?");
        hash.put("\n\n5.es una smarth band que te permitira criar digimos en base a tu salud", "\naaaa que dices?");
        hash.put("\n\n6.si en si la banda revisra tus signos vitales y los impondra a tu digimon", "\naaa es muy .. interesante pero no creo comprarlo");
        hash.put("\n\n7.a que por que?", "\nCliente soy una clase java y tu igual");
        hash.put("\n\n8.aaaaaa .... detalles", "\nhay dios mio, rindete lo maximo que lograriamos es solo correr los viedeojuegos que saca la franquicia de digimon");
        hash.put("\n\n9.bueno es verdad y cual es tu favorito entonces?", "\nme gusta la version cyber sleuth y la tuya?");
        hash.put("\n\n10.me gusta la version recore es mas divertida jaja bueno a seguir con el programa", "\nes verdad aun asi que haremos despues de programar sabes?");
        
        Socket clienteConexion;
        try {
            clienteConexion = ser.getServidor().accept();
            salida = new DataOutputStream(clienteConexion.getOutputStream());
            entrada = new DataInputStream(clienteConexion.getInputStream());
            salida.writeUTF("SOLICITUD ACEPTADA");
            String busqueda = "";
            while(true) {
                    System.out.println("prueba de que almenos inicia Servidor\n");
                    salida.writeUTF(entrada.readUTF());
                    salida.writeUTF(hash.toString());
                    System.out.println(entrada.readUTF());
                    break;
                }
        } catch (IOException ex) {
            System.out.println("Errror en SERVIDOR detectado");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
