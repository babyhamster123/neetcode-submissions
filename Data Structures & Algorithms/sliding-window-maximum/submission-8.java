class Solution {
    private class MaxStack {
        private Deque<Integer> values = new ArrayDeque<>();
        private Deque<Integer> maximums = new ArrayDeque<>();

        private void push(int value) {
            int maximum = isEmpty()
                    ? value
                    : Math.max(value, maximums.peek());

            values.push(value);
            maximums.push(maximum);
        }

        private int pop() {
            maximums.pop();
            return values.pop();
        }

        private int getMax() {
            return maximums.peek();
        }

        private boolean isEmpty() {
            return values.isEmpty();
        }
    }

    private class MaxQueue {
        private MaxStack inStack = new MaxStack();
        private MaxStack outStack = new MaxStack();

        private void offer(int value) {
            inStack.push(value);
        }

        private int poll() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        private int getMax() {
            if (inStack.isEmpty()) {
                return outStack.getMax();
            }
            if (outStack.isEmpty()) {
                return inStack.getMax();
            }
            return Math.max(inStack.getMax(), outStack.getMax());
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue queue = new MaxQueue();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);

            if (i >= k) {
                queue.poll();
            }

            if (i >= k - 1) {
                result[i - k + 1] = queue.getMax();
            }
        }

        return result;
    }
}