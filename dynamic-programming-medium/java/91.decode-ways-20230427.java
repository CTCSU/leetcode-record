/*
 * @lc app=leetcode.cn id=91 lang=java
 * @lcpr version=21801
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        int curNum = s.charAt(0) - '0', previousNum = curNum;
        // int previousValue = 1, curValue = 1;
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            curNum = s.charAt(i - 1) - '0';
            int value = previousNum * 10 + curNum;
            if (curNum == 0) {
                if (previousNum == 0 || previousNum > 2) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if (value > 26 || value < 10) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            previousNum = curNum;
        }

        return dp[n];
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
 * // "12"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "226"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "06"\n
 * // @lcpr case=end
 * 
 */
