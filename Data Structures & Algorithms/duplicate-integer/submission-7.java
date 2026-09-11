/*
We can use set to check the duplicates
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            // if already contain the number, return true
            if (!numSet.add(n)) {
               return true;
            }
        }

        return false;
    }
}