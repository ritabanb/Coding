package ArraysAndStrings;

import java.util.Arrays;

public class ZeroMatrix {
    private int[][] fillZero(int[][] result, int i, int j){
        int m = result.length;
        int n = result[0].length;
        for (int x = 0; x < m; x++) {
            result[x][j] = 0;
        }
        for (int y = 0; y < n; y++) {
            result[i][y] = 0;
        }
        return result;
    }

    private int[][] zeroMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++)
            System.arraycopy(matrix[i], 0, result[i], 0, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    fillZero(result, i, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10,11, 12}, {13, 14, 15, 16}};
        ZeroMatrix obj = new ZeroMatrix();
        int[][] result = obj.zeroMatrix(image);
        for (int[] ints : result) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
