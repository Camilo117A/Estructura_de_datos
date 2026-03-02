//Ejercicio 8 — Historial de mensajes
//Un chat guarda el último mensaje enviado. Se usan dos variables String:

//ultimoMensaje = "Hola"
//copiaTexto = ultimoMensaje
//Luego copiaTexto se cambia a "¿Cómo estás?"
//Muestra ambas variables y explica en un comentario por qué ultimoMensaje no cambió (inmutabilidad de String).



public class Historia_de_mensajes {
    public static void main(String[] args) {

        String ultimo_Mensaje = "Hola";
        String copia_Texto = ultimo_Mensaje;

        copia_Texto = "¿Cómo estás?";

        System.out.println("Ultimo mensaje: " + ultimo_Mensaje);
        System.out.println("Copia texto: " + copia_Texto);
    }
}
