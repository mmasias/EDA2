import java.util.Scanner;

public class FloodFill {

    static void fill(int[][] imagen, int fila, int columna, int colorOriginal, int colorNuevo) {
        if (fila < 0 || fila >= imagen.length || columna < 0 || columna >= imagen[0].length) {
            return;
        }
        if (imagen[fila][columna] != colorOriginal) {
            return;
        }

        imagen[fila][columna] = colorNuevo;

        fill(imagen, fila + 1, columna, colorOriginal, colorNuevo);
        fill(imagen, fila - 1, columna, colorOriginal, colorNuevo);
        fill(imagen, fila, columna + 1, colorOriginal, colorNuevo);
        fill(imagen, fila, columna - 1, colorOriginal, colorNuevo);
    }

    static void fillConVisualizacion(int[][] imagen, int fila, int columna, int colorOriginal, int colorNuevo) {
        final String PINTANDO = ">>>";

        if (fila < 0 || fila >= imagen.length || columna < 0 || columna >= imagen[0].length) {
            return;
        }
        if (imagen[fila][columna] != colorOriginal) {
            return;
        }

        System.out.println(PINTANDO + " Pintando (" + columna + ", " + fila + ")");
        imagen[fila][columna] = colorNuevo;
        mostrar(imagen);
        pausar();

        fillConVisualizacion(imagen, fila + 1, columna, colorOriginal, colorNuevo);
        fillConVisualizacion(imagen, fila - 1, columna, colorOriginal, colorNuevo);
        fillConVisualizacion(imagen, fila, columna + 1, colorOriginal, colorNuevo);
        fillConVisualizacion(imagen, fila, columna - 1, colorOriginal, colorNuevo);
    }

    static void mostrar(int[][] imagen) {
        System.out.println("=".repeat(imagen[0].length * 4));
        for (int[] fila : imagen) {
            for (int celda : fila) {
                System.out.print(" " + celda + "  ");
            }
            System.out.println();
        }
        System.out.println("=".repeat(imagen[0].length * 4));
        System.out.println();
    }

    static void pausar() {
        System.out.println("Pulse una tecla para continuar");
        new Scanner(System.in).nextLine();
    }

    static int[][] copiar(int[][] original) {
        int[][] copia = new int[original.length][original[0].length];
        for (int fila = 0; fila < original.length; fila = fila + 1) {
            for (int columna = 0; columna < original[0].length; columna = columna + 1) {
                copia[fila][columna] = original[fila][columna];
            }
        }
        return copia;
    }

    public static void main(String[] args) {
        final int[][] mapa1 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 }
        };

        final int[][] mapa2 = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        final int[][] mapa3 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 2, 2, 2, 0, 3, 3, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 2, 2, 2, 0, 3, 3, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 2, 2, 2, 0, 3, 3, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 4, 4, 4, 4, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0 },
                { 0, 4, 4, 4, 4, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0 },
                { 0, 4, 4, 4, 4, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        boolean continuar = true;
        do {
            System.out.println("1: Mapa 1 (dos zonas 1 desconectadas)");
            System.out.println("2: Mapa 2 (borde con agujero)");
            System.out.println("3: Mapa 3 (múltiples zonas)");
            System.out.print("¿Qué mapa usar?: ");
            int[][] mapa = null;
            int opcionMapa = new Scanner(System.in).nextInt();
            if (opcionMapa == 1) {
                mapa = copiar(mapa1);
            } else if (opcionMapa == 2) {
                mapa = copiar(mapa2);
            } else {
                mapa = copiar(mapa3);
            }

            System.out.println("Imagen original:");
            mostrar(mapa);

            System.out.print("Columna inicial (0-" + (mapa[0].length - 1) + "): ");
            int columnaInicial = new Scanner(System.in).nextInt();
            System.out.print("Fila inicial (0-" + (mapa.length - 1) + "): ");
            int filaInicial = new Scanner(System.in).nextInt();

            int colorOriginal = mapa[filaInicial][columnaInicial];
            System.out.println("Color original: " + colorOriginal);

            System.out.print("Color nuevo: ");
            int colorNuevo = new Scanner(System.in).nextInt();

            System.out.print("¿Qué mostrar?: 1: Resultado / 2: Paso a paso / 3: Salir ");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    fill(mapa, filaInicial, columnaInicial, colorOriginal, colorNuevo);
                    System.out.println("Imagen final:");
                    mostrar(mapa);
                }
                case 2 -> {
                    fillConVisualizacion(mapa, filaInicial, columnaInicial, colorOriginal, colorNuevo);
                    System.out.println("Imagen final:");
                    mostrar(mapa);
                }
                case 3 -> continuar = false;
            }
        } while (continuar);
    }
}
