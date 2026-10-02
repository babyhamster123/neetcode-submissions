class Solution {
    public int longestConsecutive(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;
        // create a set to keep track of the distinct elements in the input
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        // scan each distinct element to count the sequence begin with it
        for (int n : numSet) {
            if (numSet.contains(n - 1)) {
                continue;
            }

            int count = 1;
            while (numSet.contains(++n)) {
                count++;
            }
            result = Math.max(result, count);
        }
        
        return result;
    }
}
