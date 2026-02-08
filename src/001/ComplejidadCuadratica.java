class ComplejidadCuadratica {

    public static void main(String[] args) {
        int[] fiesta = {1, 2, 3, 4};

        System.out.println("Saludos en fiesta de 4 personas:");
        int total = contarSaludos(fiesta);
        System.out.println("Total saludos: " + total);
        System.out.println("Con 4 personas: 4×3/2 = 6 saludos");

        System.out.println("Buscar duplicados:");
        int[] conDuplicados = {1, 2, 3, 2, 4};
        System.out.println("¿Hay duplicados? " + buscarDuplicados(conDuplicados));
    }

    static int contarSaludos(int[] personas) {

        int saludos = 0;
        for (int persona = 0; persona < personas.length; persona++) {
            for (int personaSaludada = persona + 1; personaSaludada < personas.length; personaSaludada++) {
                System.out.println(personas[persona] + " saluda a " + personas[personaSaludada]);
                saludos++;
            }
        }
        return saludos;
    }

    static boolean buscarDuplicados(int[] lista) {

        for (int i = 0; i < lista.length; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i] == lista[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
