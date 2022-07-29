/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import paquete02.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            //System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPostPagoMinutos(PlanPostPagoMinutos plan1) {

        try {
            establecerConexion();
            plan1.calcularPagoMensual();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutos "
                    + "(nombrePropietario, cedulaPropietario, ciudadPropietario, "
                    + "marcaCelular, modeloCelular, "
                    + "numeroCelular, minutosNacionales, costoMinutoNacional,"
                    + "minutosInternacionales, costoMinutoInternacional, "
                    + "pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%d', '%.2f', "
                    + "'%d', '%.2f', '%.2f')",
                    plan1.obtenerNombrePropietario(),
                    plan1.obtenerCedulaPropietario(),
                    plan1.obtenerCiudadPropietario(),
                    plan1.obtenerMarcaCelular(),
                    plan1.obtenerModeloCelular(),
                    plan1.obtenerNumeroCelular(),
                    plan1.obtenerMinutosNacionales(),
                    plan1.obtenerCostoMinutoNacional(),
                    plan1.obtenerMinutosInternacionales(),
                    plan1.obtenerCostoMinutoInternacional(),
                    plan1.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPagoMegas");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutos> obtenerDataPostPagoMinutos() {
        ArrayList<PlanPostPagoMinutos> listamin = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos plan = new PlanPostPagoMinutos(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutosNacionales"),
                        rs.getDouble("costoMinutoNacional"),
                        rs.getInt("minutosInternacionales"),
                        rs.getDouble("costoMinutoInternacional"));
                plan.calcularPagoMensual();
                listamin.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutos");
            System.out.println(e.getMessage());

        }
        return listamin;
    }

    public void insertarPostPagoMegas(PlanPostPagoMegas plan2) {

        try {
            establecerConexion();
            plan2.calcularPagoMensual();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMegas "
                    + "(nombrePropietario, cedulaPropietario, ciudadPropietario, "
                    + "marcaCelular, modeloCelular, numeroCelular, gigas, "
                    + "costoGiga, tarifaBase, pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%.2f', '%.2f','%.2f', '%.2f')",
                    plan2.obtenerNombrePropietario(),
                    plan2.obtenerCedulaPropietario(),
                    plan2.obtenerCiudadPropietario(),
                    plan2.obtenerMarcaCelular(),
                    plan2.obtenerModeloCelular(),
                    plan2.obtenerNumeroCelular(),
                    plan2.obtenerGigasExpresadas(),
                    plan2.obtenerCostoGiga(),
                    plan2.obtenerTarifaBase(),
                    plan2.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMegas");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMegas> obtenerDataPostPagoMegas() {
        ArrayList<PlanPostPagoMegas> listameg = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMegas plan = new PlanPostPagoMegas(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("gigas"),
                        rs.getDouble("costoGiga"),
                        rs.getDouble("tarifabase"));
                plan.calcularPagoMensual();
                listameg.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMegas");
            System.out.println(e.getMessage());

        }
        return listameg;
    }

    public void insertarPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan3) {

        try {
            establecerConexion();
            plan3.calcularPagoMensual();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegas "
                    + "(nombrePropietario, cedulaPropietario, ciudadPropietario, "
                    + "marcaCelular, modeloCelular, numeroCelular, minutos, "
                    + "costoMinuto, gigas, costoGiga, pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%d', '%.2f','%.2f', '%.2f', '%.2f')",
                    plan3.obtenerNombrePropietario(),
                    plan3.obtenerCedulaPropietario(),
                    plan3.obtenerCiudadPropietario(),
                    plan3.obtenerMarcaCelular(),
                    plan3.obtenerModeloCelular(),
                    plan3.obtenerNumeroCelular(),
                    plan3.obtenerMinutos(),
                    plan3.obtenerCostoMinuto(),
                    plan3.obtenerGigasExpresadas(),
                    plan3.obtenerCostoGiga(),
                    plan3.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutosMegas> obtenerDataPostPagoMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegas> listaminmeg = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("gigas"),
                        rs.getDouble("costoGiga"));
                plan.calcularPagoMensual();
                listaminmeg.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
        return listaminmeg;

    }

    public void insertarPostPagoMinutosMegasEc(PlanPostPagoMinutosMegasEconomico plan4) {

        try {
            establecerConexion();
            plan4.calcularPagoMensual();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegasEconomico "
                    + "(nombrePropietario, cedulaPropietario, ciudadPropietario, "
                    + "marcaCelular, modeloCelular, numeroCelular, minutos, "
                    + "costoMinuto, gigas, costoGiga, porcentajeDescuento, "
                    + "pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', '%d', '%.2f','%.2f', '%.2f', '%d', '%.2f')",
                    plan4.obtenerNombrePropietario(),
                    plan4.obtenerCedulaPropietario(),
                    plan4.obtenerCiudadPropietario(),
                    plan4.obtenerMarcaCelular(),
                    plan4.obtenerModeloCelular(),
                    plan4.obtenerNumeroCelular(),
                    plan4.obtenerMinutos(),
                    plan4.obtenerCostoMinuto(),
                    plan4.obtenerGigasExpresadas(),
                    plan4.obtenerCostoGiga(),
                    plan4.obtenerPorcentajeDescuento(),
                    plan4.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegasEc");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutosMegasEconomico> obtenerDataPostPagoMinutosMegasEc() {
        ArrayList<PlanPostPagoMinutosMegasEconomico> listaec = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegasEconomico;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico plan = new PlanPostPagoMinutosMegasEconomico(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("gigas"),
                        rs.getDouble("costoGiga"),
                        rs.getInt("porcentajeDescuento"));
                plan.calcularPagoMensual();
                listaec.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanPostPagoMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return listaec;
    }

}
