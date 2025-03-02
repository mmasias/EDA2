import java.util.Scanner;

public class Queens {

    private int queensQuantity;

    private Queens(int queensQuantity){
        this.queensQuantity = queensQuantity;
    }

    boolean canPutQueen(int board[][], int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; j >= 0 && i < queensQuantity; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= queensQuantity) {
            return true; 
        }

        for (int i = 0; i < queensQuantity; i++) {
            traza("Intentando colocarla en (" + col + ", " + i + ") / ");
            if (canPutQueen(board, i, col)) {
                board[i][col] = 1; 
                traza("Colocandola en (" + col + ", " + i + "):");
                printBoard(board);

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
                traza("Quitando la reina de (" + col + ", " + i + "):");
                printBoard(board);  
            } else {
                traza("No se puede colocar en (" + col + ", " + i + ") - Paso a la siguiente fila");
            }
        }
        return false;  
    }

    boolean solveNQ() {
        int board[][] = new int[queensQuantity][queensQuantity];
        cleanScreen();

        if (!solveNQUtil(board, 0)) {
            System.out.println("NO HAY SOLUCION!");
            return false;
        }

        System.out.println("Solución final:");
        printBoard(board);
        return true;
    }

    void printBoard(int board[][]) {
        System.out.println("===".repeat(queensQuantity));
        for (int i = 0; i < queensQuantity; i++) {
            for (int j = 0; j < queensQuantity; j++)
                System.out.print(" " + (board[i][j] == 1 ? "Q" : "_") + " ");
            System.out.println();
        }
        System.out.println("===".repeat(queensQuantity));
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }

    static void traza(String mensaje){
        System.out.print(" [TRAZA] > " + mensaje);
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        Queens queen = new Queens(8);
        queen.solveNQ();
    }
}
