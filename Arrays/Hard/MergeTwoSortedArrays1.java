package Arrays.Hard;

public class MergeTwoSortedArrays1 {
    /*
     * Merge two sorted arrays without extra space 1
     * 
     * ou are given two integer arrays nums1 and nums2, sorted in non-decreasing
     * order, and two integers m and n, representing the number of elements in nums1
     * and nums2 respectively.
     * 
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);

        for(int i = 0; i<nums1.length; i++){
            System.out.print(nums1[i]+" ");
        }
    }

    /// Brute Force
    /// take another array and put the elements there (With extra space)

    // Optimal approach
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int idx = nums1.length - 1;

        while (second >= 0) {
            if (first >= 0 && nums1[first] > nums2[second]) {
                nums1[idx] = nums1[first];
                first--;
                idx--;
            } else {
                nums1[idx] = nums2[second];
                second--;
                idx--;
            }
        }
    }
}
