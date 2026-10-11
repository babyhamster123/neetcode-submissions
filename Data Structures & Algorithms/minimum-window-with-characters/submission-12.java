class Solution {

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public String minWindow(String s, String t) {
        // sanity check
        // assume the correct output is alawys unique
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // mapT: freq of char in t
        Map<Character, Integer> mapT = count(t);

        // mapS: freq of char in substring of s between the current window i and j inclusivly
        Map<Character, Integer> mapS = new HashMap<>();

        // use two pointers left i and right j to form a sliding window
        int neededCharCount = mapT.size();
        int resultL = -1;
        int resultR = -1;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);

            int freqInS = mapS.get(c);
            Integer freqInT = mapT.get(c);
            if (freqInT == null) {
                continue;
            }

            if (freqInS < freqInT) {
                continue;
            }

            if (freqInS == freqInT) {
                neededCharCount--; 
            }
            
            // if (freqInS > freqInT) no op as it is fine to have the substring contains more count than the one in t

            // found the local solution
            while (neededCharCount == 0) {
                // move i to shrink the window
                // check and update the global result with the i and j if better
                if (resultL == -1) {
                    resultL = i;
                    resultR = j;
                } else {
                    int localLen = j - i + 1;
                    int globalLen = resultR - resultL + 1;
                    if (localLen < globalLen) {
                        resultL = i;
                        resultR = j;
                    }
                }
                
                // remove the char at i
                c = s.charAt(i);
                mapS.put(c, mapS.get(c) - 1);
                i++;

                freqInS = mapS.get(c);
                freqInT = mapT.get(c);
                if (freqInT == null) {
                    continue;
                }

                if (freqInS > freqInT) {
                    continue;
                }

                /* this should be fine, no op
                if (freqInS == freqInT) {
                */

                if (freqInS < freqInT) {
                    neededCharCount++; 
                    break;
                }
            }
        }

        if (resultL == -1) {
            return "";
        }
        return s.substring(resultL, resultR + 1);
    }
}
