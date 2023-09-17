import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=221 lang=java
 * @lcpr version=21913
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] intCount = new int[m][n];
        boolean hasOne = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    intCount[i][j] = 1;
                    hasOne = true;
                }
            }
        }
        if (!hasOne) {
            return 0;
        }

        int max = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (intCount[i][j] == 1) {
                    intCount[i][j] = Math.min(Math.min(intCount[i - 1][j - 1], intCount[i][j - 1]), intCount[i - 1][j])
                            + 1;
                    max = Math.max(max, intCount[i][j]);
                }
            }
        }

        return max * max;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0",
 * "0","1","0"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["0","1"],["1","0"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["0"]]\n
 * // @lcpr case=end
 * 
 */
