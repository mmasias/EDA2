class ComplejidadLineal {
    static final int NO_ENCONTRADO = -1;

    public static void main(String[] args) {
        int[] libro = new int[100];
        for (int i = 0; i < libro.length; i++) {
            libro[i] = i + 1;
        }

        System.out.println("Lectura lineal: O(n)");
        System.out.println("Total de páginas: " + contarPaginas(libro));

        System.out.println("Búsqueda de número 50:");
        System.out.println("Posición: " + buscarElemento(libro, 50));

        System.out.println("Personas en fila:");
        System.out.println("Total: " + contarFila(new int[]{1, 2, 3, 4, 5}));
    }

    static int contarPaginas(int[] libro) {
        int total = 0;
        for (int i = 0; i < libro.length; i++) {
            total += libro[i];
        }
        return total;
    }

    static int buscarElemento(int[] lista, int objetivo) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == objetivo) {
                return i;
            }
        }
        return NO_ENCONTRADO;
    }

    static int contarFila(int[] personas) {
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            contador++;
        }
        return contador;
    }
}
