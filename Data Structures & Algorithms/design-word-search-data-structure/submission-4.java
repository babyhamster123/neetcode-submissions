class WordDictionary {

    private Node root;

    private class Node {
        private boolean isWord;
        private Map<Character, Node> children;

        private Node () {
            isWord = false;
            children = new HashMap<>();
        }
    }

    public WordDictionary() {
        root = new Node();
    }

    // time: O(n) where n is the len of the word
    // space: O(n)
    public void addWord(String word) {
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

    // time: O(n) where n is the size of the trie 
    // space: O(n)
    public boolean search(String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return false;
        }

        return search(word, 0, root);
    }

    private boolean search(String word, int i, Node n) {
        // sanity check
        if (i == word.length()) {
            return n.isWord;
        }

        char c = word.charAt(i);

        // check wild card
        if (c == '.') {
            for (Node child : n.children.values()) {
                if (search(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        // check non wild card
        Node child = n.children.get(c);
        if (child == null) {
            return false;
        }
        return search(word, i + 1, child);
    }
}
