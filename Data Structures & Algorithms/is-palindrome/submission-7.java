class Solution {
    public boolean isPalindrome(String s) {
        // sanity check
        // assmue input consists only ASCII
        if (s == null || s.isEmpty()) {
            return false;
        }
        
        // 1. extra alphanumeric chars
        List<Character> alphanumericList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                alphanumericList.add(c);
            } else if ('A' <= c && c <= 'Z') {
                alphanumericList.add((char)(c - 'A' + 'a'));
            } else if ('0' <= c && c <= '9') {
                alphanumericList.add(c);
            }
        }

        // 2. check is Palindrome with 2 pointers
        for (int i = 0, j = alphanumericList.size() - 1; j >= i; i++, j--) {
            if (!alphanumericList.get(i).equals(alphanumericList.get(j))) {
                return false;
            }
        }

        return true;
    }
}
