package a056__Merge_Intervals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {
    Solution solution;
    String url = "https://leetcode.com/problems/merge-intervals/";
    // Accepted

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void descriptionTestCase(){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        ArrayList<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,6));
        expected.add(new Interval(8,10));
        expected.add(new Interval(15,18));


        List<Interval> result = solution.merge(intervals);

        assertEquals(expected, result);
    }

    @Test
    public void shouldCheckBaseCases(){
        ArrayList<Interval> intervals = new ArrayList<>();
        List<Interval> result = solution.merge(intervals);
        assertEquals(intervals, result);

        assertNull(solution.merge(null));
    }

    @Test
    public void shouldCheckCompletelyOverlappingCase(){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,3));

        ArrayList<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,4));

        List<Interval> result = solution.merge(intervals);

        assertEquals(expected, result);

    }

}