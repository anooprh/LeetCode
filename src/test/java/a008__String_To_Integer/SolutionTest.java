package a008__String_To_Integer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/string-to-integer-atoi/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void descriptionTestCase(){
        assertEquals(0, solution.myAtoi("0"));
        assertEquals(123, solution.myAtoi("123"));
        assertEquals(123, solution.myAtoi("00123"));
        assertEquals(123, solution.myAtoi("+123"));
        assertEquals(123, solution.myAtoi("+0123"));
        assertEquals(-123, solution.myAtoi("-123"));
        assertEquals(-123, solution.myAtoi("-0000123"));
        assertEquals(0, solution.myAtoi(""));
        assertEquals(0, solution.myAtoi("  "));
        assertEquals(0, solution.myAtoi("bullshit"));
        assertEquals(0, solution.myAtoi("-bullshit"));
        assertEquals(0, solution.myAtoi("+bullshit"));
        assertEquals(0, solution.myAtoi("bul122lshit"));
        assertEquals(0, solution.myAtoi("bu-l122lshit"));
        assertEquals(2147483647, solution.myAtoi("2147483647"));
        assertEquals(2147483647, solution.myAtoi("+2147483647"));
        assertEquals(-2147483647, solution.myAtoi("-2147483647"));
        assertEquals(2147483647, solution.myAtoi("2147483648"));
        assertEquals(2147483647, solution.myAtoi("+2147483648"));
        assertEquals(-2147483648, solution.myAtoi("-2147483648"));
        assertEquals(2147483647, solution.myAtoi("2147483649"));
        assertEquals(2147483647, solution.myAtoi("+2147483649"));
        assertEquals(-2147483648, solution.myAtoi("-2147483649"));
        assertEquals(2147483647, solution.myAtoi("00002147483647343239824980127340218934790128347091823479018324790123847901283749021834709213847920834712039847289081234873214871234872134821342314"));
        assertEquals(14, solution.myAtoi("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000014"));
        assertEquals(-2147483647, solution.myAtoi("-00002147483647"));
        assertEquals(2147483647, solution.myAtoi("00214748364000007"));
        assertEquals(0, solution.myAtoi("+"));
        assertEquals(0, solution.myAtoi("-"));
        assertEquals(0, solution.myAtoi("    +0a32"));
        assertEquals(0, solution.myAtoi("   +0 123"));
        assertEquals(-2147483648, solution.myAtoi("      -11919730356x"));
    }


}