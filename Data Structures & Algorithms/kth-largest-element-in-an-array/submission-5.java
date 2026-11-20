class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0 || k < 1) {
            throw new IllegalArgumentException();
        }

        // we keep a min heap of size k containting all the largest nums among the nums
        // therefore, the root of the heap is natually the kth largest num
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
                continue;
            }

            int root = minHeap.peek();
            if (n > root) {
                minHeap.poll();
                minHeap.offer(n);
            }
        }

        return minHeap.peek();
    }
}
