import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=417 lang=java
 * @lcpr version=21914
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {

    private int m, n;
    private int[][] heights;
    private int[] shift = { -1, 0, 1, 0, -1 };

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    private void init(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        init(heights);

        boolean[][] pacificAble = new boolean[m][n];
        boolean[][] altlantAble = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            depthFirstSearch(i, 0, pacificAble);
            depthFirstSearch(i, m - 1, altlantAble);
        }

        for (int j = 0; j < n; j++) {
            depthFirstSearch(0, j, pacificAble);
            depthFirstSearch(n - 1, j, altlantAble);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (altlantAble[i][j] && pacificAble[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;

    }

    private void depthFirstSearch(int i, int j, boolean[][] pacificAble) {
        pacificAble[i][j] = true;
        for (int x = 0; x < 4; x++) {
            int ni = i + shift[x], nj = j + shift[x + 1];
            if (valid(ni, nj) && heights[i][j] <= heights[ni][nj] && !pacificAble[ni][nj]) {
                depthFirstSearch(ni, nj, pacificAble);
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1]]\n
 * // @lcpr case=end
 * 
 */
