/** * Definition for singly-linked list. * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // sanity check
        if (head == null || head.next == null) {
            return;
        }

        // push the list into stack
        Deque<ListNode> stack = getStack(head);

        // reorder
        ListNode curt = head;
        while (curt != null) {
            ListNode next = curt.next;
            ListNode stackTop = stack.pollLast();

            if (curt == stackTop) {
                curt.next = null;
                break;
            }
            curt.next = stackTop;

            if (stackTop == next) {
                stackTop.next = null;
                break;
            }
            stackTop.next = next;

            curt = next;
        }

        return;
    }

    private Deque<ListNode> getStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curt = head;
        while (curt != null) {
            stack.offerLast(curt);
            curt = curt.next;
        }
        return stack;
    }
}
