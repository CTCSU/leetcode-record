import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=188 lang=java
 * @lcpr version=21704
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];

        // for (int i = 1; i <= k; i++) {
        // for (int j = 0; j < prices.length; j++) {
        // buy[i] = Math.max(buy[i], sell[i - 1] - prices[j]);
        // sell[i] = Math.max(sell[i], buy[i] + prices[j]);
        // }
        // }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k];

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
 * // 2\n[2,4,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[3,2,6,5,0,3]\n
 * // @lcpr case=end
 * 
 */
