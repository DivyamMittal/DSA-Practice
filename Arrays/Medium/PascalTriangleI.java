package Arrays.Medium;

public class PascalTriangleI {
    /*
     * Given two integers r and c, return the value at the rth row and cth column
     * (1-indexed) in a Pascal's Triangle.
     * In Pascal's triangle:
     * The first row contains a single element 1.
     * Each row has one more element than the previous row.
     * Every row starts and ends with 1.
     * For all interior elements (i.e., not at the ends), the value at position (r,
     * c) is computed as the sum of the two elements directly above it from the
     * previous row:
     * 
     * Pascal[r][c]=Pascal[r−1][c−1]+Pascal[r−1][c]
     * where indexing is 1-based
     * 
     * Input: r = 4, c = 2
     * 
     * Output: 3
     */

    public static void main(String[] args) {
        int r = 8;
        int c = 4;
        System.out.println(pascalTriangleI(r-1, c-1));
    }

    public static int pascalTriangleI(int r, int c) {
        int res = 1;

        for(int i=0; i<c; i++){
            res = res * (r - i);
            res = res / (i+1);
        }

        return res;
    }
}
