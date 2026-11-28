class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // sanity check
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }

        // build trie from the words to search
        Node root = buildTrie(words);

        // scan the board cell one by one to start a search in the trie
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, visited, result);
            }
        }
        
        return result;
    }

    private void search(char[][] board, int i, int j, Node root, boolean[][] visited, List<String> result) {
        // sanity check
        if (isOutOfBound(board, i, j) || visited[i][j]) {
            return;
        }

        // search
        char c = board[i][j];
        Node n = root.children.get(c);
        if (n == null) {
            return;
        }

        if (n.word != null) {
            result.add(n.word);
            n.word = null;
        }

        visited[i][j] = true;
        search(board, i - 1, j, n, visited, result);
        search(board, i + 1, j, n, visited, result);
        search(board, i, j - 1, n, visited, result);
        search(board, i, j + 1, n, visited, result);
        visited[i][j] = false;
    }

    private boolean isOutOfBound(char[][] board, int i, int j) {
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length;
    }

    private class Node {
        private String word = null;
        private Map<Character, Node> children = new HashMap<>();
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for (String w : words) {
            insert(root, w);
        }
        return root;
    }

    // time: O(n) where n is the len of the word
    // space: O(n)
    private void insert(Node root, String word) {
        // sanity check
        if (word == null || word.isEmpty()) {
            return;
        }

        Node curt = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node n = curt.children.get(c);
            if (n == null) {
                n = new Node(); curt.children.put(c, n);
            }
            curt = n;
        }
        curt.word = word;
    }
}
