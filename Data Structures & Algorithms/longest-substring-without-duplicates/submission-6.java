class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sanity check
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // use two index to create a sliding window
        // i: index on the left
        // j: index on the right
        // set: set consits of unique chars between the window
        int result = 0;
        int i = 0;
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < c.length; j++) {
            while (set.contains(c[j])) {
                set.remove(c[i]);
                i++;
            }

            set.add(c[j]);
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
