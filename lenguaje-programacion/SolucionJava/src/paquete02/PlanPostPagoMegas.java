/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import paquete01.PlanCelular;

/**
 *
 * @author Usuario
 */
public class PlanPostPagoMegas extends PlanCelular {

    private double gigas;
    private double costoGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(String a, String b, String c, String d, String e,
            String f, double g, double i, double j) {
        super(a, b, c, d, e, f);
        gigas = g;
        costoGiga = i;
        tarifaBase = j;
    }

    public void expresarGigas(double c) {
        gigas = c / 1024;
    }

    public void establecerCostoGiga(double c) {
        costoGiga = c;
    }

    public void establecerTarifaBase(double c) {
        tarifaBase = c;
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = (gigas * costoGiga) + tarifaBase;
    }

    public double obtenerGigasExpresadas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("\nPLAN POSTPAGO EN MEGAS\n\n");
        cadena = String.format("%s%s\n", cadena, super.toString());
        cadena = String.format("%sMegas expresado en gigas: %.2f\n"
                + "Costo por cada giga: %.2f\n"
                + "Tarifa: %.2f\n"
                + "Pago Mensual: %.2f\n", cadena,
                obtenerGigasExpresadas(),
                obtenerCostoGiga(),
                obtenerTarifaBase(),
                obtenerPagoMensual());
        return cadena;
    }
}
