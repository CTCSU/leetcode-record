import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=934 lang=java
 * @lcpr version=21401
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    private int[][] grid;
    private int m;
    private int n;
    private final int[] shift = new int[] { -1, 0, 1, 0, -1 };

    private void init(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public int shortestBridge(int[][] grid) {
        init(grid);
        var list = new LinkedList<List<Integer>>();
        boolean needContinue = true;
        for (int i = 0; i < m && needContinue; i++) {
            for (int j = 0; j < n && needContinue; j++) {
                if (grid[i][j] == 1) {
                    depthFirstSearch(i, j, list);
                    needContinue = false;
                }
            }
        }

        int result = 0;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                List<Integer> current = list.removeFirst();
                int i = current.get(0), j = current.get(1);
                for (int x = 0; x < 4; x++) {
                    int ni = i + shift[x], nj = j + shift[x + 1];
                    if (valid(ni, nj)) {
                        if (grid[ni][nj] == 1) {
                            return result;
                        } else if (grid[ni][nj] == 0) {
                            list.add(List.of(ni, nj));
                            grid[ni][nj] = 2;
                        }
                    }
                }
            }
            result++;
        }

        return 0;
    }

    private void depthFirstSearch(int i, int j, List<List<Integer>> list) {
        grid[i][j] = 2;
        list.add(List.of(i, j));
        for (int x = 0; x < 4; x++) {
            int ni = i + shift[x], nj = j + shift[x + 1];
            if (valid(ni, nj) && grid[ni][nj] == 1) {
                depthFirstSearch(ni, nj, list);
            }
        }
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,1],[1,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,1,0],[0,0,0],[0,0,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]\n
 * // @lcpr case=end
 * 
 */
