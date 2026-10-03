class Solution {
    public int maxArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length < 2) {
            return 0;
        }

        // amount = (j - i) * Math.min(heights[i], heights[j])
        // use two pointers and alway move the one points to the shorter first
        int i = 0;
        int j = heights.length - 1;
        int result = 0;
        while (i < j) {
            int amount = (j - i) * Math.min(heights[i], heights[j]);
            result = Math.max(result, amount);
            if (heights[i] < heights[j]) {
                i++;
            } else if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }
}
