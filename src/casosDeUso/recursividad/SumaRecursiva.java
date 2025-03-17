public class SumaRecursiva {
    
    public static int sumar(int[] numeros) {
        
        if (numeros.length == 0) {
            return 0;
        } else {

            int cabeza = numeros[0];           
            int[] cola = new int[numeros.length - 1];
            System.arraycopy(numeros, 1, cola, 0, numeros.length - 1);
            return cabeza + sumar(cola);
        }
    }
    
    public static void main(String[] args) {
        int[] ejemplo1 = {1, 2, 3, 4, 5};
        System.out.println("La suma de {1, 2, 3, 4, 5} es: " + sumar(ejemplo1));
        
        int[] ejemplo2 = {5, 2, 4, 8};
        System.out.println("La suma de {5, 2, 4, 8} es: " + sumar(ejemplo2));
        
        int[] ejemplo3 = {1, 10, 100, 1000};
        System.out.println("La suma de {1, 10, 100, 1000} es: " + sumar(ejemplo3));
    }
}