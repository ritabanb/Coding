package ArraysAndStrings;

public class RotateMatrix {
    private int[][] rotateMatrix(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = image[i][j];
                image[i][j] = image[j][n - 1 - i];
                image[j][n - 1 - i] = image[n - 1 - i][n - 1 - j];
                image[n - 1 - i][n - 1 - j] = image[n - 1 - j][i];
                image[n - 1 - j][i] = temp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix obj = new RotateMatrix();
        int[][] result = obj.rotateMatrix(image);
        for (int[] ints : result) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
