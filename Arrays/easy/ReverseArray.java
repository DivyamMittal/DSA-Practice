package Arrays.easy;

public class ReverseArray {
    // In place (without using extra space)

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        reverseArr(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void reverseArr(int[] arr) {
        int x = 0;
        int y = arr.length - 1;

        while (x < y) {
            int i = arr[x];
            arr[x] = arr[y];
            arr[y] = i;

            x++;
            y--;
        }
    }
}
