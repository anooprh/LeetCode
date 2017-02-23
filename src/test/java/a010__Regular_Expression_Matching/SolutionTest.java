package a010__Regular_Expression_Matching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    Solution solution;
    String url = "https://leetcode.com/problems/regular-expression-matching/";
    // Accepted


    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldTestDescriptionExamples() {
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "aa"));
        assertFalse(solution.isMatch("aaa", "aa"));
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("aa", ".*"));
        assertTrue(solution.isMatch("ab", ".*"));
        assertTrue(solution.isMatch("aab", "c*a*b"));
        assertFalse(solution.isMatch("ab", ".*c"));
    }
}