/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.util.ArrayList;

/**
 *
 * @author Jorge Aguirre
 */
public class Tigo {

    ArrayList<Plan> planes;

    public Tigo() {
        planes = new ArrayList<>();
    }

    public void agregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        if (tipo.equalsIgnoreCase("iphone")) {
            //planes.add(new PlanIPhone(numeroTel, nombre, extra));
        }
        if (tipo.equalsIgnoreCase("samsung")) {
            //planes.add(new PlanSamsung(numeroTel, nombre, extra));
        }
    }
    
    public boolean búsqueda(int numeroTel, String datoExtra, String tipo) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            
            /*
            if (plan.getNumeroTelefono() == numeroTel) {
                return true;
            }
            
            
            if (tipo.equalsIgnoreCase("iphone") && plan instanceof PlanIPhone) {
                if (((PlanIPhone) plan).getEmailITunes().equals(datoExtra)) {
                    return true;
                }
            }
            if (tipo.equalsIgnoreCase("SAMSUNG") && plan instanceof PlanSamsung) {
                if (((PlanSamsung) plan).getPin().equals(datoExtra)) {
                    return true;
                }
            }*/
        }
        return false;
    }
    
    
    
    public double pagoPlan(int numeroTel, int mins,int msgs){
    
        return 0; //0 temporal
    }
    
    
    public void agregarAmigo(int numeroTel, String pin){
    
        return;      
    }
    
    
    public void lista(){
    
    }
    
    
}