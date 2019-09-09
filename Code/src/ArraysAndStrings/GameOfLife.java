package ArraysAndStrings;

public class GameOfLife {
    int[][] copyBoard;
    int rows, cols;

    private int upperLeft(int row, int col) {
        if (row == 0 || col == 0)
            return 0;
        return copyBoard[row - 1][col - 1];
    }

    private int upper(int row, int col) {
        if (row == 0)
            return 0;
        return copyBoard[row - 1][col];
    }

    private int upperRight(int row, int col) {
        if (row == 0 || col == cols - 1)
            return 0;
        return copyBoard[row - 1][col + 1];
    }

    private int left(int row, int col) {
        if (col == 0)
            return 0;
        return copyBoard[row][col - 1];
    }

    private int right(int row, int col) {
        if (col == cols - 1)
            return 0;
        return copyBoard[row][col + 1];
    }

    private int lowerLeft(int row, int col) {
        if (row == rows - 1 || col == 0)
            return 0;
        return copyBoard[row + 1][col - 1];
    }

    private int lower(int row, int col) {
        if (row == rows - 1)
            return 0;
        return copyBoard[row + 1][col];
    }

    private int lowerRight(int row, int col) {
        if (row == rows - 1 || col == cols - 1)
            return 0;
        return copyBoard[row + 1][col + 1];
    }

    public int[][] gameOfLife(int[][] board) {
        rows = board.length;
        cols = board[0].length;
        copyBoard = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        int neighbors;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                neighbors = upperLeft(row, col) + upper(row, col) + upperRight(row, col) +
                        left(row, col) + right(row, col) + lowerLeft(row, col) + lower(row, col) +
                        lowerRight(row, col);
                if (copyBoard[row][col] == 1) {
                    if (neighbors < 2)
                        board[row][col] = 0;
                    else if (neighbors == 2 || neighbors == 3)
                        board[row][col] = 1;
                    else if (neighbors > 3)
                        board[row][col] = 0;
                }
                else {
                    if (neighbors == 3)
                        board[row][col] = 1;
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] image = {{0, 1, 0}, {0, 0, 1}, {1, 1,1}, {0, 0, 0}};
        int[][] result = obj.gameOfLife(image);
        for (int i = 0; i < obj.rows; i++) {
            for (int j = 0; j < obj.cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
