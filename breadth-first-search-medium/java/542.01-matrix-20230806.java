/*
 * @lc app=leetcode.cn id=542 lang=java
 * @lcpr version=21913
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (i == 0 && j == 0) {
                        mat[i][j] = m + n;
                    } else if (i == 0) {
                        mat[i][j] = mat[i][j - 1] + 1;
                    } else if (j == 0) {
                        mat[i][j] = mat[i - 1][j] + 1;
                    } else {
                        mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {

                    if (i == m - 1 && j == n - 1) {

                    } else if (i == m - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                    } else if (j == n - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    } else {
                        mat[i][j] = Math.min(mat[i][j], Math.min(mat[i + 1][j], mat[i][j + 1]) + 1);
                    }
                }

            }
        }

        return mat;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,0,0],[0,1,0],[0,0,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,0,0],[0,1,0],[1,1,1]]\n
 * // @lcpr case=end
 * 
 */
