public class Carrusel {

    Anuncio cabeza;
    Anuncio cola;

    public Carrusel() {
        cabeza = null;
        cola = null;
    }

    public void agregar_anuncio(String titulo, int duracion_segundos, String categoria) {
        Anuncio nuevo = new Anuncio(titulo, duracion_segundos, categoria);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
        System.out.println("Anuncio agregado: " + titulo);
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios en el carrusel.");
            return;
        }

        int tiempo_total = 0;

        System.out.println("====== Iniciando reproduccion (" + ciclos + " ciclos) ======");

        for (int i = 1; i <= ciclos; i++) {
            System.out.println("\n-- Ciclo " + i + " --");
            Anuncio temp = cabeza;
            do {
                temp.veces_repetido++;
                tiempo_total += temp.duracion_segundos;
                System.out.println("  En pantalla: \"" + temp.titulo + "\""
                        + " | Categoria: " + temp.categoria
                        + " | Duracion: " + temp.duracion_segundos + "s"
                        + " | Repeticiones: " + temp.veces_repetido);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }

        Anuncio mas_repetido = cabeza;
        Anuncio temp = cabeza.siguiente;
        do {
            if (temp.veces_repetido > mas_repetido.veces_repetido) {
                mas_repetido = temp;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("\n====== Resumen Final ======");
        System.out.println("  Anuncio mas repetido : " + mas_repetido.titulo + " (" + mas_repetido.veces_repetido + " veces)");
        System.out.println("  Tiempo total en pantalla: " + tiempo_total + " segundos (" + (tiempo_total / 60) + " min " + (tiempo_total % 60) + " seg)");
        System.out.println("===========================");
    }

    public void mostrar_anuncios() {
        if (cabeza == null) {
            System.out.println("No hay anuncios registrados.");
            return;
        }
        Anuncio temp = cabeza;
        System.out.println("====== Anuncios en carrusel ======");
        do {
            System.out.println("  \"" + temp.titulo + "\""
                    + " | " + temp.categoria
                    + " | " + temp.duracion_segundos + "s"
                    + " | Repetido: " + temp.veces_repetido + " veces");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("==================================");
    }
}