class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // sanity check
        // assume the there is always exactly one valid solution

        // use a map to keep track of the num to its index
        // check the map as we scan the input since it is sorted
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            Integer j = map.get(target - n);
            if (j != null) {
                return new int[]{j + 1, i + 1};
            }

            map.put(n, i);
        }

        return new int[0];
    }
}
