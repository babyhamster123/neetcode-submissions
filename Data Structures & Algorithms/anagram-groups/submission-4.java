class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sanity check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // create a map, countToGroup, holds
        // charCountMap to group list
        Map<Map<Character, Integer>, List<String>> countToGroup = new HashMap<>();

        // scan the input str to create individual's charCountMap
        for (String s : strs) {
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            // update countToGroup map
            List<String> group = countToGroup.getOrDefault(charCountMap, new ArrayList<>());
            group.add(s);
            countToGroup.put(charCountMap, group);
        }

        // return values of the ccountToGroup map
        return new ArrayList<>(countToGroup.values());
    }
}
