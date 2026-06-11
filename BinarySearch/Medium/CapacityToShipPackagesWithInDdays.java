package BinarySearch.Medium;

public class CapacityToShipPackagesWithInDdays {
    /*
     * A conveyor belt has packages that must be shipped from one port to another
     * within days days.
     * 
     * The ith package on the conveyor belt has a weight of weights[i]. Each day, we
     * load the ship with packages on the conveyor belt (in the order given by
     * weights). We may not load more weight than the maximum weight capacity of the
     * ship.
     * 
     * Return the least weight capacity of the ship that will result in all the
     * packages on the conveyor belt being shipped within days days.
     * 
     * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
     * Output: 15
     * 
     * Input: weights = [3,2,2,4,1,4], days = 3
     * Output: 6
     */

    public static void main(String[] args) {
        int[] weights = { 3, 2, 2, 4, 1, 4 };
        int days = 3;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int sum = 0;
        int max = weights[0];
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            int leastDays = findLeastDays(weights, mid);
            if (leastDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    private static int findLeastDays(int[] weights, int capacity) {
        int load = 0;
        int day = 1;

        for (int i = 0; i < weights.length; i++) {
            if ((load + weights[i]) > capacity) {
                day++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return day;
    }
}
