package a006__ZigZag_Conversion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/zigzag-conversion/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void descriptionTestCase(){
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }

}