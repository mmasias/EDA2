import java.util.Scanner;

public class Laberinto {

    static final int LIBRE = 0;
    static final int PARED = 1;
    static final int CAMINO = 2;
    static final int VISITADO = 3;

    static final String[] celda = { " · ", "[ ]", " * ", " x " };

    static boolean resolver(int[][] laberinto, int fila, int columna) {
        if (fila < 0 || fila >= laberinto.length || columna < 0 || columna >= laberinto[0].length) {
            return false;
        }
        if (laberinto[fila][columna] != LIBRE) {
            return false;
        }
        if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
            laberinto[fila][columna] = CAMINO;
            return true;
        }

        laberinto[fila][columna] = CAMINO;

        if (resolver(laberinto, fila - 1, columna) || 
            resolver(laberinto, fila, columna - 1) ||
            resolver(laberinto, fila + 1, columna) || 
            resolver(laberinto, fila, columna + 1)) {
            return true;
        }

        laberinto[fila][columna] = VISITADO;
        return false;
    }

    private static boolean puedePasar(int[][] laberinto, int fila, int columna) {
        return fila >= 0 && 
                fila < laberinto.length && 
                columna >= 0 && 
                columna < laberinto[0].length && 
                laberinto[fila][columna] == LIBRE;
    }

    static boolean resolverConVisualizacion(int[][] laberinto, int fila, int columna) {
        final String EXITO = "-->";
        final String FALLO = " x ";
        final String RETROCESO = "<--";

        if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
            laberinto[fila][columna] = CAMINO;
            System.out.println(EXITO + " (" + columna + ", " + fila + "): salida!");
            mostrar(laberinto);
            return true;
        }

        laberinto[fila][columna] = CAMINO;
        System.out.println(EXITO + " (" + columna + ", " + fila + "): marcada como camino");
        mostrar(laberinto);
        new Scanner(System.in).nextLine();

        int[][] siguientes = { 
                                { fila - 1, columna },
                                { fila, columna - 1 },
                                { fila + 1, columna },
                                { fila, columna + 1 }
                            };
        String[] nombres = { "abajo", "derecha", "arriba", "izquierda" };

        for (int direccion = 0; direccion < 4; direccion = direccion + 1) {
            int nuevaFila = siguientes[direccion][0];
            int nuevaColumna = siguientes[direccion][1];
            if (puedePasar(laberinto, nuevaFila, nuevaColumna)) {
                if (resolverConVisualizacion(laberinto, nuevaFila, nuevaColumna)) {
                    return true;
                }
            } else {
                System.out.println(FALLO + " (" + nuevaColumna + ", " + nuevaFila + "): " + nombres[direccion] + " bloqueado");
            }
        }

        laberinto[fila][columna] = VISITADO;
        System.out.println(RETROCESO + " (" + columna + ", " + fila + "): callejón sin salida");
        mostrar(laberinto);
        new Scanner(System.in).nextLine();
        return false;
    }

    static void mostrar(int[][] laberinto) {
        System.out.println("===".repeat(laberinto[0].length));
        for (int fila = 0; fila < laberinto.length; fila = fila + 1) {
            for (int columna = 0; columna < laberinto[fila].length; columna = columna + 1) {
                System.out.print(celda[laberinto[fila][columna]]);
            }
            System.out.println();
        }
        System.out.println("===".repeat(laberinto[0].length));
    }

    public static void main(String[] args) {
        final int[][] mapa1 = {
                { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 }
        };

        final int[][] mapa2 = {
                { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 }
        };

        boolean continuar = true;
        do {
            System.out.print("¿Qué mapa usar?: 1 / 2");
            int[][] mapa = new Scanner(System.in).nextInt() == 1 ? mapa1 : mapa2;

            System.out.print("X¿Qué mostrar?: 1: Resolver / 2: Resolver con visualización / 3: Salir ");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    int[][] laberinto = copiar(mapa);
                    System.out.println("Laberinto inicial:");
                    mostrar(laberinto);
                    if (resolver(laberinto, 0, 0)) {
                        System.out.println("Camino encontrado:");
                        mostrar(laberinto);
                    } else {
                        System.out.println("No hay salida.");
                    }
                }
                case 2 -> {
                    int[][] laberinto = copiar(mapa);
                    System.out.println("Laberinto inicial:");
                    mostrar(laberinto);
                    if (!resolverConVisualizacion(laberinto, 0, 0)) {
                        System.out.println("No hay salida.");
                    }
                }
                case 3 -> continuar = false;
            }
        } while (continuar);
    }

    private static int[][] copiar(int[][] mapa) {
        int[][] copia = new int[mapa.length][mapa[0].length];
        for (int fila = 0; fila < mapa.length; fila = fila + 1) {
            for (int columna = 0; columna < mapa[0].length; columna = columna + 1) {
                copia[fila][columna] = mapa[fila][columna];
            }
        }
        return copia;
    }
}
