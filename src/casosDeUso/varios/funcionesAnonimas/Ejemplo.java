package casosDeUso.varios.funcionesAnonimas;

public class Ejemplo {
    public static void main(String[] args) {
        Calculadora suma = (a, b) -> a + b;

        int resultado = suma.calcular(5, 3);
        System.out.println("El resultado es: " + resultado);
    }
}
