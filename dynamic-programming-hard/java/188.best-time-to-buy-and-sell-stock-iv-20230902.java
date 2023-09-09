import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=188 lang=java
 * @lcpr version=21913
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int buy[][] = new int[k + 1][n + 1];
        int sell[][] = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(buy[i], Integer.MIN_VALUE);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], Math.max(buy[i][j - 1], sell[i - 1][j] - prices[j - 1]));
                sell[i][j] = Math.max(sell[i - 1][j], Math.max(sell[i][j - 1], buy[i][j] + prices[j - 1]));
            }
        }

        return Arrays.stream(sell[k]).max().getAsInt();

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n[2,4,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[3,2,6,5,0,3]\n
 * // @lcpr case=end
 * 
 */
