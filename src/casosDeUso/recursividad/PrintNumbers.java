public class PrintNumbers {

    public static void printNumbers(int current, int n) {
        if (current > n) {
            System.out.println("FIN");
            return;  
        }
        System.out.println(current);  
        printNumbers(current + 1, n);  
    }

    public static void main(String[] args) {
        int end = 10;  
        printNumbers(1, end);  
    }
}
