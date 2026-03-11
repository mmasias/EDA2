public class ComplejidadExponencial {

    public static void mostrarCombinacionesBinarias(int n) {
        int totalCombinaciones = (int) Math.pow(2, n);

        System.out.println("Con " + n + " dígito(s) binario(s):");
        System.out.println("Total de combinaciones: " + totalCombinaciones);
        System.out.println();

        for (int i = 0; i < totalCombinaciones; i++) {
            String binario = String.format("%" + n + "s",Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(String.format("%3d: %s", i, binario));
        }
    }

    public static void main(String[] args) {
        mostrarCombinacionesBinarias(4);
    }
}