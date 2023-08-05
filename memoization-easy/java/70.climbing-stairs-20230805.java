/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=21913
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // int dp[] = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        // dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // return dp[n];
        int pre0 = 1, pre1 = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = pre0 + pre1;
            pre0 = pre1;
            pre1 = cur;
        }

        return cur;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 */
