public class SumRange {

    public static int sumNumbers(int m, int n) {
        if (m > n) {
            return 0;
        }
        return m + sumNumbers(m + 1, n);
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 5;
        int result = sumNumbers(start, end);
        System.out.println("La suma de los números del " + start + " al " + end + " es: " + result);
    }
}
