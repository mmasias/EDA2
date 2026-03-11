import java.util.Scanner;

public class NReinas {

    static boolean puedeColocar(int[][] tablero, int fila, int columna) {
        // horizontal izquierda
        for (int c = 0; c < columna; c++) {
            if (tablero[fila][c] == 1) {
                return false;
            }
        }
        // diagonal arriba-izquierda
        int columnaDiagonal = columna;
        for (int f = fila; f >= 0 && columnaDiagonal >= 0; f--) {
            if (tablero[f][columnaDiagonal] == 1) {
                return false;
            }
            columnaDiagonal--;
        }
        // diagonal abajo-izquierda
        columnaDiagonal = columna;
        for (int f = fila; f < tablero.length && columnaDiagonal >= 0; f++) {
            if (tablero[f][columnaDiagonal] == 1) {
                return false;
            }
            columnaDiagonal--;
        }
        return true;
    }

    static boolean unaSolucion(int[][] tablero, int columna) {
        if (columna == tablero.length) {
            return true;
        }
        for (int fila = 0; fila < tablero.length; fila = fila + 1) {
            if (puedeColocar(tablero, fila, columna)) {
                tablero[fila][columna] = 1;     // HACER
                if (unaSolucion(tablero, columna + 1)) {
                    return true;                // propagar éxito
                }
                tablero[fila][columna] = 0;     // DESHACER
            }
        }
        return false;
    }

    static void todasLasSoluciones(int[][] tablero, int columna) {
        if (columna == tablero.length) {
            mostrar(tablero);
            return;
        }
        for (int fila = 0; fila < tablero.length; fila = fila + 1) {
            if (puedeColocar(tablero, fila, columna)) {
                tablero[fila][columna] = 1; // HACER
                todasLasSoluciones(tablero, columna + 1);
                tablero[fila][columna] = 0; // DESHACER
            }
        }
    }

    static boolean unaSolucionConVisualizacion(int[][] tablero, int columna) {
        final String EXITO     = "-->";
        final String FALLO     = " x ";
        final String RETROCESO = "<--";
        if (columna == tablero.length) {
            return true;
        }
        for (int fila = 0; fila < tablero.length; fila = fila + 1) {
            if (puedeColocar(tablero, fila, columna)) {
                System.out.println(EXITO + " Reina " + (columna + 1) + " en fila " + (fila + 1) + ": puede");
                tablero[fila][columna] = 1;
                mostrar(tablero);
                pausar();

                if (unaSolucionConVisualizacion(tablero, columna + 1)) {
                    return true;                                     // propagar éxito
                }
                tablero[fila][columna] = 0;
                System.out.println(RETROCESO + " Reina " + (columna + 1) + " retirada de fila " + (fila + 1));
                mostrar(tablero);
                pausar();
                
            } else {
                System.out.println(FALLO + " Reina " + (columna + 1) + " en fila " + (fila + 1) + ": no puede");
            }
        }
        System.out.println("    Reina " + (columna + 1) + " sin posición. Retrocedo a reina " + columna + ".");
        return false;
    }

    static void pausar() {
        System.out.println("Pulse una tecla para continuar");
        new Scanner(System.in).nextLine();
    }

    static void mostrar(int[][] tablero) {
        System.out.println("-".repeat(tablero.length * 3));
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print(celda == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
        System.out.println("-".repeat(tablero.length * 3));
        System.out.println();
    }

    public static void main(String[] args) {
        boolean continuar = true;
        do {
            System.out.print("¿Cuántas reinas?: ");
            int numeroReinas = new Scanner(System.in).nextInt();

            System.out.print("¿Qué mostrar?: 1: Una solución / 2: Todas / 3: Una con visualización / 4: Salir ");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    System.out.println("Una solución (" + numeroReinas + " reinas):");
                    int[][] tablero = new int[numeroReinas][numeroReinas];
                    if (unaSolucion(tablero, 0)) {
                        mostrar(tablero);
                    }
                }
                case 2 -> {
                    System.out.println("Todas las soluciones (" + numeroReinas + " reinas):");
                    int[][] tablero2 = new int[numeroReinas][numeroReinas];
                    todasLasSoluciones(tablero2, 0);
                }
                case 3 -> {
                    System.out.println("Una solución con visualización (" + numeroReinas + " reinas):");
                    int[][] tablero3 = new int[numeroReinas][numeroReinas];
                    unaSolucionConVisualizacion(tablero3, 0);
                }
                case 4 -> continuar = false;
            }
        } while (continuar);
    }
}
