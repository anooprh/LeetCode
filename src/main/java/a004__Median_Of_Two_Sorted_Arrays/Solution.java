package a004__Median_Of_Two_Sorted_Arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays_sublineartime(nums1, nums2);
//        return findMedianSortedArrays_lineartime(nums1, nums2);
    }

    private double findMedianSortedArrays_lineartime(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0, idx = 0;
        int[] combined = new int[nums1.length + nums2.length];
        while (idx < combined.length) {
            if (ptr1 >= nums1.length) {
                combined[idx++] = nums2[ptr2++];
            } else if (ptr2 >= nums2.length) {
                combined[idx++] = nums1[ptr1++];
            } else if (nums2[ptr2] <= nums1[ptr1]) {
                combined[idx++] = nums2[ptr2++];
            } else if (nums1[ptr1] <= nums2[ptr2]) {
                combined[idx++] = nums1[ptr1++];
            }

        }
        if (combined.length % 2 == 1) return combined[combined.length / 2];
        else return (combined[combined.length / 2 - 1] + combined[combined.length / 2]) / 2.0;
    }

    private double findMedianSortedArrays_sublineartime(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return find_Kth(total / 2 + 1, nums1, nums2, 0, 0);
        } else {
            return (find_Kth(total / 2, nums1, nums2, 0, 0) + find_Kth(total / 2 + 1, nums1, nums2, 0, 0)) / 2.0;
        }
    }

    private double find_Kth(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length)
            return nums2[s2 + k - 1];
        if (s2 >= nums2.length)
            return nums1[s1 + k - 1];
        if (k == 1)
            return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        double mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        double mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return find_Kth(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return find_Kth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }

}
