package a004__Median_Of_Two_Sorted_Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/median-of-two-sorted-arrays/";
    // Accepted


    @Before
    public void setUp(){
        solution = new Solution();
    }

    @Test
    public void descriptionTestCase(){
        assertEquals(5.0,
                solution.findMedianSortedArrays(new int[]{1,3,5,7,10}, new int[]{2,4,6,7}), 0.000001);
        assertEquals(2.0,
                solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 0.000001);
        assertEquals(2.5,
                solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 0.000001);
        assertEquals(2.0,
                solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3}), 0.000001);
    }
}