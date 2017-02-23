package a011__Container_With_Most_Water;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution solution;
    String url = "https://leetcode.com/problems/container-with-most-water/";
    // Accepted


    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldTestDescriptionExamples() {
        assertEquals(0,solution.maxArea(null));
        assertEquals(0,solution.maxArea(new int[]{1}));
        assertEquals(1,solution.maxArea(new int[]{1,2}));
        assertEquals(2,solution.maxArea(new int[]{1,2,1}));
        assertEquals(3,solution.maxArea(new int[]{1,2,2,1}));
        assertEquals(6,solution.maxArea(new int[]{1,2,2,2,2,1}));
    }

}