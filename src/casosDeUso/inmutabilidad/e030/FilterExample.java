package casosDeUso.inmutabilidad.e030;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        // Lista de números
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtrar números pares
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + evenNumbers);

        // Filtrar números primos
        List<Integer> primeNumbers = numbers.stream()
                .filter(FilterExample::isPrime)
                .collect(Collectors.toList());

        System.out.println("Números primos: " + primeNumbers);

        // Lista de productos
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0, 10),
                new Product("Smartphone", 800.0, 0),
                new Product("Tablet", 400.0, 5),
                new Product("Monitor", 300.0, 15),
                new Product("Teclado", 50.0, 0));

        // Filtrar productos disponibles en stock
        List<Product> inStockProducts = products.stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());

        System.out.println("Productos en stock:");
        inStockProducts.forEach(p -> System.out.println(p.getName() + " - Stock: " + p.getStock()));

        // Filtrar productos premium (precio > 500)
        List<Product> premiumProducts = products.stream()
                .filter(p -> p.getPrice() > 500)
                .collect(Collectors.toList());

        System.out.println("Productos premium:");
        premiumProducts.forEach(p -> System.out.println(p.getName() + " - Precio: $" + p.getPrice()));
    }

    // Método para verificar si un número es primo
    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }
        return true;
    }
}