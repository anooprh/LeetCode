package a002__Add_Two_Numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;
    private static String url = "https://leetcode.com/problems/add-two-numbers/";
    // ACCEPTED

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void shouldAddTwoLinkedListSum() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode ans = solution.addTwoNumbers(l1, l2);
        assertEquals(new ListNode(7, new ListNode(0, new ListNode(8, null))), ans);
    }

    @Test
    public void shouldAddTwoLinkedListSumUnequalLength() {
        ListNode l1 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode l2 = new ListNode(9, null);

        ListNode ans = solution.addTwoNumbers(l1, l2);
        assertEquals(new ListNode(4, new ListNode(7, new ListNode(4, null))), ans);
    }

    @Test
    public void shouldAddTwoLinkedListSumUnequalLengthRev() {
        ListNode l1 = new ListNode(9, null);
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode ans = solution.addTwoNumbers(l1, l2);
        assertEquals(new ListNode(4, new ListNode(7, new ListNode(4, null))), ans);
    }

    @Test
    public void shouldAddTwoLinkedListNullNull() {
        ListNode ans = solution.addTwoNumbers(null, null);
        assertNull(ans);
    }

    @Test
    public void shouldAddTwoLinkedListNullNumber() {
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode ans = solution.addTwoNumbers(null, l2);
        assertEquals(l2, ans);
    }

    @Test
    public void shouldAddTwoLinkedListNumberNull() {
        ListNode l1 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode ans = solution.addTwoNumbers(l1, null);
        assertEquals(l1, ans);
    }

}