import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=309 lang=java
 * @lcpr version=21913
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int length = prices.length + 1;
        int buy[] = new int[length];
        int sell[] = new int[length];
        int cooldown[] = new int[length];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int i = 1; i <= prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i - 1]);
            sell[i] = Math.max(sell[i], buy[i] + prices[i - 1]);
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        return Math.max(cooldown[length - 1], sell[length - 1]);

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,0,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
