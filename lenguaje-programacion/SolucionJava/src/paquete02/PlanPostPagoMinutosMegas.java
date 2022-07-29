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
public class PlanPostPagoMinutosMegas extends PlanCelular {

    private int minutos;
    private double costoMinuto;
    private double gigas;
    private double costoGiga;

    public PlanPostPagoMinutosMegas(String a, String b, String c, String d, String e,
            String f, int g, double h, double i, double j) {
        super(a, b, c, d, e, f);
        minutos = g;
        costoMinuto = h;
        gigas = i;
        costoGiga = j;
    }

    public void establecerMinutos(int c) {
        minutos = c;
    }

    public void establecerCostoMinuto(double c) {
        costoMinuto = c;
    }

    public void expresarGigas(double c) {
        gigas = c / 1024;
    }

    public void establecerCostoGiga(double c) {
        costoGiga = c;
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = (minutos * costoMinuto)
                + (gigas * costoGiga);
    }

    public int obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinuto() {
        return costoMinuto;
    }

    public double obtenerGigasExpresadas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    @Override
    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("\nPLAN POSTPAGO EN MINUTOS Y MEGAS\n\n");
        cadena = String.format("%s%s\n", cadena, super.toString());
        cadena = String.format("%sMinutos: %d\n"
                + "Costo por cada minuto: %.2f\n"
                + "Megas expresado en gigas: %.2f\n"
                + "Costo por cada giga: %.2f\n"
                + "Pago Mensual: %.2f\n", cadena,
                obtenerMinutos(),
                obtenerCostoMinuto(),
                obtenerGigasExpresadas(),
                obtenerCostoGiga(),
                obtenerPagoMensual());
        return cadena;
    }
}
