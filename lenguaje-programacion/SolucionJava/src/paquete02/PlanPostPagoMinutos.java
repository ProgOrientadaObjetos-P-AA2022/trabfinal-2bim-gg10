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
public class PlanPostPagoMinutos extends PlanCelular {

    private int minutosNacionales;
    private double costoMinutoNacional;
    private int minutosInternacionales;
    private double costoMinutoInternacional;

    public PlanPostPagoMinutos(String a, String b, String c, String d, String e,
            String f, int g, double h, int j, double k) {
        super(a, b, c, d, e, f);
        minutosNacionales = g;
        costoMinutoNacional = h;
        minutosInternacionales = j;
        costoMinutoInternacional = k;
    }

    public void establecerMinutosNacionales(int c) {
        minutosNacionales = c;
    }

    public void costoMinutoNacional(double c) {
        costoMinutoNacional = c;
    }

    public void establecerMinutosInternacionales(int c) {
        minutosInternacionales = c;
    }

    public void costoMinutoInternacional(double c) {
        costoMinutoInternacional = c;
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = (minutosNacionales * costoMinutoNacional)
                + (minutosInternacionales * costoMinutoInternacional);
    }

    public int obtenerMinutosNacionales() {
        return minutosNacionales;
    }

    public double obtenerCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public int obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public double obtenerCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    @Override
    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("\nPLAN POSTPAGO EN MINUTOS\n\n");
        cadena = String.format("%s%s\n", cadena, super.toString());
        cadena = String.format("%sMinutos nacionales: %d\n"
                + "Costo por cada minuto nacional: %.2f\n"
                + "Minutos internacionales: %d\n"
                + "Costo por cada minuto internacional: %.2f\n"
                + "Pago Mensual: %.2f\n", cadena,
                obtenerMinutosNacionales(),
                obtenerCostoMinutoNacional(),
                obtenerMinutosInternacionales(),
                obtenerCostoMinutoInternacional(),
                obtenerPagoMensual());
        return cadena;
    }
}
