public class consola {
    String texto;
    int hora;
    consola siguiente;
    consola anterior;

    public consola(String texto, int hora) {
        this.texto = texto;
        this.hora = hora;
        this.siguiente = null;
        this.anterior = null;
    }
}
//necesito q me crees 3 archivos de java, comando (nodo), consola (logica) y menu (con scanner), debes de hacer, nueva comando: agregar un comando(texto,hora) el final de la lista circular, comando anterir; mover el cursor hacia atras (simula fecha arriba), comando siguiente; mover el cirsor hacia adelante (simula flecha abajo), borrar actual; eliminar el comando donde esta el cursor y reconectar la lista en O(1), buscar comando; buscar por texto y mover el cursor directamente a esa posicion, 3) validacion circular; al navegar o listar el historial, debe demostrar visualmente q la lista se cierra sobre si misma.
