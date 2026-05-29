package Arrays.Medium;

public class PascalTriangle2 {
    public static void main(String[] args) {
        // int[] res = pascalTriangleII(4);
        int[] res = pascalTriangleIIOptimize(6);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] pascalTriangleIIOptimize(int r) {
        int[] ans = new int[r];
        ans[0] = 1;

        for (int i = 1; i < r; i++) {
            ans[i] = (ans[i - 1] * (r - i) )/i;
        }

        return ans;
    }

    public static int[] pascalTriangleII(int r) {
        int[] ans = new int[r];

        for (int i = 0; i < r; i++) {
            ans[i] = ncr(r - 1, i);
        }

        return ans;
    }

    private static int ncr(int r, int c) {
        int res = 1;
        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }
        return res;
    }
}
