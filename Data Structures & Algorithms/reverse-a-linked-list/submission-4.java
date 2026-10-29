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
        ListNode curt = head;
        ListNode newHead = curt;
        ListNode next = curt.next;
        if (next != null) {
            curt.next = null;
            newHead = reverseList(next);
            next.next = curt;
        }

        return newHead;
    }
}
