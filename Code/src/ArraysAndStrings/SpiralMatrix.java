package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return new ArrayList<>();
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        int rowStart = 0, rowEnd = rows - 1;
        int colStart = 0, colEnd = cols - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int col = colStart; col <= colEnd; col++)
                result.add(matrix[rowStart][col]);
            for (int row = rowStart + 1; row <= rowEnd; row++)
                result.add(matrix[row][colEnd]);
            if (rowStart < rowEnd && colStart < colEnd) {
                for (int col = colEnd - 1; col > colStart; col--)
                    result.add(matrix[rowEnd][col]);
                for (int row = rowEnd; row > rowStart; row--)
                    result.add(matrix[row][colStart]);
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return result;
    }
}
