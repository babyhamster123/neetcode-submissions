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
        HelperNode helperNode = f(head, n);
        return helperNode.head;
    }

    private HelperNode f(ListNode head, int n) {
        // termination check
        if (head == null) {
            return new HelperNode(null, 0);
        }
        if (head.next == null) {
            if (n == 1) {
                head = null;
            }
            return new HelperNode(head, 1);
        }

        HelperNode helperNode = f(head.next, n);
        head.next = helperNode.head;
        if (helperNode.length + 1 == n) {
            head = helperNode.head;
        }

        return new HelperNode(head, helperNode.length + 1);
    }

    private class HelperNode {
        private ListNode head;
        private int length;
        private HelperNode(ListNode head, int length) {
            this.head = head;
            this.length = length;
        }
    }
}
