package a005__Longest_Palindromic_Substring;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Ignore
    @Test
    public void descriptionTestCases() {
        assertTrue("bab".equals(solution.longestPalindrome("babad")) ||
                "aba".equals(solution.longestPalindrome("babad")));
        assertTrue("bb".equals(solution.longestPalindrome("cbbd")));
    }

}