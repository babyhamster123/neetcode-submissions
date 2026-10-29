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
    public ListNode reverseList(ListNode head) {
        // sanity check
        if (head == null) {
            return null;
        }

        // reverse
        ListNode prev = null;
        ListNode curt = head;
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }

        return prev;
    }
}
