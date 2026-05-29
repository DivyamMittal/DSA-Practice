package Arrays.Medium;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArray {
    /*
     * Given two sorted arrays, nums1 and nums2, return an array containing the
     * intersection of these two arrays. Each element in the result must appear as
     * many times as it appears in both arrays; that is, if an element appears x
     * times in nums1 and y times in nums2, it should appear min(x, y) times in the
     * result.
     * 
     * Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
     * 
     * Output: [1, 2]
     */

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 3, 5 };
        int[] nums2 = { 1, 2, 7 };

        int[] res = intersectionArray(nums1, nums2);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return res.stream().mapToInt(x->x).toArray();
    }
}
