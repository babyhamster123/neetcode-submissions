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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // sanity check
        if (head == null || n == 0) {
            return null;
        }

        // f: remove nth from end and return original length of the list
        RemoveResult removeResult = removeFromEnd(head, n);
        return removeResult.head;
    }

    private RemoveResult removeFromEnd(ListNode head, int n) {
        // termination check
        if (head == null) {
            return new RemoveResult(null, 0);
        }

        RemoveResult removeResult = removeFromEnd(head.next, n);
        head.next = removeResult.head;
        if (removeResult.length + 1 == n) {
            head = removeResult.head;
        }

        return new RemoveResult(head, removeResult.length + 1);
    }

    private class RemoveResult {
        private ListNode head;
        private int length;
        private RemoveResult(ListNode head, int length) {
            this.head = head;
            this.length = length;
        }
    }
}
