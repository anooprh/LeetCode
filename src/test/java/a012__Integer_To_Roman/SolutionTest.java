package a012__Integer_To_Roman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution;
    String url = "https://leetcode.com/problems/integer-to-roman/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldTestDescriptionExamples() {
        assertEquals("I",solution.intToRoman(1));
        assertEquals("II",solution.intToRoman(2));
        assertEquals("III",solution.intToRoman(3));
        assertEquals("IV",solution.intToRoman(4));
        assertEquals("V",solution.intToRoman(5));
        assertEquals("VII",solution.intToRoman(7));
        assertEquals("IX",solution.intToRoman(9));
        assertEquals("X",solution.intToRoman(10));
        assertEquals("XIII",solution.intToRoman(13));
        assertEquals("XIV",solution.intToRoman(14));
        assertEquals("XV",solution.intToRoman(15));
        assertEquals("XVII",solution.intToRoman(17));
        assertEquals("XIX",solution.intToRoman(19));
        assertEquals("XXV",solution.intToRoman(25));
        assertEquals("XXXIX",solution.intToRoman(39));
        assertEquals("XLV",solution.intToRoman(45));
        assertEquals("XLIX",solution.intToRoman(49));
        assertEquals("L",solution.intToRoman(50));
        assertEquals("LXXV",solution.intToRoman(75));
        assertEquals("XCVIII",solution.intToRoman(98));
        assertEquals("C",solution.intToRoman(100));
        assertEquals("CI",solution.intToRoman(101));
        assertEquals("CX",solution.intToRoman(110));
        assertEquals("D",solution.intToRoman(500));
        assertEquals("M",solution.intToRoman(1000));
        assertEquals("CM",solution.intToRoman(900));
        assertEquals("MMMCMXCIX",solution.intToRoman(3999));
    }

}