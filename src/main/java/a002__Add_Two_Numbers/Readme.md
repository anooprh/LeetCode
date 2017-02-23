#[Add Two Numbers](https://leetcode.com/problems/add-two-numbers)

### Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
### Observation

There are two assumptions here.

1. No leading zeros
2. The linked list is reverse number notation

Example given 

````
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
````

### Solution

The algorithm for this problem seems straight forward. 

````
ptr1 = head of linked list 1
ptr2 = head of linked list 2
carry = 0
while(both ptr's have not reached end of List)
    Result digit = (ptr1.val + ptr2.val + carry) % 10
    Carry = (ptr1.val + ptr2.val + carry) / 10
    Advance ptr1 and ptr2 to next element
If carry remains, add a new node to represent the carry
````
However, we should be careful of few scenarios while solving this.

1. Where the two lists are unequal length. 
2. When the carry after both pointers reach end of the loop is not zero. 

(1) can be handled by doing the null check before advancing the pointer, and (2) can be handled if we check the carry after the end of the loop


  
```Java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
```
We see that this creates new nodes for the result list to store the digits. However, we can reuse one of the existing Lists L1 or L2 and write back the result to that List.

```Java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
```

### Analysis

The time complexity of solution(1) is __O(max(n1,n2))__ where n1 is the length of Linked List L1 and n2 is the Length of LinkedList L2. Since we are creating a new LinkedList for the result, the Auxillary space complexity is __O(max(n1,n2))__

In Solution(2) the time complexity same i.e __O(max(n1,n2))__, however the space complexity is O(1)