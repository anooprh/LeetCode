package a005__Longest_Palindromic_Substring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/longest-palindromic-substring/";
    // Accepted, but runs in O(n^2). Can optimize to O(n)

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void descriptionTestCases() {
        assertTrue("bab".equals(solution.longestPalindrome("babad")) ||
                "aba".equals(solution.longestPalindrome("babad")));
        assertTrue("bb".equals(solution.longestPalindrome("cbbd")));
    }

}