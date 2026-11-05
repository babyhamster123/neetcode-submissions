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
    public ListNode reverseKGroup(ListNode head, int k) {
        // sanity check
        if (head == null || k <= 1) {
            return head;
        }

        // find the tail of this k group, return null if not enough
        ListNode tail = findKthNode(head, k);
        if (tail == null) {
            return head;
        }
        ListNode nextHead = tail.next;

        // reverse the current group
        tail.next = null;
        tail = head;
        head = reverse(head);

        // reverse the next group and connect it with the current group
        nextHead = reverseKGroup(nextHead, k);
        tail.next = nextHead;

        // return head
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode curt = head;
        ListNode prev = null;
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }

    private ListNode findKthNode(ListNode head, int k) {
        int count = 0;
        ListNode curt = head;
        while(curt != null) {
            count++;
            if (count == k) {
                return curt;
            }
            curt = curt.next;
        }
        return null;
    }
}
