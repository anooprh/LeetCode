package a007__Reverse_Integer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/reverse-integer/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void descriptionTestCase(){
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(0, solution.reverse(0));
        assertEquals(0, solution.reverse(1000000003));
    }
}