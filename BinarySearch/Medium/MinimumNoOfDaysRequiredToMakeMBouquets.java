package BinarySearch.Medium;

public class MinimumNoOfDaysRequiredToMakeMBouquets {
    /*
     * You are given an integer array bloomDay, an integer m and an integer k.
     * 
     * You want to make m bouquets. To make a bouquet, you need to use k adjacent
     * flowers from the garden.
     * 
     * The garden consists of n flowers, the ith flower will bloom in the
     * bloomDay[i] and then can be used in exactly one bouquet.
     * 
     * Return the minimum number of days you need to wait to be able to make m
     * bouquets from the garden. If it is impossible to make m bouquets return -1.
     * 
     * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
     * Output: 3
     */

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (n < (m * k))
            return -1;

        // find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possibleCheck(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean possibleCheck(int[] bloomDay, int day, int m, int k) {
        int noOfBouq = 0;

        int cnt = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                noOfBouq += (cnt / k);
                cnt = 0;
            }
        }
        noOfBouq += (cnt / k);
        return noOfBouq >= m;
    }

}
