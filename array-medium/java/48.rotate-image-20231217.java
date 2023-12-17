/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30112
 *
 * [48] Rotate Image
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int minusMid = matrix.length / 2;
        int plusMid = (matrix.length + 1) / 2;
        for (int i = 0; i < minusMid; i++) {
            for (int j = 0; j < plusMid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
 * // @lcpr case=end
 * 
 */
