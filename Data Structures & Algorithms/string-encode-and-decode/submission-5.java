class Solution {
    private static final String separator = "#";

    public String encode(List<String> strs) {
        // sanity check
        if (strs == null || strs.isEmpty()) {
            return null;
        }

        // build a string
        StringBuilder sb = new StringBuilder();

        // append each string in format len#str
        for (String s : strs) {
            sb.append("" + s.length() + separator + s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        // sanity check
        if (str == null || str.isEmpty()) {
            return result;
        }

        StringBuilder len = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == separator.charAt(0)) {
                // append string and reset
                int lenInt = Integer.parseInt(len.toString());
                StringBuilder decodedStr = new StringBuilder();
                for (int j = 0; j < lenInt; j++) {
                    decodedStr.append(charArray[i + 1 + j]);
                }
                result.add(decodedStr.toString());

                i = i + lenInt;
                len.setLength(0);
                continue;
            }

            // process len
            len.append(c);
        }

        return result;
    }
}
