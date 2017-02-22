package a001__Two_Sum;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SolutionTest {

    private Solution solution;
    private static String url = "https://leetcode.com/problems/two-sum/";
    // ACCEPTED

    @Before
    public void setUp(){
        solution = new Solution();
    }

    @Ignore
    @Test
    public void submitSolution() throws IOException, InterruptedException {}

    @Test
    public void twoSumTestpositive(){
        int[] sol = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(2, sol.length);
        assertTrue((sol[0] == 0 && sol[1] == 1) || sol[0] == 1 && sol[1] == 0 );
    }

    @Test
    public void twoSumTestNegative(){
        int[] sol = solution.twoSum(new int[]{2, 7, 11, 15}, 27);
        assertEquals(0, sol.length);
    }

    // This case never happens as per leetcode description
    @Ignore
    @Test
    public void twoSumTestNegativeRepeat(){
        int[] sol = solution.twoSum(new int[]{2, 2}, 4);
        assertEquals(0, sol.length);
    }
}