import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=21912
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = i;
            int min = i;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + dp[i - j * j]);
            }
            dp[i] = min;
        }

        return dp[n];

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 13\n
 * // @lcpr case=end
 * 
 */
