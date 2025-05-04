package casosDeUso.inmutabilidad.e060;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {
    public static void main(String[] args) {
        // IntStream - generar un rango de enteros
        IntStream rangeStream = IntStream.rangeClosed(1, 10);
        
        System.out.println("Suma de números del 1 al 10: " + rangeStream.sum());
        
        // Estadísticas de un IntStream
        int[] values = {45, 38, 92, 67, 55, 23, 71, 89};
        
        IntSummaryStatistics stats = Arrays.stream(values).summaryStatistics();
        
        System.out.println("Estadísticas de valores:");
        System.out.println("Cantidad: " + stats.getCount());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
        
        // LongStream - factorial
        long factorial = LongStream.rangeClosed(1, 15)
                .reduce(1L, (a, b) -> a * b);
        
        System.out.println("Factorial de 15: " + factorial);
        
        // DoubleStream - procesar valores con punto flotante
        double[] prices = {29.99, 9.99, 5.49, 3.99, 6.99};
        double totalWithTax = DoubleStream.of(prices)
                .map(price -> price * 1.21) // Añadir 21% de IVA
                .sum();
        
        System.out.println("Total con IVA: $" + String.format("%.2f", totalWithTax));
        
        // Conversión entre tipos de stream
        IntStream.rangeClosed(1, 5)
                .mapToObj(i -> "Número " + i)
                .forEach(System.out::println);
    }
}