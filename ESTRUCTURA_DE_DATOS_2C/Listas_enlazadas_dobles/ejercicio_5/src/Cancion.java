public class Cancion {

    String titulo;
    String artista;
    int duracion;
    Cancion siguiente;
    Cancion anterior;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.siguiente = null;
        this.anterior = null;
    }
}