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
        int[] buy = new int[n + 1];
        int[] sell = new int[n + 1];
        sell[0] = 0;
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[j - 1]);
                sell[j] = Math.max(sell[j], buy[j] + prices[j - 1]);
            }
        }

        return sell[n];

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
