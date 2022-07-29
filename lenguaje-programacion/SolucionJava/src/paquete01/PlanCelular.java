/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author Usuario
 */
public abstract class PlanCelular {

    protected String nombrePropietario;
    protected String cedulaPropietario;
    protected String ciudadPropietario;
    protected String marcaCelular;
    protected String modeloCelular;
    protected String numeroCelular;
    protected double pagoMensual;

    public PlanCelular(String a, String b, String c, String d, String e,
            String f) {
        nombrePropietario = a;
        cedulaPropietario = b;
        ciudadPropietario = c;
        marcaCelular = d;
        modeloCelular = e;
        numeroCelular = f;
    }

    public void establecerNombrePropietario(String c) {
        nombrePropietario = c;
    }

    public void establecerCedulaPropietario(String c) {
        cedulaPropietario = c;
    }

    public void establecerCiudadPropietario(String c) {
        ciudadPropietario = c;
    }

    public void establecerMarcaCelular(String c) {
        marcaCelular = c;
    }

    public void establecerModeloCelular(String c) {
        modeloCelular = c;
    }

    public void establecerNumeroCelular(String c) {
        numeroCelular = c;
    }

    public abstract void calcularPagoMensual();

    public String obtenerNombrePropietario() {
        return nombrePropietario;
    }

    public String obtenerCedulaPropietario() {
        return cedulaPropietario;
    }

    public String obtenerCiudadPropietario() {
        return ciudadPropietario;
    }

    public String obtenerMarcaCelular() {
        return marcaCelular;
    }

    public String obtenerModeloCelular() {
        return modeloCelular;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String cadena = String.format("Nombre del propietario: %s\n"
                + "Cedula del propietario: %s\n"
                + "Ciudad: %s\n"
                + "Marca del celular: %s\n"
                + "Modelo Celular: %s\n"
                + "Número de celular: %s\n", 
                obtenerNombrePropietario(),
                obtenerCedulaPropietario(),
                obtenerCiudadPropietario(),
                obtenerMarcaCelular(),
                obtenerModeloCelular(),
                obtenerNumeroCelular());
        return cadena;
    }
}
