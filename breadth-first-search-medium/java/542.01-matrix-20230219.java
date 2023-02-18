/*
 * @lc app=leetcode.cn id=542 lang=java
 * @lcpr version=21704
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 != mat[i][j]) {
                    if (i == 0) {
                        if (j == 0) {
                            mat[i][j] = max;
                        } else {
                            mat[i][j] = mat[i][j - 1] + 1;
                        }
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
                if (0 != mat[i][j]) {
                    if (i == m - 1) {
                        if (j == n - 1) {
                            continue;
                        } else {
                            mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                        }
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

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

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
