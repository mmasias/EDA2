public class PrintNumbersDescending {

    public static void printNumbersDesc(int n, int m) {
        if (n < m) {
            System.out.println("FIN");
            return; 
        }
        System.out.println(n);
        printNumbersDesc(n - 1, m);
    }

    public static void main(String[] args) {
        int start = 20;
        int end = 10;
        printNumbersDesc(start, end);
    }
}
