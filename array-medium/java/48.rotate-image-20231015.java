/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=21917
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int halflength = length / 2;
        int hlafUpLenght = (length + 1) / 2;
        int lastIndex = length - 1;
        for (int i = 0; i < halflength; i++) {
            for (int j = 0; j < hlafUpLenght; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[lastIndex - j][i];
                matrix[lastIndex - j][i] = matrix[lastIndex - i][lastIndex - j];
                matrix[lastIndex - i][lastIndex - j] = matrix[j][lastIndex - i];
                matrix[j][lastIndex - i] = temp;
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
