class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1 == null || s2 == null) {
            return false;
        }

        // diffMap: keep the char to freq of the difference between s1 and the window of s2 
        Map<Character, Integer> diffMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            diffMap.put(c, diffMap.getOrDefault(c, 0) + 1);
        }

        // maintain a sliding window of len s1.length
        // return true if diffMap is empty
        for (int i = 0, j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            int f = diffMap.getOrDefault(c, 0) - 1;
            if (f == 0) {
                diffMap.remove(c);
            } else {
                diffMap.put(c, f);
            }
            if (j - i + 1 < s1.length()) {
                continue;
            }

            if (diffMap.isEmpty()) {
                return true;
            }

            // move left index i
            c = s2.charAt(i);
            f = diffMap.getOrDefault(c, 0) + 1;
            if (f == 0) {
                diffMap.remove(c);
            } else {
                diffMap.put(c, f);
            }
            i++;
        }

        return false;
    }
}
