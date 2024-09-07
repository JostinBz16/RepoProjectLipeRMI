/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jostin.imc.rmiNet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jostin.imc.rmLib.ICalculoRemotoImc;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 *
 * @author Jostin
 */
public class Servidor {
    private int puerto = 1616;
    private CallHandler invocador;
    private Server servidor;
    private CalculoRmiImcImpl calculo;
    private ICalculoRemotoImc calculoRemoto;

    public Servidor() {
        invocador = new CallHandler();
        servidor = new Server();
        calculo = new CalculoRmiImcImpl();
    }
    
    public void inicar()throws Exception{
        try {
            invocador.registerGlobal(ICalculoRemotoImc.class, calculo);
            try {
                servidor.bind(puerto, invocador);
            } catch (IOException ex) {
                throw  new Exception("Error: No es posible invocar metodos remotos.");
            }
        } catch (LipeRMIException ex) {
            throw  new Exception("Error: I/O.");
        }
        
    }
    
    public void detener(){
        servidor.close();
    } 
}
