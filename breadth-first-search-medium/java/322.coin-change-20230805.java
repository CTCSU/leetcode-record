import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=21913
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,5]\n11\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n0\n
 * // @lcpr case=end
 * 
 */
