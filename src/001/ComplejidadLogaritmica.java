class ComplejidadLogaritmica {

    public static void main(String[] args) {

        String[] diccionario = {"casa", "mesa", "pared", "silla", "ventana"};

        String palabra = "pared";
        int posicion = busquedaBinaria(diccionario, palabra);

        System.out.println("Palabra '" + palabra + "' encontrada en: " + posicion);

        System.out.println("Adivinar número (1-100):");
        System.out.println("Intentos necesarios (máximo 7): " + adivinarNumero(73));
    }

    static int busquedaBinaria(String[] diccionario, String palabra) {
        int inicio = 0;
        int fin = diccionario.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = diccionario[medio].compareTo(palabra);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    static int adivinarNumero(int objetivo) {
        int bajo = 1;
        int alto = 100;
        int intentos = 0;

        while (bajo <= alto) {
            intentos++;
            int medio = bajo + (alto - bajo) / 2;

            if (medio == objetivo) {
                return intentos;
            } else if (medio < objetivo) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return intentos;
    }
}
