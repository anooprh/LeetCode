package a002__Add_Two_Numbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return addTwoNumbers_extraMem(l1, l2);
        return addTwoNumbers_noExtraMem(l1, l2);
    }

    public ListNode addTwoNumbers_extraMem(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0), now, head = prev;
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            now = new ListNode(0);
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            now.val = sum % 10;
            carry = sum / 10;
            prev.next = now;
            prev = now;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (carry != 0) prev.next = new ListNode(carry);
        return head.next;
    }

    public ListNode addTwoNumbers_noExtraMem(ListNode l1, ListNode l2) {
        ListNode t = new ListNode(0), head;
        int sum = 0, carry = 0;

        if (l1 == null) {
            t = l1;
            l1 = l2;
            l2 = t;
        }

        head = l1;
        while (l1 != null) {
            t = l1;
            sum = l1.val + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;

            l1.val = sum % 10;

            l1 = l1.next;
            l2 = (l2 != null ? l2.next : null);
            if (l1 == null && l2 != null) {
                t.next = l2;
                l1 = l2;
                l2 = null;
            }
        }
        if (carry != 0) t.next = new ListNode(carry);
        return head;

    }
}
