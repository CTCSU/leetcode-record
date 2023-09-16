import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=934 lang=java
 * @lcpr version=21913
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    private int m;
    private int n;
    private int[][] matrix;
    private int[] shift = new int[] { -1, 0, 1, 0, -1 };
    LinkedList<List<Integer>> stack = new LinkedList<>();

    private void init(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && i < this.m && j >= 0 && j < this.n;
    }

    public int shortestBridge(int[][] grid) {

        init(grid);

        boolean continueSearch = true;
        for (int i = 0; i < m && continueSearch; i++) {
            for (int j = 0; j < n && continueSearch; j++) {
                if (matrix[i][j] == 1) {
                    continueSearch = false;
                    depthSearch(i, j);
                }
            }
        }

        // System.out.println("after deep" + Arrays.deepToString(matrix));
        // System.out.println("stack: ");
        // stack.stream().forEach(t -> System.out.println("node" + t.get(0) +
        // t.get(1)));

        int result = 0;
        while (!stack.isEmpty()) {
            int count = stack.size();
            while (count-- > 0) {
                List<Integer> currentNode = stack.removeFirst();
                for (int x = 0; x < 4; x++) {
                    int ni = currentNode.get(0) + shift[x], nj = currentNode.get(1) + shift[x + 1];
                    if (valid(ni, nj)) {
                        switch (matrix[ni][nj]) {
                            case 0:
                                matrix[ni][nj] = 2;
                                stack.add(List.of(ni, nj));
                                break;
                            case 1:
                                return result;
                            default:
                                break;

                        }
                    }

                }
            }
            result++;
        }

        // System.out.println("after deep" + Arrays.deepToString(matrix));
        // System.out.println("stack: ");
        // stack.stream().forEach(t -> System.out.println("node" + t.get(0) +
        // t.get(1)));

        return result;
    }

    private void depthSearch(int i, int j) {

        this.matrix[i][j] = 2;
        stack.add(List.of(i, j));
        for (int x = 0; x < 4; x++) {
            int ni = i + shift[x], nj = j + shift[x + 1];
            if (valid(ni, nj) && this.matrix[ni][nj] == 1) {
                depthSearch(ni, nj);
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
