package Arrays.Medium;

public class RotateMatricBy90Degree {
    /*
     * Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
     * The rotation must be done in place, meaning the input 2D matrix must be
     * modified directly.
     * Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
     * Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
     */
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 2 }, { 2, 0, 3, 1 }, { 4, 5, 0, 5 }, { 5, 6, 7, 0 } };

        /// Appoach:-
        /// 1. Transpose the matrix
        /// 2. Rotate every row

        rotateMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // transposing matrix
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse every row
        for (int i = 0; i < m; i++) {
            reverseRow(matrix, i);
        }

    }

    public static void reverseRow(int[][] matrix, int row) {
        int i = 0;
        int j = matrix[row].length - 1;

        while (i < j) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }

}
