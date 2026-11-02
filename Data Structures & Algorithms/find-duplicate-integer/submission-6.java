class Solution {
    public int findDuplicate(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return -1;
        }

        // slow and fast
        int slowPtr = 0;
        int fastPtr = 0;
        do {
            fastPtr = nums[nums[fastPtr]];
            slowPtr = nums[slowPtr];
        } while(fastPtr != slowPtr);

        
        int newPtr = 0;
        while (newPtr != slowPtr) {
            slowPtr = nums[slowPtr];
            newPtr = nums[newPtr];
        }
        
        return newPtr;
    }
}
