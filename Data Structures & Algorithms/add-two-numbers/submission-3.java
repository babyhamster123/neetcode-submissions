/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // sanity check
        if (l1 == null && l2 == null) {
            return null;
        }

        // add digit by digit
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int carry = 0;
        while (c1 != null || c2 != null) {
            int v1 = c1 == null ? 0 : c1.val;
            int v2 = c2 == null ? 0 : c2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int v3 = sum % 10; 
            ListNode c3 = new ListNode(v3);
            prev.next = c3;

            if (c1 != null) {
                c1 = c1.next;
            }
            if (c2 != null) {
                c2 = c2.next;
            }
            prev = prev.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
