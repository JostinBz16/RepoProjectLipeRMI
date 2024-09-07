/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jostin.imc.rmiNet;

import jostin.imc.rmLib.DatosImc;
import jostin.imc.rmLib.ICalculoRemotoImc;

/**
 *
 * @author Jostin
 */
public class CalculoRmiImcImpl implements ICalculoRemotoImc {

    private DatosImc datos;

    public CalculoRmiImcImpl() {
    }

    @Override
    public DatosImc CalcularImc(DatosImc datos) {
        float resultado = 0;
        if (datos.getPeso() <= 0 || datos.getAltura() <= 0) {
            datos.setInterpretacion("Error: el peso y la altura deben ser mayores que 0.");
            return datos;
        }else{
            resultado = datos.getPeso() / (datos.getAltura() * datos.getAltura());
            datos.setResultado(resultado);
            if (resultado < 18.5) {
                datos.setInterpretacion("Debe consultar un Doctor, tu peso es muy bajo.");
            }else if(resultado >= 18.5 && resultado <= 24.9){
                datos.setInterpretacion("Estas entre el peso correcto.");
            }else if(resultado >= 18.5 && resultado <= 24.9){
                datos.setInterpretacion("Debes bajar un poco de peso.");
            }else{
                datos.setInterpretacion("Debe consultar un Doctor, tu peso es muy alto.");
            }
            return datos;
        }
    }

}
