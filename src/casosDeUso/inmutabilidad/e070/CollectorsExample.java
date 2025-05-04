package casosDeUso.inmutabilidad.e070;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsExample {
        public static void main(String[] args) {
                List<Product> products = Arrays.asList(
                                new Product("Laptop", "Electrónica", 1200.0),
                                new Product("Smartphone", "Electrónica", 800.0),
                                new Product("Auriculares", "Electrónica", 100.0),
                                new Product("Mesa", "Hogar", 300.0),
                                new Product("Silla", "Hogar", 120.0),
                                new Product("Libro", "Libros", 25.0),
                                new Product("Juguete", "Infantil", 40.0));

                // Recolectar en diferentes tipos de colecciones
                List<String> productNames = products.stream()
                                .map(Product::getName)
                                .collect(Collectors.toList());

                Set<String> categories = products.stream()
                                .map(Product::getCategory)
                                .collect(Collectors.toSet());

                System.out.println("Productos: " + productNames);
                System.out.println("Categorías: " + categories);

                // Agrupamiento
                Map<String, List<Product>> productsByCategory = products.stream()
                                .collect(Collectors.groupingBy(Product::getCategory));

                System.out.println("Productos por categoría:");
                productsByCategory.forEach((category, productList) -> {
                        System.out.println(category + ":");
                        productList.forEach(p -> System.out.println("  - " + p.getName() +
                                        " ($" + p.getPrice() + ")"));
                });

                // Particionamiento
                Map<Boolean, List<Product>> partitionedByPrice = products.stream()
                                .collect(Collectors.partitioningBy(p -> p.getPrice() > 200));

                System.out.println("Productos premium (>$200):");
                partitionedByPrice.get(true)
                                .forEach(p -> System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")"));

                System.out.println("Productos económicos (≤$200):");
                partitionedByPrice.get(false)
                                .forEach(p -> System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")"));

                // Strings
                String categoriesString = categories.stream()
                                .collect(Collectors.joining(", ", "Categorías: [", "]"));

                System.out.println("" + categoriesString);

                // Estadísticas
                DoubleSummaryStatistics priceStats = products.stream()
                                .collect(Collectors.summarizingDouble(Product::getPrice));

                System.out.println("Estadísticas de precios:");
                System.out.println("Cantidad: " + priceStats.getCount());
                System.out.println("Total: $" + priceStats.getSum());
                System.out.println("Mínimo: $" + priceStats.getMin());
                System.out.println("Máximo: $" + priceStats.getMax());
                System.out.println("Promedio: $" + priceStats.getAverage());
        }
}