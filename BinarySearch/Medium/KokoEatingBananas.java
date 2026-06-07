package BinarySearch.Medium;

public class KokoEatingBananas {
    /*
     * A monkey is given n piles of bananas, where the 'ith' pile has nums[i]
     * bananas. An integer h represents the total time in hours to eat all the
     * bananas.
     * 
     * Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
     * If the pile contains fewer than k bananas, the monkey eats all the bananas in
     * that pile and does not consume any more bananas in that hour.
     * 
     * Determine the minimum number of bananas the monkey must eat per hour to
     * finish all the bananas within h hours.
     * 
     * Input: n = 4, nums = [7, 15, 6, 3], h = 8
     * Output: 5
     */

    public static void main(String[] args) {
        int[] nums = {7, 15, 6, 3};
        int h = 4;

        System.out.println(minimumRateToEatBananas(nums, h));
    }

    public static int minimumRateToEatBananas(int[] nums, int h) {
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int low = 1;
        int high = max;
        while(low <= high){
            int mid = (low + high) / 2;
            int hours = func(nums, mid);
            if(hours <= h){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    // ------------- HELPER -----------------
    private static int func(int[] nums, int mid){
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            cnt += Math.ceil((double)nums[i] / (double)mid);
        }
        return cnt;
    }
}
