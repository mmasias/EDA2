package casosDeUso.inmutabilidad.e040;

import java.util.List;

class Order {
    private final String orderNumber;
    private final List<OrderItem> items;

    public Order(String orderNumber, List<OrderItem> items) {
        this.orderNumber = orderNumber;
        this.items = items;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}