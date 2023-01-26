/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private boolean result = false;
    private String word;
    private int amount;
    private int m, n;
    private int[] shift = { -1, 0, 1, 0, -1 };

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.amount = word.length();
        this.m = board.length;
        this.n = board[0].length;

        boolean[][] marked = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!result) {
                    marked[i][j] = true;
                    backTracing(i, j, board, marked, 0);
                    marked[i][j] = false;
                }
            }

        }

        return this.result;

    }

    private void backTracing(int i, int j, char[][] board, boolean[][] marked, int level) {
        if (result) {
            return;
        }
        if (board[i][j] == word.charAt(level)) {
            if (level == amount - 1) {
                result = true;
                return;
            } else {
                for (int k = 0; k < shift.length - 1; k++) {
                    int ni = i + shift[k], nj = j + shift[k + 1];
                    if (isValid(ni, nj) && !marked[ni][nj]) {
                        marked[ni][nj] = true;
                        backTracing(ni, nj, board, marked, level + 1);
                        marked[ni][nj] = false;
                    }
                }
            }
        }
        return;
    }
}
// @lc code=end
