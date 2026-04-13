public class Navegador {

    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        cabeza = null;
        cola = null;
    }

    public void abrir_pestana(String titulo_pagina, String url, String hora_apertura) {
        Pestana nueva = new Pestana(titulo_pagina, url, hora_apertura);

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            nueva.anterior = cola;
            cola.siguiente = nueva;
            cola = nueva;
        }
        System.out.println("Pestana abierta: " + titulo_pagina + " [" + url + "]");
    }

    public void cerrar_pestana_actual(String url) {
        if (cabeza == null) {
            System.out.println("No hay pestanas abiertas.");
            return;
        }

        Pestana temp = cabeza;
        while (temp != null && !temp.url.equals(url)) {
            temp = temp.siguiente;
        }

        if (temp == null) {
            System.out.println("No se encontro ninguna pestana con la URL: " + url);
            return;
        }

        System.out.println("Cerrando pestana: " + temp.titulo_pagina + " [" + temp.url + "]");

        if (temp == cabeza && temp == cola) {
            cabeza = null;
            cola = null;
            System.out.println("Era la ultima pestana, el navegador quedo sin pestanas.");
            return;
        }

        if (temp == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            System.out.println("El foco pasa a: " + cabeza.titulo_pagina);
            return;
        }

        if (temp == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
            System.out.println("El foco pasa a: " + cola.titulo_pagina);
            return;
        }

        temp.anterior.siguiente = temp.siguiente;
        temp.siguiente.anterior = temp.anterior;
        System.out.println("El foco pasa a: " + temp.anterior.titulo_pagina);
    }

    public void mostrar_pestanas() {
        if (cabeza == null) {
            System.out.println("No hay pestanas abiertas.");
            return;
        }
        Pestana temp = cabeza;
        int numero = 1;
        System.out.println("====== Pestanas abiertas ======");
        while (temp != null) {
            System.out.println("  " + numero + ". " + temp.titulo_pagina
                    + " | URL: " + temp.url
                    + " | Abierta: " + temp.hora_apertura);
            numero++;
            temp = temp.siguiente;
        }
        System.out.println("================================");
    }
}