import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=547 lang=java
 * @lcpr version=30109
 *
 * [547] Number of Provinces
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length - 1;
        int provinceCount = 0;
        boolean[] count = new boolean[isConnected.length];
        for (int i = 0; i <= n; i++) {
            if (!count[i]) {
                mark(isConnected, count, i);
                provinceCount++;
            }
        }

        return provinceCount;

    }

    private void mark(int[][] isConnected, boolean[] count, int i) {
        count[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (!count[j] && isConnected[i][j] == 1) {
                mark(isConnected, count, j);
            }
        }

    }

}
// @lc code=end

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
