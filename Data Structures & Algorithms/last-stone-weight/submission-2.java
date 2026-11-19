class Solution {
    public int lastStoneWeight(int[] stones) {
        // sanity check
        if (stones == null || stones.length == 0) {
            return 0;
        }

        // use pq to keep getting the heaviest stones
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // add all stones to the pq
        // java's built in PQ does not provide a constructor taking the order and collection so it can heapfiy with O(n)
        for (int s : stones) {
            pq.offer(s);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.offer(x - y);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
