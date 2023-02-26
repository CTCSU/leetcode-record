/*
 * @lc app=leetcode.cn id=309 lang=java
 * @lcpr version=21704
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[] buy = new int[m + 1];
        int[] cooldown = new int[m + 1];
        int[] sell = new int[m + 1];
        buy[0] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            buy[i + 1] = Math.max(buy[i], cooldown[i] - prices[i]);
            sell[i + 1] = Math.max(sell[i], buy[i] + prices[i]);
            cooldown[i + 1] = Math.max(cooldown[i], sell[i]);
        }

        return Math.max(cooldown[m], sell[m]);

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

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
