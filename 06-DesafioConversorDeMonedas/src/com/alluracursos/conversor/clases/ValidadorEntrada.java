package com.alluracursos.conversor.clases;


import java.util.Scanner;

public class ValidadorEntrada {
    public void validarOpcion(String opcion) {
        if (!opcion.matches("[1-9]")) {
            throw new IllegalArgumentException("Debe ingresar un número entre 1 y 9 o 'salir'.");
        }
    }

    public double leerCantidad(Scanner entrada) {
        System.out.print("Ingrese la cantidad a convertir: ");
        String texto = entrada.nextLine();
        if (!texto.matches("\\d+(\\.\\d+)?")) {
            throw new NumberFormatException();
        }
        return Double.parseDouble(texto);
    }
}
