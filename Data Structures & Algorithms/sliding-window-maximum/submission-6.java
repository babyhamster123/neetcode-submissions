class Solution {
    private class MaxStack {
        private Deque<Integer> values = new ArrayDeque<>();
        private Deque<Integer> maximums = new ArrayDeque<>();

        void push(int value) {
            int maximum = isEmpty()
                    ? value
                    : Math.max(value, maximums.peek());

            values.push(value);
            maximums.push(maximum);
        }

        int pop() {
            maximums.pop();
            return values.pop();
        }

        int getMax() {
            return maximums.peek();
        }

        boolean isEmpty() {
            return values.isEmpty();
        }
    }

    private class MaxQueue {
        private MaxStack inStack = new MaxStack();
        private MaxStack outStack = new MaxStack();

        void push(int value) {
            inStack.push(value);
        }

        int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        int getMax() {
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
            queue.push(nums[i]);

            if (i >= k) {
                queue.pop();
            }

            if (i >= k - 1) {
                result[i - k + 1] = queue.getMax();
            }
        }

        return result;
    }
}