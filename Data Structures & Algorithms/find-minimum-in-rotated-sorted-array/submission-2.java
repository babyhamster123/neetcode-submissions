class Solution {
    public int findMin(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // use binary search to check which side of the array is not sorted in ascending order where the possible min sits
        int left = 0;
        int right = nums.length - 1;
        int result = nums[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            result = Math.min(result, min(nums, left, right, mid));

            if (nums[left] <= nums[mid]) { // [left, mid] is sorted
                left = mid + 1;
            } else { 
                right = mid - 1;
            }
        }

        return result;
    }

    private int min(int[] nums, int i, int j, int k) {
        return Math.min(nums[i], Math.min(nums[j], nums[k]));
    }
}
