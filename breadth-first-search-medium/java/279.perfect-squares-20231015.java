/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=21917
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
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
