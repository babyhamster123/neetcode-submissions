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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            new Comparator<>() {
                public int compare(Integer a, Integer b) {
                    return Integer.compare(countMap.get(a), countMap.get(b));
                }
            }
        );

        // scan the map
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            int n = e.getKey();
            int f = e.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(n);
            } else if (minHeap.size() == k) {
                int head = minHeap.peek();
                if (countMap.get(head) < f) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            }
        }

        // return all values in the heap
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll();
        }
        return topK;
    }
}
