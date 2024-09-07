/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jostin;

import java.util.logging.Level;
import java.util.logging.Logger;
import jostin.imc.rmiNet.Servidor;

/**
 *
 * @author Jostin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        try {
            servidor.inicar();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
}
