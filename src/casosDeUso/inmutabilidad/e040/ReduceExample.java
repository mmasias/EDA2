package casosDeUso.inmutabilidad.e040;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {

        // Ejemplo con objetos complejos - calcular total de ventas
        List<Order> orders = Arrays.asList(
                new Order("A001", Arrays.asList(
                        new OrderItem("Producto1", 10.0, 2),
                        new OrderItem("Producto2", 15.0, 1))),
                new Order("A002", Arrays.asList(
                        new OrderItem("Producto3", 20.0, 3),
                        new OrderItem("Producto4", 5.0, 4))));

        // Calcular importe total de todas las órdenes
        double totalAmount = orders.stream()
                .map(Order::calculateTotal)
                .reduce(0.0, Double::sum);

        System.out.println("Importe total de ventas: $" + totalAmount);
    }
}