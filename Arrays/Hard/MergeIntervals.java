package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
     * Given an array of intervals where intervals[i] = [starti, endi], merge all
     * overlapping intervals, and return an array of the non-overlapping intervals
     * that cover all the intervals in the input.
     * 
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     */

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] ans = merge(intervals);
        // int[][] ans = mergeOptimal(intervals);

        for (int i = 0; i < ans.length; i++) {
            System.out.print("(" + ans[i][0] + " " + ans[i][1] + ")");

        }
    }

    // Optimal
    // TC -> O(n log n) + O(n) , SC -> O(n)
    public static int[][] mergeOptimal(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(intervals[i][1], ans.get(ans.size() - 1).get(1)));
            }
        }

        int[][] result = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {

            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }

    // Bruteforce
    // TC -> O(n log n) + O(2n) , SC -> O(n)
    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] < end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        int[][] result = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {

            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }
}
