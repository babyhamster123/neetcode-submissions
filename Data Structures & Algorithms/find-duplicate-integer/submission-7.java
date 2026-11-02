class Solution {
    public int findDuplicate(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return -1;
        }

        // use Set to keep track of duplicaton
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }

            set.add(n);
        }

        return -1;
    }
}
