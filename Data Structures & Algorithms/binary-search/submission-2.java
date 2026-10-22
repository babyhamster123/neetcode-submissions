class Solution {
    public int search(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // search
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            }

            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return -1;
    }
}
