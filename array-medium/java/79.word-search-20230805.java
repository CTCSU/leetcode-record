/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=21913
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {

    char[][] board;
    String word;
    boolean[][] used;
    int m;
    int n;
    int[] shift = { -1, 0, 1, 0, -1 };

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        this.board = board;
        this.word = word;
        this.used = used;
        this.m = m;
        this.n = n;

        return process();

    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    private boolean process() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrace(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrace(int i, int j, int k) {

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        used[i][j] = true;
        for (int x = 0; x < 4; x++) {
            int ni = shift[x] + i, nj = shift[x + 1] + j;
            if (valid(ni, nj) && !used[ni][nj]) {
                if (backTrace(ni, nj, k + 1)) {
                    return true;
                }

            }
        }
        used[i][j] = false;

        return false;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
 * // @lcpr case=end
 * 
 */
