class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // sanity check
        // assume the there is always exactly one valid solution

        // use two pointers to scan the right pair
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[0];
    }
}
