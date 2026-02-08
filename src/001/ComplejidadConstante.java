class ComplejidadConstante {

    public static void main(String[] args) {
        int[] libro = new int[1000];
        int pagina = 42;

        int contenido = accederPorIndice(libro, pagina);

        System.out.println("Acceso directo: O(1)");
        System.out.println("Contenido de página " + pagina + ": " + contenido);
    }

    static int accederPorIndice(int[] array, int indice) {
        return array[indice];
    }
}
