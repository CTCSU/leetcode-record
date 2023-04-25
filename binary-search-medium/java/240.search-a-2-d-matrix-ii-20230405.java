/*
 * @lc app=leetcode.cn id=240 lang=java
 * @lcpr version=21801
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    int[][] matrix;
    int target;
    int m;
    int n;

    private boolean search(int i, int j, int li, int lj) {
        if (i == li && j == lj) {
            return matrix[i][j] == target;
        }

        int mid_i = (int) Math.floor((i + li) / 2);
        int mid_j = (int) Math.floor((j + lj) / 2);

        if (target == matrix[mid_i][mid_j]) {
            return true;
        } else if (target > matrix[mid_i][mid_j]) {
            return search(i, j, mid_i, mid_j) || search(mid_i + 1, j, li, mid_j - 1)
                    || search(i, mid_j + 1, mid_i - 1, lj);
        } else {
            return search(mid_i, mid_j, li, lj) || search(mid_i + 1, j, li, mid_j - 1)
                    || search(i, mid_j + 1, mid_i - 1, lj);
        }

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        this.m = matrix.length;
        this.n = matrix[0].length;
        return search(0, 0, this.m - 1, this.n - 1);
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
 * //
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 * \n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 * \n20\n
 * // @lcpr case=end
 * 
 */
