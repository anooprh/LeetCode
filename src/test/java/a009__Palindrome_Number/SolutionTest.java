package a009__Palindrome_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    Solution solution;
    String url = "https://leetcode.com/problems/palindrome-number/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldTestDescriptionExamples() {
        assertTrue(solution.isPalindrome(121));
        assertTrue(solution.isPalindrome(12321));
        assertTrue(solution.isPalindrome(0));
        assertFalse(solution.isPalindrome(12));
        assertFalse(solution.isPalindrome(-121));
    }

}