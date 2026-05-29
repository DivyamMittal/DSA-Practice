package Arrays.easy;

public class BestTimeToBuyAndSellStock {
    /*
     * You are given an array prices where prices[i] is the price of a given stock
     * on the ith day.
     * 
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     * 
     * Return the maximum profit you can achieve from this transaction. If you
     * cannot achieve any profit, return 0.
     * 
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     */

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        // int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) {
            return 0;
        }

        int buy = prices[0];
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }

            else if (prices[i] > buy) {
                maxi = prices[i] - buy;
                profit = Math.max(maxi, profit);
            }
        }

        return profit;
    }
}
