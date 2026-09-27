class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // per the problem constaint, answer is alwyas unique for the test cases
        // sanity check
        if (nums == null || k == 0) {
            return null;
        }

        // count the frequency
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // use min heap to keep track of the top k most frequent nums
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            Map.Entry.comparingByValue()
        );

        // scan the map and use the PQ to track the top k
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else if (minHeap.size() == k) {
                Map.Entry<Integer, Integer> head = minHeap.peek();
                if (head.getValue() < e.getValue()) {
                    minHeap.poll();
                    minHeap.offer(e);
                }
            }
        }

        // return all values in the heap
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll().getKey();
        }
        return topK;
    }
}
