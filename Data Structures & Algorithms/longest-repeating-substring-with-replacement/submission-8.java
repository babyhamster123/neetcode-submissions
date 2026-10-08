class Solution {
    public int characterReplacement(String s, int k) {
        // sanity check
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // maintain a maxF: is the max frequency of a char seen so far 
        // valid winodw: window.length - maxF <= k
        int result = 0;
        int maxF = 0;
        HashMap<Character, Integer> charToFreq = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int f = charToFreq.getOrDefault(c, 0) + 1;
            charToFreq.put(c, f);
            maxF = Math.max(maxF, f);

            while (j - i + 1 - maxF > k) {
                c = s.charAt(i);
                f = charToFreq.get(c) - 1;
                charToFreq.put(c, f);
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
