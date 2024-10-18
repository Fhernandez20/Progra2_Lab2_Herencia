/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_2herencia;

/**
 *
 * @author Laura Sabillon
 */
public abstract class Plan {
    private int numero;
    private String nombre;
    
    public Plan(int numero , String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
    
    public abstract double pagoMensual(int min, int msgs);
    
    public String Imprimir(){
        return "Numero: " + numero +"\nNombre: " + nombre;
    }
}
