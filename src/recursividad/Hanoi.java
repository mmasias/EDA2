import java.util.Scanner;

public class Hanoi {

    static void resolver(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }

        resolver(n - 1, origen, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        resolver(n - 1, auxiliar, destino, origen);
    }

    static void resolverConVisualizacion(int totalDiscos) {
        final char[] nombre = {'A', 'B', 'C'};
        int[][] torres = new int[3][totalDiscos];
        for (int i = 0; i < totalDiscos; i++) {
            torres[0][i] = totalDiscos - i;
        }
        System.out.println("Estado inicial:");
        mostrarTorres(torres, totalDiscos);
        resolverVisual(totalDiscos, torres, 0, 2, 1, totalDiscos, nombre);
    }

    private static void resolverVisual(int n, int[][] torres, int origen, int destino, int auxiliar, int totalDiscos, char[] nombre) {
        if (n == 1) {
            moverDisco(torres, origen, destino, totalDiscos);
            System.out.println("Mover disco 1 de " + nombre[origen] + " a " + nombre[destino] + ":");
            mostrarTorres(torres, totalDiscos);
            return;
        }

        resolverVisual(n - 1, torres, origen, auxiliar, destino, totalDiscos, nombre);
        moverDisco(torres, origen, destino, totalDiscos);
        System.out.println("Mover disco " + n + " de " + nombre[origen] + " a " + nombre[destino] + ":");
        mostrarTorres(torres, totalDiscos);
        resolverVisual(n - 1, torres, auxiliar, destino, origen, totalDiscos, nombre);
    }

    private static void moverDisco(int[][] torres, int origen, int destino, int totalDiscos) {
        int posicionOrigen = totalDiscos - 1;
        while (posicionOrigen >= 0 && torres[origen][posicionOrigen] == 0) {
            posicionOrigen = posicionOrigen - 1;
        }

        int disco = torres[origen][posicionOrigen];
        torres[origen][posicionOrigen] = 0;

        int posicionDestino = 0;
        while (posicionDestino < totalDiscos && torres[destino][posicionDestino] != 0) {
            posicionDestino = posicionDestino + 1;
        }
        torres[destino][posicionDestino] = disco;
    }

    private static void mostrarTorres(int[][] torres, int totalDiscos) {
        System.out.println("=".repeat(20));
        for (int nivel = totalDiscos - 1; nivel >= 0; nivel--) {
            for (int torre = 0; torre < 3; torre++) {
                System.out.print(torres[torre][nivel] == 0 ? "   |   " : "   " + torres[torre][nivel] + "   ");
            }
            System.out.println();
        }
        System.out.println(" Torre1 Torre2 Torre3");
        System.out.println("=".repeat(20));
        System.out.println();
    }

    static void resolverConTrazaYVisualizacion(int totalDiscos) {
        final char[] nombre = { 'A', 'B', 'C' };
        int[][] torres = new int[3][totalDiscos];
        for (int i = 0; i < totalDiscos; i++) {
            torres[0][i] = totalDiscos - i;
        }
        System.out.println("Estado inicial:");
        mostrarTorres(torres, totalDiscos);
        resolverVisualConTraza(totalDiscos, torres, 0, 2, 1, totalDiscos, nombre, 0);
    }

    private static void resolverVisualConTraza(int n, int[][] torres, int origen, int destino, int auxiliar, int totalDiscos, char[] nombre, int profundidad) {
        final String IDA = "-->";
        final String VUELTA = "<--";
        String sangria = "[#]".repeat(profundidad);
        System.out.println(sangria + IDA + " resolver(" + n + ", " + nombre[origen] + ", " + nombre[destino] + ", " + nombre[auxiliar] + ")");

        if (n == 1) {
            moverDisco(torres, origen, destino, totalDiscos);
            System.out.println(sangria + "    [mover disco 1 de " + nombre[origen] + " a " + nombre[destino] + "]");
            mostrarTorres(torres, totalDiscos);
            System.out.println(sangria + VUELTA + " resolver(" + n + ", " + nombre[origen] + ", " + nombre[destino] + ", " + nombre[auxiliar] + ")");
            return;
        }

        resolverVisualConTraza(n - 1, torres, origen, auxiliar, destino, totalDiscos, nombre, profundidad + 1);
        moverDisco(torres, origen, destino, totalDiscos);
        System.out.println(sangria + "    [mover disco " + n + " de " + nombre[origen] + " a " + nombre[destino] + "]");
        mostrarTorres(torres, totalDiscos);
        resolverVisualConTraza(n - 1, torres, auxiliar, destino, origen, totalDiscos, nombre, profundidad + 1);

        System.out.println(sangria + VUELTA + " resolver(" + n + ", " + nombre[origen] + ", " + nombre[destino] + ", " + nombre[auxiliar] + ")");
    }

    static void resolverConTraza(int n, char origen, char destino, char auxiliar, int profundidad) {
        final String IDA = "-->";
        final String VUELTA = "<--";
        String sangria = "[#]".repeat(profundidad);
        System.out.println(sangria + IDA + " resolver(" + n + ", " + origen + ", " + destino + ", " + auxiliar + ")");

        if (n == 1) {
            System.out.println(sangria + "    [mover disco 1 de " + origen + " a " + destino + "]");
            System.out.println(sangria + VUELTA + " resolver(" + n + ", " + origen + ", " + destino + ", " + auxiliar + ")");
            return;
        }

        resolverConTraza(n - 1, origen, auxiliar, destino, profundidad + 1);
        System.out.println(sangria + "    [mover disco " + n + " de " + origen + " a " + destino + "]");
        resolverConTraza(n - 1, auxiliar, destino, origen, profundidad + 1);

        System.out.println(sangria + VUELTA + " resolver(" + n + ", " + origen + ", " + destino + ", " + auxiliar + ")");
    }

    public static void main(String[] args) {
        boolean continuar = true;
        do {
            System.out.print("¿Cuántos discos?: ");
            int numeroDeDiscos = new Scanner(System.in).nextInt();
            System.out.println("Total de movimientos para " + numeroDeDiscos + " discos: " + ((int) Math.pow(2, numeroDeDiscos) - 1));
    
            System.out.println("1: Movimientos / 2: Visualización / 3: Pila / 4: Pila & visualización / 5: Salir");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    System.out.println("Movimientos:");
                    resolver(numeroDeDiscos, 'A', 'C', 'B');
                }
                case 2 -> {
                    System.out.println("Visualización paso a paso:");
                    resolverConVisualizacion(numeroDeDiscos);
                }
                case 3 -> {
                    System.out.println("Llamadas recursivas:");
                    resolverConTraza(numeroDeDiscos, 'A', 'C', 'B', 0);
                }
                case 4 -> {
                    System.out.println("Llamadas recursivas con visualización:");
                    resolverConTrazaYVisualizacion(numeroDeDiscos);
                }
                case 5 -> continuar = false;
            }
        } while(continuar);

    }
}
