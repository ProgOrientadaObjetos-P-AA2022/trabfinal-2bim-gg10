/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.util.ArrayList;
import paquete01.PlanCelular;

/**
 *
 * @author Usuario
 */
public class TipoPlanCelular {

    ArrayList<PlanCelular> listadoPlanCelular = new ArrayList<>();
    private double pagoMensualTotal;

    public void establecerListaPlanCelular(ArrayList<PlanCelular> c) {
        listadoPlanCelular = c;
    }

    public void calcularPagoMensualTotal() {
        double suma = 0;
        for (int i = 0; i < obtenerLista().size(); i++) {
            suma = suma + obtenerLista().get(i).obtenerPagoMensual();
        }
        pagoMensualTotal = suma;
    }

    public ArrayList<PlanCelular> obtenerLista() {
        return listadoPlanCelular;
    }
    
    public double obtenerPagoMensualTotal(){
        return pagoMensualTotal;
    }
    @Override
    public String toString(){
        String cadena = "";
        for(int i = 0; i < obtenerLista().size(); i++){
            cadena = String.format("%s%s\n", cadena, obtenerLista().get(i));
        }
        cadena = String.format("%sPago Mensual Total: %.2f\n", cadena, 
                obtenerPagoMensualTotal());
        return cadena;
    }

}
