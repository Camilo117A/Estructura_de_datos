public class ArbolBST {
    private Libro raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    public boolean insertar(long isbn, String titulo, String autor, int anio) {
        if (existeISBN(isbn)) {
            return false;
        }
        raiz = insertarRec(raiz, isbn, titulo, autor, anio);
        return true;
    }

    private Libro insertarRec(Libro nodo, long isbn, String titulo, String autor, int anio) {
        if (nodo == null) {
            return new Libro(isbn, titulo, autor, anio);
        }
        if (isbn < nodo.isbn) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, isbn, titulo, autor, anio);
        } else if (isbn > nodo.isbn) {
            nodo.derecho = insertarRec(nodo.derecho, isbn, titulo, autor, anio);
        }
        return nodo;
    }

    public boolean existeISBN(long isbn) {
        return existeISBNRec(raiz, isbn);
    }

    private boolean existeISBNRec(Libro nodo, long isbn) {
        if (nodo == null) {
            return false;
        }
        if (isbn == nodo.isbn) {
            return true;
        }
        if (isbn < nodo.isbn) {
            return existeISBNRec(nodo.izquierdo, isbn);
        }
        return existeISBNRec(nodo.derecho, isbn);
    }

    public void imprimirCatalogo() {
        imprimirCatalogoRec(raiz);
    }

    private void imprimirCatalogoRec(Libro nodo) {
        if (nodo == null) {
            return;
        }
        imprimirCatalogoRec(nodo.izquierdo);
        System.out.printf("  ISBN: %-15d | Titulo: %-35s | Autor: %-25s | Anio: %d%n",
                nodo.isbn, nodo.titulo, nodo.autor, nodo.anioPublicacion);
        imprimirCatalogoRec(nodo.derecho);
    }
}
