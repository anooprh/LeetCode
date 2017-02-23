# [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

### Problem Statement

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

### Observation

Here we are asked to solve the problem in __O(log(m+n))__ which makes the solution tricky

Example given 

````
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
````

````
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
````

### Solution

If we were not placed with the restriction that the solution should run in __O(log(m+n))__ time, this could be solved easily by the following algorithm. We find the combined sorted array and return the middle element(or average of middle elements).


```java
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

```
This algorithm runs in __O(m+n)__ time as we access each element in both the arrays. This is similar to the merge step of the merge sort.

To solve it in __O(log(m+n))__ time, we use the binary search approach. First of all we find the lenth of the combined array and if the number of elements in the combined array is odd, we have to return the `total_length/2 + 1`'th element (1 indexed), and if it is even, we return the average of `total_length/2`'th and `total_length/2 + 1`'th elements.
 
We introduce a helper method `find_Kth()` which returns the k'th element in two arrays combined. We intend to call this recursively, so we also introduce the starting index from which we begin our search(`s1` and `s2`). The base cases of the recursion are when either of the starting indices(`s1` or `s2`) exceed their respective array length or when we want the first element the combined array. These are trivial solutions. Next we proceed to find the artificial mid point of these two arrays(i.e if we want to find `k`th element in the combined array, we define these points as `k/2` points). We define these values as `mid1` and `mid2` respectively. We see that if `mid1 < mid2` , then the k'th element is somewhere in the right side of `m1` in `nums1` or left side `m2` in `nums2`. If `m2 <= m1`, the converse is true. We reduce `k` by half and continue our search. 
   
> TODO : Insert diagram if possible

 
 
  
```java
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

```

### Analysis

The time complexity of solution(1) is __O(log(m+n))__. We are not using auxillary memory, so auxillry space complexity is __O(1)__.