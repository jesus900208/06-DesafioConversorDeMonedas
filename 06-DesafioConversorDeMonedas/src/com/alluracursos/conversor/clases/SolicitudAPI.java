package com.alluracursos.conversor.clases;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SolicitudAPI {
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;

    public SolicitudAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public JsonObject solicitarDatos(String origen, String destino) throws Exception {
        String urlStr = URL_BASE + apiKey + "/pair/" + origen + "/" + destino;
        URL url = new URL(urlStr);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        if (conexion.getResponseCode() != 200) {
            throw new Exception("Respuesta de API no es correcta: " + conexion.getResponseCode());
        }

        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) respuesta.append(linea);
        lector.close();

        return JsonParser.parseString(respuesta.toString()).getAsJsonObject();
    }
}
