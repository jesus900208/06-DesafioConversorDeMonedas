Conversor de Monedas - Java
Este es un proyecto de consola desarrollado en Java que permite convertir entre distintas monedas usando una API de tipo de cambio en tiempo real. También guarda los resultados en un archivo JSON.

# Características
Conversión entre:

Dólar ↔ Peso argentino

Dólar ↔ Real brasileño

Dólar ↔ Peso colombiano

Dólar ↔ Peso mexicano

Validación de entradas numéricas

Consulta de tasas de cambio en tiempo real usando una API externa

Almacenamiento de resultados en archivo conversion_resultado.json


# Ejemplo de ejecución:
Seleccione una opción:
1.- Dólar a Peso argentino
2.- Peso argentino a Dólar
...
Ingrese la cantidad a convertir: 100
100.0 USD = 23000.0 ARS (resultado guardado en conversion_resultado.json)

# Descripción de Clases
Principal.java
Clase principal que inicia el programa e interactúa con el usuario.

Permite elegir opciones y coordina la conversión.

ConvertidorMoneda.java
Realiza la conversión usando tasas obtenidas de la API.

Guarda resultados en un archivo JSON.

ValidadorEntrada.java
Valida que las opciones del usuario y las cantidades ingresadas sean correctas.

SolicitudAPI.java
Realiza la consulta HTTP a la API externa para obtener la tasa de cambio.

🔧 Requisitos
Java 11 o superior

Biblioteca GSON para parsear JSON

Conexión a Internet (para consultar la API)
