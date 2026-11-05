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
    public ListNode mergeKLists(ListNode[] lists) {
        // sanity check
        if (lists == null || lists.length == 0) {
            return null;
        }

        // merge
        ListNode dummy = new ListNode();
        ListNode curt = dummy;
        while (!areAllHeadsNull(lists)) {
            // find min node
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode h = lists[i];
                if (h == null) {
                    continue;
                }
                
                if (minNode == null) {
                    minNode = h; 
                    minIndex = i;
                } else if (minNode.val > h.val) {
                    minNode = h;
                    minIndex = i;
                }
            }

            // extract the min node to the merged list
            curt.next = minNode;
            curt = minNode;
            lists[minIndex] = minNode.next;
            minNode.next = null;
        }

        return dummy.next;
    }

    private boolean areAllHeadsNull(ListNode[] heads) {
        for (ListNode h : heads) {
            if (h != null) {
                return false;
            }
        }
        return true;
    }
}
