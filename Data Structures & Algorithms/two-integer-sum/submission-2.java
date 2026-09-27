class Solution {
    public int[] twoSum(int[] nums, int target) {
        // assume input valid and always has one and only one valid pair
        // sanity check

        // create a Map to track num to index for quick look up
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // scan the array from the beginning
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer smallerIndex = numToIndex.get(target - n);
            
            // update the map every time the current num does not find a match
            if (smallerIndex == null) {
                numToIndex.put(n, i);
                continue;
            }

            // once match, the index from the map shall be the smaller one
            return new int[]{smallerIndex, i};
        }

        return null;
    }
}
