/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=21917
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {

        int leng = matrix.length;
        int minusLeng = leng - 1;
        int half = leng / 2;
        int halfUp = (leng + 1) / 2;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < halfUp; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[minusLeng - j][i];
                matrix[minusLeng - j][i] = matrix[minusLeng - i][minusLeng - j];
                matrix[minusLeng - i][minusLeng - j] = matrix[j][minusLeng - i];
                matrix[j][minusLeng - i] = temp;

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
