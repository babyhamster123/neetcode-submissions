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
            if (nums[left] <= nums[mid]) { // [left, mid] is sorted
                result = Math.min(result, nums[left]);
                left = mid + 1;
            } else { 
                result = Math.min(result, nums[mid]);
                right = mid - 1;
            }
        }

        return result;
    }
}
