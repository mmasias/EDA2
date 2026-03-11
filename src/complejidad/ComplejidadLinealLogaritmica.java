class ComplejidadLinealLogaritmica {

    public static void main(String[] args) {
        System.out.println("Proceso de ordenación con traza");
        System.out.println();
        int[] cartas = {5, 2, 8, 1, 9, 3, 7, 4};
        mergeSortConTraza(cartas);
    }

    static void mergeSort(int[] array) {
        if (array.length <= 1) return;
        
        int n = array.length;
        int[] auxiliar = new int[n];
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            for (int inicio = 0; inicio < n; inicio += 2 * tamano) {
                int medio = Math.min(inicio + tamano, n);
                int fin = Math.min(inicio + 2 * tamano, n);
                
                merge(array, auxiliar, inicio, medio, fin);
            }
        }
    }

    static void merge(int[] array, int[] auxiliar, int inicio, int medio, int fin) {
        int i = inicio;
        int j = medio;
        int k = inicio;
        
        while (i < medio && j < fin) {
            if (array[i] <= array[j]) {
                auxiliar[k++] = array[i++];
            } else {
                auxiliar[k++] = array[j++];
            }
        }
        
        while (i < medio) {
            auxiliar[k++] = array[i++];
        }
        
        while (j < fin) {
            auxiliar[k++] = array[j++];
        }
        
        for (int idx = inicio; idx < fin; idx++) {
            array[idx] = auxiliar[idx];
        }
    }

    static void mergeSortConTraza(int[] array) {
        if (array.length <= 1) return;
        
        int n = array.length;
        int[] auxiliar = new int[n];
        int nivel = 0;
        
        System.out.println("Array inicial: " + java.util.Arrays.toString(array));
        System.out.println();
        
        for (int tamano = 1; tamano < n; tamano *= 2) {
            nivel++;
            System.out.println("--- Nivel " + nivel + ": mezclando bloques de tamaño " + tamano + " ---");
            
            for (int inicio = 0; inicio < n; inicio += 2 * tamano) {
                int medio = Math.min(inicio + tamano, n);
                int fin = Math.min(inicio + 2 * tamano, n);
                
                int[] bloque1 = java.util.Arrays.copyOfRange(array, inicio, medio);
                int[] bloque2 = java.util.Arrays.copyOfRange(array, medio, fin);
                
                System.out.print("  Mezclar: " + java.util.Arrays.toString(bloque1) + 
                               " + " + java.util.Arrays.toString(bloque2));
                
                merge(array, auxiliar, inicio, medio, fin);
                
                int[] resultado = java.util.Arrays.copyOfRange(array, inicio, fin);
                System.out.println(" -> " + java.util.Arrays.toString(resultado));
            }
            System.out.println();
        }
    }
}