/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete01;

import java.util.Locale;
import java.util.Scanner;
import paquete02.PlanPostPagoMegas;
import paquete02.PlanPostPagoMinutos;
import paquete02.PlanPostPagoMinutosMegas;
import paquete02.PlanPostPagoMinutosMegasEconomico;
import java.sql.SQLException;
import java.util.ArrayList;
import paquete03.Enlace;
import paquete03.TipoPlanCelular;

/**
 *
 * @author Usuario
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

        Enlace c = new Enlace();
        boolean bandera = true;
        ArrayList<PlanCelular> listaPlanCelulares = new ArrayList<>();

        while (bandera) {
            System.out.println("PLAN CELULAR");
            System.out.println("Ingrese (1) para plan PostPago en megas\n"
                    + "Ingrese (2) para plan PostPago en minutos\n"
                    + "Ingrese (3) para plan PostPago en minutos y megas\n"
                    + "Ingrese (4) para plan PostPago en minutos y "
                    + "megas económico\n");
            int numero = entrada.nextInt();

            if (numero >= 1 && numero <= 4) {
                System.out.println("Ingrese el nombre del propietario");
                entrada.nextLine();
                String nombrePropietario = entrada.nextLine();
                System.out.println("Ingrese la cedula del propietario");
                String cedulaPropietario = entrada.nextLine();
                System.out.println("Ingrese la ciudad");
                String ciudad = entrada.nextLine();
                System.out.println("Ingrese marca del celular");
                String marca = entrada.nextLine();
                System.out.println("Ingrese modelo del celular");
                String modelo = entrada.nextLine();
                System.out.println("Ingrese numero del celular");
                String numeroCelular = entrada.nextLine();

                if (numero == 1) {
                    System.out.println("PLAN POSTPAGO EN MEGAS");

                    System.out.println("Ingrese las megas");
                    double megas = entrada.nextDouble();
                    System.out.println("Ingrese costo por cada giga");
                    double costoGiga = entrada.nextDouble();
                    System.out.println("Ingrese la tarifa base");
                    double tarifaBase = entrada.nextDouble();

                    PlanPostPagoMegas plan1 = new PlanPostPagoMegas(nombrePropietario,
                            cedulaPropietario, ciudad, marca, modelo, numeroCelular,
                            megas, costoGiga, tarifaBase);

                    c.insertarPostPagoMegas(plan1);
                    plan1.calcularPagoMensual();
                    listaPlanCelulares.add(plan1);

                    for (int i = 0; i < c.obtenerDataPostPagoMegas().size(); i++) {
                        System.out.printf("%s\n", c.obtenerDataPostPagoMegas().get(i));
                    }

                } else {
                    if (numero == 2) {
                        System.out.println("PLAN POSTPAGO EN MINUTOS");

                        System.out.println("Ingrese los minutos nacionales");
                        int minutosNacionales = entrada.nextInt();
                        System.out.println("Ingrese el costo de cada minuto nacional");
                        double costoMinutoNacional = entrada.nextDouble();
                        System.out.println("Ingrese los minutos internacionales");
                        int minutosInternacionales = entrada.nextInt();
                        System.out.println("Ingrese el costo de cada minuto internacional");
                        double costoMinutoInternacional = entrada.nextDouble();

                        PlanPostPagoMinutos plan2 = new PlanPostPagoMinutos(
                                nombrePropietario, cedulaPropietario, ciudad, marca,
                                modelo, numeroCelular, minutosNacionales,
                                costoMinutoNacional, minutosInternacionales,
                                costoMinutoInternacional);

                        c.insertarPostPagoMinutos(plan2);
                        plan2.calcularPagoMensual();
                        listaPlanCelulares.add(plan2);

                        for (int i = 0; i < c.obtenerDataPostPagoMinutos().size(); i++) {
                            System.out.printf("%s\n", c.obtenerDataPostPagoMinutos().get(i));
                        }

                    } else {
                        if (numero == 3) {
                            System.out.println("PLAN POSTPAGO MINUTOS Y MEGAS");

                            System.out.println("Ingrese los minutos");
                            int minutos = entrada.nextInt();
                            System.out.println("Ingrese el costo por cada minuto");
                            double costoMinuto = entrada.nextDouble();
                            System.out.println("Ingrese las megas");
                            double megas2 = entrada.nextDouble();
                            System.out.println("Ingrese el costo por cada giga");
                            double costoGiga2 = entrada.nextDouble();

                            PlanPostPagoMinutosMegas plan3 = new PlanPostPagoMinutosMegas(
                                    nombrePropietario, cedulaPropietario, ciudad,
                                    marca, modelo, numeroCelular, minutos, costoMinuto,
                                    megas2, costoGiga2);

                            c.insertarPostPagoMinutosMegas(plan3);
                            plan3.calcularPagoMensual();
                            listaPlanCelulares.add(plan3);

                            for (int i = 0; i < c.obtenerDataPostPagoMinutosMegas().size(); i++) {
                                System.out.printf("%s\n", c.obtenerDataPostPagoMinutosMegas().get(i));
                            }

                        } else {
                            if (numero == 4) {
                                System.out.println("PLAN POSTPAGO MINUTOS Y MEGAS "
                                        + "ECONOMICO");

                                System.out.println("Ingrese los minutos");
                                int minutos2 = entrada.nextInt();
                                System.out.println("Ingrese costo por cada minuto");
                                double costoMinuto2 = entrada.nextDouble();
                                System.out.println("Ingrese las megas");
                                double megas3 = entrada.nextDouble();
                                System.out.println("Ingrese el costo por cada giga");
                                double costoGiga3 = entrada.nextDouble();
                                int porcentajeDescuento = 10;

                                PlanPostPagoMinutosMegasEconomico plan4 = new PlanPostPagoMinutosMegasEconomico(
                                        nombrePropietario, cedulaPropietario, ciudad,
                                        marca, modelo, numeroCelular, minutos2,
                                        costoMinuto2, megas3, costoGiga3,
                                        porcentajeDescuento);

                                c.insertarPostPagoMinutosMegasEc(plan4);
                                plan4.calcularPagoMensual();
                                listaPlanCelulares.add(plan4);

                                for (int i = 0; i < c.obtenerDataPostPagoMinutosMegasEc().size(); i++) {
                                    System.out.printf("%s\n", c.obtenerDataPostPagoMinutosMegasEc().get(i));
                                }
                            }
                        }
                    }
                }
                System.out.println("Ingrese x si quiere salir del ciclo");
                entrada.nextLine();
                String letra = entrada.nextLine();
                if (letra.equals("x")) {
                    bandera = false;
                }
            } else {
                System.out.println("FUERA DE RANGO");
            }
            System.out.printf("PLAN CELULARES\n");
            TipoPlanCelular tipo = new TipoPlanCelular();
            tipo.establecerListaPlanCelular(listaPlanCelulares);
            tipo.calcularPagoMensualTotal();
            System.out.printf("%s\n", tipo);
        }

    }
}
