/*
We can use set to check the duplicates
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            // if contains, return true
            if (numSet.contains(n)) {
                return true;
            }

            // add to set
            numSet.add(n);
        }

        return false;
    }
}