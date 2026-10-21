class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // sanity check
        if (temperatures == null) {
            return null;
        }

        // use monotonic stack, stack only keeps descending order, store the index not the acutal temp
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                int j = stack.pollLast();
                result[j] = i - j;
            }

            stack.offerLast(i);
        }

        // no need to assign the rest left in stack whose result is all 0
        return result;
    }
}
