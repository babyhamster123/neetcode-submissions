class Solution {
    public boolean isAnagram(String s, String t) {
        // sanity check
        if (t.length() != s.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            // when the count is 1, remove the key
            // when the count is 0, return false
            // else decrease the count by 1 
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            } else if (count == 1) {
                charCountMap.remove(c);
                continue;
            } else {
                charCountMap.put(c, count - 1);
            }
        }
        
        return charCountMap.isEmpty();
    }
}
