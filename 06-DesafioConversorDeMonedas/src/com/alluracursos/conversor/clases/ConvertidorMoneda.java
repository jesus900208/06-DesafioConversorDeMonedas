package com.alluracursos.conversor.clases;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConvertidorMoneda {
    private SolicitudAPI solicitudAPI;
    private Gson gson = new Gson();

    public ConvertidorMoneda(SolicitudAPI solicitudAPI) {
        this.solicitudAPI = solicitudAPI;
    }

    public void convertirYGuardar(String origen, String destino, double cantidad) {
        try {
            JsonObject datos = solicitudAPI.solicitarDatos(origen, destino);
            double tasa = datos.get("conversion_rate").getAsDouble();
            double resultado = cantidad * tasa;

            // Crear JSON de salida
            JsonObject salida = new JsonObject();
            salida.addProperty("origen", origen);
            salida.addProperty("destino", destino);
            salida.addProperty("cantidad", cantidad);
            salida.addProperty("tasa", tasa);
            salida.addProperty("resultado", resultado);

            // Guardar en archivo
            try (FileWriter escritor = new FileWriter("conversion_resultado.json")) {
                escritor.write(gson.toJson(salida));
            }

            System.out.printf("%.2f %s = %.2f %s (resultado guardado en conversion_resultado.json)%n",
                    cantidad, origen, resultado, destino);
        } catch (Exception e) {
            System.out.println("Error al convertir o guardar: " + e.getMessage());
        }
    }
}
