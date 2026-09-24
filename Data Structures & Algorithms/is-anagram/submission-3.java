class Solution {
    public boolean isAnagram(String s, String t) {
        // sanity check
        if (s.equals(t)) {
            return true;
        }
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            // if not contains, return false
            // if count == 1, then delete key, else --
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            } else if (count == 1) {
                charCountMap.remove(c);
                continue;
            }

            charCountMap.put(c, count - 1);
        }
        
        return charCountMap.isEmpty();
    }
}
