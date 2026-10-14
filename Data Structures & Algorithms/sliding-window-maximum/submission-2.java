class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < k) {
            return null;
        }

        // maintain a descinding deque (window), consists of index only
        // peekFirst() gives the max
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // expire
            if (!dq.isEmpty() && (i - dq.peekFirst() + 1 > k)) {
                dq.pollFirst();
            }

            // clean no larger predecessors
            // does it matter from last or first?
            while (!dq.isEmpty() && nums[dq.peekLast()] <= n) {
                dq.pollLast();
            }

            // add new element
            dq.offerLast(i);

            // record max
            if (i + 1 >= k) {
                result[j] = nums[dq.peekFirst()];
                j++;
            }
        }

        return result;
    }
}
