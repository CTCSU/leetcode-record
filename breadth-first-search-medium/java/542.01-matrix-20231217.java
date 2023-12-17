/*
 * @lc app=leetcode.cn id=542 lang=java
 * @lcpr version=30112
 *
 * [542] 01 Matrix
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int max = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = max;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (i > 0) {
                        mat[i][j] = Math.min(mat[i - 1][j] + 1, mat[i][j]);
                    }
                    if (j > 0) {
                        mat[i][j] = Math.min(mat[i][j - 1] + 1, mat[i][j]);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    mat[i][j] = Math.min(mat[i + 1][j] + 1, mat[i][j]);
                }

                if (j < n - 1) {
                    mat[i][j] = Math.min(mat[i][j + 1] + 1, mat[i][j]);
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
