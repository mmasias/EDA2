public class QueensMuted {

    private int queensQuantity;

    private QueensMuted(int queensQuantity){
        this.queensQuantity = queensQuantity;
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
            if (canPutQueen(board, i, col)) {
                board[i][col] = 1; 

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
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

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }

    public static void main(String[] args) {
        QueensMuted queen = new QueensMuted(9);
        queen.solveNQ();
    }
}
