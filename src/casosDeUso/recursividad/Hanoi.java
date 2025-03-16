import java.util.Scanner;

public class Hanoi {
    
    public static void resolver(int numeroDiscos, char torreOrigen, char torreDestino, char torreAuxiliar) {
        if (numeroDiscos == 1) {
            System.out.println("Mover disco 1 desde " + torreOrigen + " hasta " + torreDestino);
            return;
        }
        
        resolver(numeroDiscos - 1, torreOrigen, torreAuxiliar, torreDestino);
        System.out.println("Mover disco " + numeroDiscos + " desde " + torreOrigen + " hasta " + torreDestino);
        resolver(numeroDiscos - 1, torreAuxiliar, torreDestino, torreOrigen);
    }
    
    public static void resolverConVisualizacion(int totalDiscos) {
        int[][] torres = new int[3][totalDiscos];
        
        for (int i = 0; i < totalDiscos; i++) {
            torres[0][i] = totalDiscos - i;
            torres[1][i] = 0;
            torres[2][i] = 0;
        }
        
        System.out.println("Estado inicial:");
        mostrarTorres(torres, totalDiscos);
        
        resolverVisual(totalDiscos, torres, 0, 2, 1, totalDiscos);
    }
    
    private static void resolverVisual(int numeroDiscos, int[][] torres, int origen, int destino, int auxiliar, int totalDiscos) {
        if (numeroDiscos == 1) {
            moverDisco(torres, origen, destino, totalDiscos);
            System.out.println("Mover disco desde torre " + (origen + 1) + " hasta torre " + (destino + 1) + ":");
            mostrarTorres(torres, totalDiscos);
            return;
        }
        
        resolverVisual(numeroDiscos - 1, torres, origen, auxiliar, destino, totalDiscos);
        moverDisco(torres, origen, destino, totalDiscos);
        System.out.println("Mover disco desde torre " + (origen + 1) + " hasta torre " + (destino + 1) + ":");
        mostrarTorres(torres, totalDiscos);
        resolverVisual(numeroDiscos - 1, torres, auxiliar, destino, origen, totalDiscos);
    }
    
    private static void moverDisco(int[][] torres, int origen, int destino, int totalDiscos) {
        int discoAMover = 0;
        int posOrigen = totalDiscos - 1;
        while (posOrigen >= 0 && torres[origen][posOrigen] == 0) {
            posOrigen--;
        }
        if (posOrigen >= 0) {
            discoAMover = torres[origen][posOrigen];
            torres[origen][posOrigen] = 0;
        }
        
        int posDestino = 0;
        while (posDestino < totalDiscos && torres[destino][posDestino] != 0) {
            posDestino++;
        }
        if (posDestino < totalDiscos) {
            torres[destino][posDestino] = discoAMover;
        }
    }
    
    private static void mostrarTorres(int[][] torres, int totalDiscos) {
        for (int nivel = totalDiscos - 1; nivel >= 0; nivel--) {
            for (int torre = 0; torre < 3; torre++) {
                if (torres[torre][nivel] == 0) {
                    System.out.print("  |  ");
                } else {
                    System.out.print("  " + torres[torre][nivel] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println(" Torre1 Torre2 Torre3");
        new Scanner(System.in).nextLine();
    }
    
    public static void main(String[] args) {
        System.out.print("Número de discos: ");
        int numeroDiscos = new Scanner(System.in).nextInt();
        
        System.out.println("SOLUCIÓN PARA " + numeroDiscos + " DISCOS (CON VISUALIZACIÓN):");
        resolverConVisualizacion(numeroDiscos);
        
        int totalMovimientos = (int)Math.pow(2, numeroDiscos) - 1;
        System.out.println("Número total de movimientos: " + totalMovimientos);
    }
}
