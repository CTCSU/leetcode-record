/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=21914
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {

        int length = matrix.length;
        int chalf = length / 2;
        int rhalf = (length + 1) / 2;
        int last = length - 1;
        for (int i = 0; i < chalf; i++) {
            for (int j = 0; j < rhalf; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[last - j][i];
                matrix[last - j][i] = matrix[last - i][last - j];
                matrix[last - i][last - j] = matrix[j][last - i];
                matrix[j][last - i] = temp;
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
