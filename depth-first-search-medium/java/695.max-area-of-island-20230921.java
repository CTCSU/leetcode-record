/*
 * @lc app=leetcode.cn id=695 lang=java
 * @lcpr version=21914
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    private int m;
    private int n;
    private int[][] grid;
    private int[] shift = { -1, 0, 1, 0, -1 };

    private boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private void init(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        init(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, depthFirstSearch(i, j));
                }
            }
        }
        return result;
    }

    private int depthFirstSearch(int i, int j) {
        int result = 1;
        grid[i][j] = 0;
        for (int x = 0; x < 4; x++) {
            int ni = i + shift[x], nj = j + shift[x + 1];
            if (valid(ni, nj) && grid[ni][nj] == 1) {
                result += depthFirstSearch(ni, nj);
            }
        }
        return result;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0
 * ,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,
 * 0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,0,0,0,0,0,0,0]]\n
 * // @lcpr case=end
 * 
 */
