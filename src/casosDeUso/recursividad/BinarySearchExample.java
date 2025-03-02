import java.util.Scanner;

class BinarySearchExample {

    static int binarySearch(int[] array, int key, int low, int high) {
        traza("Buscando en el rango [" + low + " - " + high + "]");
        if (high >= low) {
            int mid = low + (high - low) / 2;
            traza("Punto medio en índice " + mid + " con valor " + array[mid]);

            if (array[mid] == key) {
                traza("Elemento encontrado en el índice " + mid);
                return mid;
            } else if (array[mid] > key) {
                traza("Buscando a la izquierda del punto medio porque " + key + " < " + array[mid]);
                return binarySearch(array, key, low, mid - 1);
            } else {
                traza("Buscando a la derecha del punto medio porque " + key + " > " + array[mid]);
                return binarySearch(array, key, mid + 1, high);
            }
        }
        traza("Elemento no encontrado en el rango actual.");
        return -1;
    }

    static void traza(String mensaje){
        System.out.print(" [TRAZA] > " + mensaje);
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 9, 12, 15, 18, 21, 23};
        int key = 21;
        System.out.println("Iniciando búsqueda del elemento " + key);
        int result = binarySearch(array, key, 0, array.length - 1);

        if (result == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}
