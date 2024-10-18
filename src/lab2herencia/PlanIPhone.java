/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_2herencia;

/**
 *
 * @author Laura Sabillon
 */
public class PlanIPhone extends Plan{
    
    private String email;
    
    public PlanIPhone(int numero, String nombre){
        super(numero,nombre);
    }

    public double pagoMensual(int min, int msgs){
        return 20 + (0.4 * min) + (0.1 *msgs);
    }
    
    public String Imprimir(){
        return super.Imprimir() + "\nEmail ITunes: " + email;
    }
}
