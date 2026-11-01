/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // sanity 
        if (head == null) {
            return null;
        }

        // traverse the LL while keep a map from node to its new copy
        Map<Node, Node> map = new HashMap<>();
        Node curt = head;
        while (curt != null) {
            Node curtCopy = getCopy(curt, map);
            Node nextCopy = getCopy(curt.next, map);
            Node randomCopy = getCopy(curt.random, map);

            curtCopy.next = nextCopy;
            curtCopy.random = randomCopy;

            curt = curt.next;
        }

       return getCopy(head, map);
    }
    
    private Node getCopy(Node n, Map<Node, Node> map) {
        if (n == null) {
            return null;
        }
        
        Node copy = map.get(n);
        if (copy == null) {
            copy = new Node(n.val);
            map.put(n, copy);
        }
        return copy;
    }
}
