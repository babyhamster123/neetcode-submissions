class Solution {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // use non-descendoing monotonic stack, from left to right, to fill an array
        // the stack keep only the indiecs of the heights
        // the array answers with the current height, how far can the rectengle stratch to the right
        // the array store the index of the furtheest index whose height is smaller than the current height 
        // for indices left in the stack, they are able to strach to the right end so we will fill them with index heights.length
        // similarly, aother array to stratch to the left
        Deque<Integer> stack = new ArrayDeque<>();
        int[] rightIndex = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                rightIndex[stack.pollLast()] = i;
            }
            
            stack.offerLast(i);
        }

        // fill the rightIndex for elements left in the stack
        while (!stack.isEmpty()) {
            rightIndex[stack.pollLast()] = rightIndex.length;
        }
        
        // again from right to left
        int[] leftIndex = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                leftIndex[stack.pollLast()] = i;
            }
            
            stack.offerLast(i);
        }

        while (!stack.isEmpty()) {
            leftIndex[stack.pollLast()] = -1;
        }

        // calcuate each rectangle and keep the max to return
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (rightIndex[i] - leftIndex[i] - 1));
        }
        return result;
    }
}
