class Solution {
    public boolean isValidSudoku(char[][] board) {
        // sanity check
        // per the assumption, board is 9x9 with only digit 1-9 and . denotes empty 
        Set<Character>[] rowSets = new Set[9];
        Set<Character>[] colSets = new Set[9];
        Set<Character>[] subBoxSets = new Set[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                // check row
                if (rowSets[i] == null) {
                    rowSets[i] = new HashSet<>();
                }
                if (rowSets[i].contains(c)) {
                    return false;
                }
                rowSets[i].add(c);

                // check column
                if (colSets[j] == null) {
                    colSets[j] = new HashSet<>();
                }
                if (colSets[j].contains(c)) {
                    return false;
                }
                colSets[j].add(c);

                // check sub box
                int k = (i / 3) * 3 + (j / 3);
                if (subBoxSets[k] == null) {
                    subBoxSets[k] = new HashSet<>();
                }
                if (subBoxSets[k].contains(c)) {
                    return false;
                }
                subBoxSets[k].add(c);
            }
        }

        return true;
    }
}
