class PrefixTree {
    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    private class Node {
        private Set<String> words;
        private Map<Character, Node> children;

        private Node () {
            words = new HashSet<>();
            children = new HashMap<>();
        }
    }

    public void insert(String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return;
        }

        char[] chars = word.toCharArray();
        Node curt = root;
        for (char c : chars) {
            Node n = curt.children.get(c);
            if (n == null) {
                n = new Node();
                curt.children.put(c, n);
            }
            curt = n;
        }
        curt.words.add(word);
    }

    public boolean search(String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return false;
        }

        char[] chars = word.toCharArray();
        Node curt = root;
        for (char c : chars) {
            Node n = curt.children.get(c);
            if (n == null) {
                return false;
            }
            curt = n;
        }
        return curt.words.contains(word);
    }

    public boolean startsWith(String prefix) {
        // sanity check
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }

        char[] chars = prefix.toCharArray();
        Node curt = root;
        for (char c : chars) {
            Node n = curt.children.get(c);
            if (n == null) {
                return false;
            }
            curt = n;
        }
        return true;
    }
}
