class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1 == null || s2 == null) {
            return false;
        }

        // map1: char freq map of s1
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // maintain a sliding window of len s1.length
        // map2: char freq map of the window
        // return true if map1.equals(map2)
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0, j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if (j - i + 1 < s1.length()) {
                continue;
            }

            if (map1.equals(map2)) {
                return true;
            }

            // move left index i
            c = s2.charAt(i);
            int f = map2.get(c) - 1;
            if (f == 0) {
                map2.remove(c);
            } else {
                map2.put(c, f);
            }
            i++;
        }

        return false;
    }
}
