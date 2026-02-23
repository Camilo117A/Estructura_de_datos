package Ejercicios_basicos;

public class SensorTemperatura {
    public static void main(String[] args) {
        // Datos del sensor
        String nombreSensor = "Sensor Industrial A-1";
        int numeroLectura = 452;
        double temperaturaCelsius = 85.5;
        
        // Lógica de alarma: se activa si supera los 80°C
        boolean enAlarma = temperaturaCelsius > 80.0;

        // Reporte de estado
        System.out.println("Reporte de Sensor");
        System.out.println("ID Sensor: " + nombreSensor);
        System.out.println("Lectura No: " + numeroLectura);
        System.out.println("Temperatura: " + temperaturaCelsius + "°C");
        System.out.println("ESTADO DE ALARMA: " + enAlarma);
    }
}
