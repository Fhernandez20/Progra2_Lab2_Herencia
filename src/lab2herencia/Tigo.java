/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fdhg0
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

            if (plan.getNumero() == numeroTel) {
                return true;
            }

            if (tipo.equalsIgnoreCase("iphone") && plan instanceof PlanIPhone) {
                if (((PlanIPhone) plan).getEmail().equals(datoExtra)) {
                    return true;
                }
            }

            if (tipo.equalsIgnoreCase("SAMSUNG") && plan instanceof PlanSamsung) {
                if (((PlanSamsung) plan).getPin().equals(datoExtra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double pagoPlan(int numeroTel, int mins, int msgs) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            if (plan.getNumero() == numeroTel) {
                double pago = plan.pagoMensual(mins, msgs); 
                
                return pago; 
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el plan para el número: " + numeroTel, "Error", JOptionPane.ERROR_MESSAGE);
        return -1; 
    }

    public void agregarAmigo(int numeroTel, String pin) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            if (plan instanceof PlanSamsung && plan.getNumero() == numeroTel) {
                ((PlanSamsung) plan).AgregarPin(pin);
                return;
            }
        }

    }

    public String lista() {

        String resultado = "";

        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            resultado += "Número de Cliente: " + plan.getNumero() + "\n";
            resultado += "Nombre: " + plan.getNombre() + "\n";

            if (plan instanceof PlanIPhone) {
                resultado += "Email: " + ((PlanIPhone) plan).getEmail() + "\n";
                resultado += "Tipo: IPHONE\n";
            } else if (plan instanceof PlanSamsung) {
                resultado += "PIN: " + ((PlanSamsung) plan).getPin() + "\n";
                resultado += "Tipo: SAMSUNG\n";
            }

            resultado += "\n";
        }

        return resultado;
    }

}
