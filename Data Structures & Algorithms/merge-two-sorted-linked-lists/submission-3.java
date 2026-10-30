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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // sanity 
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // merge
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode c1 = list1;
        ListNode c2 = list2;
        while(c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                tail.next = c1;
                tail = c1;
                c1 = c1.next;
            } else {
                tail.next = c2;
                tail = c2;
                c2 = c2.next;
            }
        }

        tail.next = c1 != null ? c1 : c2;
        return dummy.next;
    }
}