import java.util.Stack;

/*
 * @lc app=leetcode.cn id=547 lang=java
 * @lcpr version=21705
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {

    private int m;
    private int n;
    private int[][] matrix;
    private Stack<Integer> stack = new Stack<>();

    private void init(int m, int n, int[][] matrix) {
        this.m = m;
        this.n = n;
        this.matrix = matrix;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < this.m && j >= 0 && j < this.n;
    }

    public int findCircleNum(int[][] isConnected) {
        init(isConnected.length, isConnected[0].length, isConnected);
        int result = 0;
        for (int i = 0; i < this.m; i++) {
            if (matrix[i][i] == 1) {
                result++;
                dfs(i);
            }
        }

        return result;
    }

    private void dfs(int i) {
        matrix[i][i] = 0;
        for (int j = 0; j < this.n; j++) {
            if (matrix[i][j] == 1 && matrix[j][j] == 1) {
                matrix[i][j] = 0;
                dfs(j);
            }
        }
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
 * // [[1,1,0],[1,1,0],[0,0,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,0,0],[0,1,0],[0,0,1]]\n
 * // @lcpr case=end
 * 
 */
