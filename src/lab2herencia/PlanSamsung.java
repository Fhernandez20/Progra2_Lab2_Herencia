/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_2herencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura Sabillon
 */
public class PlanSamsung extends Plan{
    private String pin;
    private ArrayList <String> bbm;
    
    public PlanSamsung(int numero, String nombre, String pin){
        super(numero,nombre);
        this.pin = pin;
        bbm = new ArrayList<>();
    }

    public String getPin() {
        return pin;
    }
    
    public double pagoMensual(int min, int msgs){
        double pago = 0;
        if (min > 300){
            pago = 40 + ((min - 300)*0.8);
        }else if (msgs > 200){
            pago = 40 + ((msgs - 200)*0.2);
        }else if (min < 300 && msgs < 200){
            pago = 40;
        }else if (min > 300 && msgs > 200){
            pago = 40 + ((min-300)*0.8) + ((msgs - 200)*0.2);
        }
        return pago;
    }
    
    public String Imprimir(){
        return super.Imprimir() + "Pin: " + pin;
    }
    
    public void AgregarPin(String pin){
        for (String in : bbm){
            if ( in != pin){
                bbm.add(pin);
            }
            else{
                JOptionPane.showMessageDialog(null , "Este pin ya existe.");
            }
        }
    }
}
