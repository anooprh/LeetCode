package a013__Roman_To_Integer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution solution;
    String url = "https://leetcode.com/problems/roman-to-integer/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldTestDescriptionExamples() {
        assertEquals(1, solution.romanToInt("I"));
        assertEquals(2, solution.romanToInt("II"));
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(5, solution.romanToInt("V"));
        assertEquals(6, solution.romanToInt("VI"));
        assertEquals(7, solution.romanToInt("VII"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(10, solution.romanToInt("X"));
        assertEquals(13, solution.romanToInt("XIII"));
        assertEquals(14, solution.romanToInt("XIV"));
        assertEquals(15, solution.romanToInt("XV"));
        assertEquals(17, solution.romanToInt("XVII"));
        assertEquals(19, solution.romanToInt("XIX"));
        assertEquals(25, solution.romanToInt("XXV"));
        assertEquals(34, solution.romanToInt("XXXIV"));
        assertEquals(45, solution.romanToInt("XLV"));
        assertEquals(49, solution.romanToInt("XLIX"));
        assertEquals(50, solution.romanToInt("L"));
        assertEquals(75, solution.romanToInt("LXXV"));
        assertEquals(98, solution.romanToInt("XCVIII"));
        assertEquals(100, solution.romanToInt("C"));
        assertEquals(101, solution.romanToInt("CI"));
        assertEquals(110, solution.romanToInt("CX"));
        assertEquals(500, solution.romanToInt("D"));
        assertEquals(1000, solution.romanToInt("M"));
        assertEquals(900, solution.romanToInt("CM"));
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"));

    }

}