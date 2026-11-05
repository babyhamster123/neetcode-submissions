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
        PriorityQueue<ListNode> pq = getPriorityQueueWithHeads(lists);
        while (!pq.isEmpty()) {
            // find min node
            ListNode minNode = pq.poll();

            // extract the min node to the merged list
            curt.next = minNode;
            curt = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
            minNode.next = null;
        }

        return dummy.next;
    }

    private PriorityQueue<ListNode> getPriorityQueueWithHeads(ListNode[] heads) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>(){
                public int compare(ListNode a, ListNode b) {
                    if (a.val == b.val) {
                        return 0;
                    } else if (a.val < b.val) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        );
        for (ListNode h : heads) {
            if (h == null) {
                continue;
            }
            pq.offer(h);
        }
        return pq;
    }
}
