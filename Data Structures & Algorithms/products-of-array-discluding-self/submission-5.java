class Solution {
    public int[] productExceptSelf(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return null;
        }

        // use prefix array and suffix array to hold the product on the left and right of nums[i] 
        int[] prefix = new int[nums.length];
        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) {
                prefix[i] = 1;
                continue;
            }

            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] suffix = new int[nums.length];
        for (int j = suffix.length - 1; j >= 0; j--) {
            if (j == suffix.length - 1) {
                suffix[j] = 1;
                continue;
            }

            suffix[j] = suffix[j + 1] * nums[j + 1];
        }

        // calculate the final product
        int[] result = new int[nums.length];
        for (int i = 0; i < prefix.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
