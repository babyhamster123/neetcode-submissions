class Solution {
    public int[] productExceptSelf(int[] nums) {
        // sanity check
        // assume we want to keep the orignal input array
        if (nums == null) {
            return null;
        }

        int[] result = new int[nums.length];

        // calculate the total product
        int zeroCount = 0;
        int product = 1;
        for (int n : nums) {
            product = n * product;
            if (n == 0) {
                zeroCount++;
            }
        }

        // handle zero edge cases
        if (zeroCount == 1) {
            return productExceptSelfWithOneZero(nums);
        } else if (zeroCount > 1) {
            return result;
        }

        // divide each num in the new array
        for (int i = 0; i < result.length; i++) {
            result[i] = product / nums[i];
        }

        return result;
    }

    private int[] productExceptSelfWithOneZero(int[] nums) {
        int[] result = new int[nums.length];
        int productOtherThanZero = 1;
        int zeroIndex = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                continue;
            }
            productOtherThanZero = nums[i] * productOtherThanZero;
        }
        
        result[zeroIndex] = productOtherThanZero;
        return result;
    }
}  
