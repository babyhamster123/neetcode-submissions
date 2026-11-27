class PrefixTree { private Node root;

    public PrefixTree() {
        root = new Node();
    }

    private class Node {
        private boolean isWord;
        private Map<Character, Node> children;

        private Node () {
            isWord = false;
            children = new HashMap<>();
        }
    }

    // time: O(n) where n is the len of the word
    // space: O(n)
    public void insert(String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return;
        }

        Node curt = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node n = curt.children.get(c);
            if (n == null) {
                n = new Node();
                curt.children.put(c, n);
            }
            curt = n;
        }
        curt.isWord = true;
    }

    // time: O(n) where n is the len of the word
    // space: O(1)
    public boolean search(String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return false;
        }

        Node curt = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node n = curt.children.get(c);
            if (n == null) {
                return false;
            }
            curt = n;
        }
        return curt.isWord;
    }

    // time: O(n) where n is the len of the word
    // space: O(1)
    public boolean startsWith(String prefix) {
        // sanity check
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }

        Node curt = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node n = curt.children.get(c);
            if (n == null) {
                return false;
            }
            curt = n;
        }
        return true;
    }
}
