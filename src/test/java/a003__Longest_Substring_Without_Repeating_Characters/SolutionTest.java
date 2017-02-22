package a003__Longest_Substring_Without_Repeating_Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/longest-substring-without-repeating-characters/";
    // ACCEPTED

    @Before
    public void setUp(){
        solution = new Solution();
    }

    @Test
    public void testsFromDescription(){
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb")); // abc
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb")); // b
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew")); // wke

        assertEquals(2, solution.lengthOfLongestSubstring("abba")); // ab
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb")); // ab

    }

}