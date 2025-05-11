package com.alluracursos.conversor.principal;

import com.alluracursos.conversor.clases.ConvertidorMoneda;
import com.alluracursos.conversor.clases.SolicitudAPI;
import com.alluracursos.conversor.clases.ValidadorEntrada;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SolicitudAPI solicitudAPI = new SolicitudAPI("7ad175b6ab1e06995884baac");
        ConvertidorMoneda convertidor = new ConvertidorMoneda(solicitudAPI);
        ValidadorEntrada validador = new ValidadorEntrada();
        String opcion = "";

        while (true) {
            System.out.println("1.- Dólar a Peso argentino");
            System.out.println("2.- Peso argentino a Dólar");
            System.out.println("3.- Dólar a Real brasileño");
            System.out.println("4.- Real brasileño a Dólar");
            System.out.println("5.- Dólar a Peso colombiano");
            System.out.println("6.- Peso colombiano a Dólar");
            System.out.println("7.- Dólar a Peso mexicano");
            System.out.println("8.- Peso mexicano a Dólar");
            System.out.println("9.- Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextLine();
            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            try {
                validador.validarOpcion(opcion);
                double cantidad = validador.leerCantidad(entrada);
                switch (opcion) {
                    case "1":
                        convertidor.convertirYGuardar("USD", "ARS", cantidad);
                        break;
                    case "2":
                        convertidor.convertirYGuardar("ARS", "USD", cantidad);
                        break;
                    case "3":
                        convertidor.convertirYGuardar("USD", "BRL", cantidad);
                        break;
                    case "4":
                        convertidor.convertirYGuardar("BRL", "USD", cantidad);
                        break;
                    case "5":
                        convertidor.convertirYGuardar("USD", "COP", cantidad);
                        break;
                    case "6":
                        convertidor.convertirYGuardar("COP", "USD", cantidad);
                        break;
                    case "7":
                        convertidor.convertirYGuardar("USD", "MXN", cantidad);
                        break;
                    case "8":
                        convertidor.convertirYGuardar("MXN", "USD", cantidad);
                        break;
                    default:
                        System.out.println("Opción no reconocida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: la cantidad debe ser un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        }
        entrada.close();
    }
}
