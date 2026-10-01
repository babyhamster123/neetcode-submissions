class Solution {
    public boolean isValidSudoku(char[][] board) {
        // sanity check
        // per the assumption, board is 9x9 with only digit 1-9 and . denotes empty 

        // check row
        // check column
        // check sub-box 
        return areRowsValid(board) && areColumnsValid(board) && areSubBoxesValid(board);
    }

    private boolean areRowsValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            if (!isValidArray(row)) {
                return false;
            }
        }
        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        char[] column = new char[board.length];
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                column[i] = board[i][j];
            }

            if (!isValidArray(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean areSubBoxesValid(char[][] board) {
        char[] box = new char[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!((i % 3 == 0) && (j % 3 == 0))) {
                    continue;
                }

                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        box[ii * 3 + jj] = board[i + ii][j + jj];
                    }
                }

                if (!isValidArray(box)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidArray(char[] a) {
        Set<Character> charSet = new HashSet<>();
        for (char c : a) {
            if (c == '.') {
                continue;
            }

            if (charSet.contains(c)) {
                return false;
            }

            charSet.add(c);
        }

        return true;
    }
}
